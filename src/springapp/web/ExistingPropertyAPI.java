package springapp.web;

import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;
import models.AuthenticationDetails;
import models.BuildingDataModel;
import models.PGDataModel;
import models.TestingData;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.TokenValidator;
import forms.ExistingPropertyData;

@Controller
public class ExistingPropertyAPI {

	@RequestMapping(value = "/existingpropertydata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ExistingPropertyData addEntry(
			@RequestBody ExistingPropertyData existingPropertyData)
			throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();
		
		mongoOperation.save(new TestingData(existingPropertyData));

		// AuthenticationDetails Validators
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(
						existingPropertyData.getUsername())),
				AuthenticationDetails.class);
		
		ExistingPropertyData existingPropertyDataret;
		if (authenticationDetails == null){
			existingPropertyDataret = new ExistingPropertyData(STATUS.Failure,
					"Username does not exist");
			mongoOperation.save(new TestingData(existingPropertyDataret));
			return existingPropertyDataret;
		}

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(existingPropertyData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				existingPropertyData.getToken())){
			existingPropertyDataret = new ExistingPropertyData(STATUS.Failure,
					"Token authentication failed");
			mongoOperation.save(new TestingData(existingPropertyDataret));
			return existingPropertyDataret;
		}

		if (existingPropertyData.getPropertyId() == null){
			existingPropertyDataret = new ExistingPropertyData(STATUS.Failure,
					"Please provide a propertyId");
			mongoOperation.save(new TestingData(existingPropertyDataret));
			return existingPropertyDataret;
		}

		PGDataModel pgDataModel = mongoOperation.findOne(new Query(Criteria
				.where("propertyId").is(existingPropertyData.getPropertyId())),
				PGDataModel.class);
		BuildingDataModel buildingDataModel = mongoOperation.findOne(
				new Query(Criteria.where("propertyId").is(
						existingPropertyData.getPropertyId())),
				BuildingDataModel.class);

		if (pgDataModel == null && buildingDataModel == null){
			existingPropertyDataret = new ExistingPropertyData(STATUS.Failure,
					"Entry does not exist call add entry API");
		mongoOperation.save(new TestingData(existingPropertyDataret));
		return existingPropertyDataret;
		}
		else {
			if (pgDataModel != null) { // pg already exists

				existingPropertyDataret = new ExistingPropertyData(STATUS.Success, "Existing property list is ", pgDataModel);
			} else {
				existingPropertyDataret = new ExistingPropertyData(STATUS.Success, "Existing property list is ", buildingDataModel);
				
			}
			mongoOperation.save(new TestingData(existingPropertyDataret));
			return existingPropertyDataret;

		}

	}

}
