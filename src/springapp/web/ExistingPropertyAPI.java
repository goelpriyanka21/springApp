package springapp.web;

import models.AuthenticationDetails;
import models.BuildingDataModel;
import models.PGDataModel;
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

import forms.ExistingPropertyData;
import validators.TokenValidator;

@Controller
public class ExistingPropertyAPI {

	@RequestMapping(value = "/existingpropertydata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ExistingPropertyData addEntry(
			@RequestBody ExistingPropertyData existingPropertyData)
			throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		// AuthenticationDetails Validators
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(
						existingPropertyData.getUsername())),
				AuthenticationDetails.class);

		if (authenticationDetails == null)
			return new ExistingPropertyData("Failure",
					"Username does not exist");

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(existingPropertyData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				existingPropertyData.getToken()))
			return new ExistingPropertyData("Failure",
					"Token authentication failed");

		if (existingPropertyData.getPropertyId() == null)
			return new ExistingPropertyData("Failure",
					"Please provide a propertyId");

		PGDataModel pgDataModel = mongoOperation.findOne(new Query(Criteria
				.where("propertyId").is(existingPropertyData.getPropertyId())),
				PGDataModel.class);
		BuildingDataModel buildingDataModel = mongoOperation.findOne(
				new Query(Criteria.where("propertyId").is(
						existingPropertyData.getPropertyId())),
				BuildingDataModel.class);

		if (pgDataModel == null && buildingDataModel == null)
			return new ExistingPropertyData("Entry does not exist",
					"call add entry API");
		else {
			if (pgDataModel != null) { // pg already exists

				return new ExistingPropertyData(pgDataModel);
			} else {
				return new ExistingPropertyData(buildingDataModel);
			}

		}

	}

}
