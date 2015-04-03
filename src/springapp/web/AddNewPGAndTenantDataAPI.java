package springapp.web;

import java.util.List;

import javax.validation.Valid;

import models.PGDataModel;
import models.TenantDataModel;
import models.UserNameToken;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import forms.PGAndTenantData;
//import validators.AddNewPGDataValidator;
import validators.PGandTenantDataValidator;

@Controller
public class AddNewPGAndTenantDataAPI {

	@RequestMapping(value = "/addnewpgandtenantdata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PGAndTenantData addNewPGandTenantData(
			 @RequestBody PGAndTenantData pgAndTenantData)
			throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		// check in token db extract token for this username nd match with
		// received token

		String token = mongoOperation
				.findOne(
						new Query(Criteria.where("username").is(
								pgAndTenantData.getUsername())), UserNameToken.class)
				.gettoken();

		// TOKEN AUTHENTICATION FAILURE:
		if (!token.equals(pgAndTenantData.getToken()))
			return new PGAndTenantData("Failure", "Token authentication failed");

		// session expired please login again; will code later

//		 DATA VALIDATION FAILURE:
//		AddNewPGDataValidator addNewPGDataValidator = new AddNewPGDataValidator();
//		addNewPGDataValidator.validate(pgAndTenantData, bindingResult);
		List<String> errorfieldandstring= PGandTenantDataValidator.validate(pgAndTenantData);
		
//		if (bindingResult.hasErrors())
//			return new PGAndTenantData("Failure", "Data validation failed");
		if(errorfieldandstring.size()!=0)
			return new  PGAndTenantData("Failure", "Data validation failed", errorfieldandstring);

		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION GENERATE
		// UNIQUE ID AND SAVE DATA
		mongoOperation.save(new PGDataModel(pgAndTenantData.getpropertyId(), pgAndTenantData.getPgdata()));
		mongoOperation.save(new TenantDataModel(pgAndTenantData.getpropertyId(), pgAndTenantData.getpgtenantlist()));
		return new PGAndTenantData("Success", "Data successfully stored on server");
	}

}
