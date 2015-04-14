package springapp.web;

import helperclasses.ErrorFieldAndMessage;
import helperclasses.XmlApplicationContext;

import java.util.List;

import models.AuthenticationDetails;
import models.PGDataModel;
import models.TenantDataModel;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.PGandTenantDataValidator;
import validators.TokenValidator;
import forms.PGAndTenantData;
import forms.PostForm;

@Controller
public class AddNewPGAndTenantDataAPI {

	@RequestMapping(value = "/addnewpgandtenantdata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewPGandTenantData(
			@RequestBody PGAndTenantData pgAndTenantData) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		// AuthenticationDetails Validators
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(
						pgAndTenantData.getUsername())),
				AuthenticationDetails.class);

		if (authenticationDetails == null)
			return new PostForm("Failure", "Username does not exist");

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(pgAndTenantData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				pgAndTenantData.getToken()))
			return new PostForm("Failure", "Token authentication failed");

		// session expired please login again; will code later

		// DATA VALIDATION FAILURE:
		List<ErrorFieldAndMessage> errorfieldandstringlist = PGandTenantDataValidator
				.validate(pgAndTenantData);

		if (errorfieldandstringlist.size() != 0)
			return new PostForm("Failure", "Data validation failed",
					errorfieldandstringlist);

		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION GENERATE

		// if tenant data!null; save tenant data
		// if pg data ! null; if unique propertyId is not existing in db; fine; save pg
		// data 
		// if unique propertyId is existing; if is locked is false ; update pg data
		// if is locked is true; status: entry already exist; u can add only
		// tenant data; pg entry already exist & is locked

		if (pgAndTenantData.getpgtenantlist() != null)
			mongoOperation.save(new TenantDataModel(pgAndTenantData
					.getpropertyId(), pgAndTenantData.getpgtenantlist()));
		
		if (pgAndTenantData.getPgdata() != null) { // has some pg data
			Query query= new Query();
			query.addCriteria(Criteria
					.where("propertyId").is(pgAndTenantData.getPropertyId()));
			PGDataModel pgDataModel = mongoOperation.findOne(query,
					PGDataModel.class);
			if (pgDataModel == null) // unique propertyId is not existing in db
				mongoOperation.save(new PGDataModel(pgAndTenantData
						.getpropertyId(), pgAndTenantData.getPgdata(), pgAndTenantData.getUsername()));
			else
			{
				if(pgDataModel.getIsLocked()== true){
					return new PostForm("Failure", "PG Entry already exist and is locked u can add only tenant data");
				}
				else // is locked is false; u can update pg data
				{
					 String createdBy_username= pgDataModel.getCreatedBy_username();
					 String createdDate= pgDataModel.getCreatedDate();
					mongoOperation.remove(query, PGDataModel.class);
					mongoOperation.save(new PGDataModel(pgAndTenantData
							.getpropertyId(), pgAndTenantData.getPgdata(), createdBy_username, createdDate, pgAndTenantData.getUsername()));
					return new PostForm("Success", "Data successfully updated on server");
				}
			}
		}
		return new PostForm("Success", "Data successfully stored on server");
	}

}
