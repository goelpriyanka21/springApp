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
		if (authenticationDetails == null) {
			existingPropertyDataret = new ExistingPropertyData(STATUS.Failure,
					ExistingPropertyAPIMsgs.USER_NOT_EXIST);
			mongoOperation.save(new TestingData(existingPropertyDataret));
			return existingPropertyDataret;
		}

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(existingPropertyData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				existingPropertyData.getToken())) {
			existingPropertyDataret = new ExistingPropertyData(STATUS.Failure,
					ExistingPropertyAPIMsgs.TOKEN_AUTHENTICATION_FAILED);
			mongoOperation.save(new TestingData(existingPropertyDataret));
			return existingPropertyDataret;
		}

		if (existingPropertyData.getPropertyId() == null) {
			existingPropertyDataret = new ExistingPropertyData(STATUS.Failure,
					ExistingPropertyAPIMsgs.NO_PROPERTY_ID_PROVIDED);
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

		if (pgDataModel == null && buildingDataModel == null) {
			existingPropertyDataret = new ExistingPropertyData(STATUS.Failure,
					ExistingPropertyAPIMsgs.ENTRY_DOES_NOT_EXIST);
			mongoOperation.save(new TestingData(existingPropertyDataret));
			return existingPropertyDataret;
		} else {
			if (pgDataModel != null) { // pg already exists

				existingPropertyDataret = new ExistingPropertyData(
						STATUS.Success, ExistingPropertyAPIMsgs.EXISTING_PROPERTY_LIST,
						pgDataModel.getPgdata());
			} else {
				existingPropertyDataret = new ExistingPropertyData(
						STATUS.Success, ExistingPropertyAPIMsgs.EXISTING_PROPERTY_LIST,
						buildingDataModel.getBuildingData());

			}
			mongoOperation.save(new TestingData(existingPropertyDataret));
			return existingPropertyDataret;

		}

	}

}

class ExistingPropertyAPIMsgs {
	public static final String USER_NOT_EXIST = "Username does not exist";
	public static final String TOKEN_AUTHENTICATION_FAILED = "Token authentication failed";
	public static final String NO_PROPERTY_ID_PROVIDED = " propertyId cannot be left blank ";
	public static final String ENTRY_DOES_NOT_EXIST = "Entry does not exist call add entry API";
	public static final String EXISTING_PROPERTY_LIST = "Existing property list is ";
}
