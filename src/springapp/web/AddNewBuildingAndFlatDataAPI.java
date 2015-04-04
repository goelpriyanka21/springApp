package springapp.web;

import helperclasses.ErrorFieldAndMessage;

import java.util.List;

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

import validators.BuildingAndFlatDataValidator;

@Controller
public class AddNewBuildingAndFlatDataAPI {

	@RequestMapping(value = "/addnewbuildingandflatdata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody BuildingAndFlatData addNewPGandTenantData(
			@RequestBody BuildingAndFlatData buildingAndFlatData)
			throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		// check in token db extract token for this username nd match with
		// received token

		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(buildingAndFlatData.getUsername())),
				UserNameToken.class);

		if (usernametoken == null)
			return new BuildingAndFlatData("Failure", "Username does not exist");

		String token = usernametoken.gettoken();

		// TOKEN AUTHENTICATION FAILURE:
		if (!token.equals(buildingAndFlatData.getToken()))
			return new BuildingAndFlatData("Failure",
					"Token authentication failed");

		// session expired please login again; will code later

		List<ErrorFieldAndMessage> errorfieldandstringlist = BuildingAndFlatDataValidator
				.validate(buildingAndFlatData);

		if (errorfieldandstringlist.size() != 0)
			return new BuildingAndFlatData("Failure", "Data validation failed",
					errorfieldandstringlist);

		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION GENERATE
		// UNIQUE ID AND SAVE DATA
		mongoOperation.save(new BuildingDataModel(buildingAndFlatData
				.getPropertyId(), buildingAndFlatData.getBuildingData()));
		mongoOperation.save(new FlatDataModel(buildingAndFlatData
				.getPropertyId(), buildingAndFlatData.getFlatData()));
		return new BuildingAndFlatData("Success",
				"Data successfully stored on server");
	}

}
