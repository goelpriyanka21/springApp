package springapp.web;

import helperclasses.ErrorFieldAndMessage;

import java.util.List;

import models.AuthenticationDetails;
import models.BuildingDataModel;
import models.FlatDataModel;
import models.UserNameToken;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import forms.BuildingAndFlatData;
import forms.PostForm;
import validators.AuthenticationDetailsValidator;
import validators.BuildingAndFlatDataValidator;
import validators.TokenValidator;

@Controller
public class AddNewBuildingAndFlatDataAPI {

	@RequestMapping(value = "/addnewbuildingandflatdata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewPGandTenantData(
			@RequestBody BuildingAndFlatData buildingAndFlatData)
			throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		// AuthenticationDetails Validator
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(new Query(Criteria
				.where("username").is(buildingAndFlatData.getUsername())),
				AuthenticationDetails.class);

		if (authenticationDetails == null)
			return new PostForm("Failure", "Username does not exist");

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(buildingAndFlatData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				buildingAndFlatData.getToken()))
			return new PostForm("Failure", "Token authentication failed");

		// session expired please login again; will code later

		List<ErrorFieldAndMessage> errorfieldandstringlist = BuildingAndFlatDataValidator
				.validate(buildingAndFlatData);

		if (errorfieldandstringlist.size() != 0)
			return new PostForm("Failure", "Data validation failed",
					errorfieldandstringlist);

		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION GENERATE
		// UNIQUE ID AND SAVE DATA
		mongoOperation.save(new BuildingDataModel(buildingAndFlatData
				.getPropertyId(), buildingAndFlatData.getBuildingData()));
		mongoOperation.save(new FlatDataModel(buildingAndFlatData
				.getPropertyId(), buildingAndFlatData.getFlatData()));
		return new PostForm("Success", "Data successfully stored on server");
	}

}
