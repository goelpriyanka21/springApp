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
import validators.BuildingAndFlatDataValidator;
import validators.TokenValidator;

@Controller
public class AddNewBuildingAndFlatDataAPI {

	@RequestMapping(value = "/addnewbuildingandflatdata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewBuildingAndFlatData(
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

		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION
		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION GENERATE

				// if tenant data!null; save tenant data
				// if pg data ! null; if unique propertyId is not existing in db; fine; save pg
				// data 
				// if unique propertyId is existing; if is locked is false ; update pg data
				// if is locked is true; status: entry already exist; u can add only
				// tenant data; pg entry already exist & is locked

				if (buildingAndFlatData.getFlatData() != null)
					mongoOperation.save(new FlatDataModel(buildingAndFlatData
							.getPropertyId(), buildingAndFlatData.getFlatData()));
				
				if (buildingAndFlatData.getBuildingData() != null) { // has some building data
					Query query= new Query();
					query.addCriteria(Criteria
							.where("propertyId").is(buildingAndFlatData.getPropertyId()));
					BuildingDataModel buildingDataModel = mongoOperation.findOne(query,
							BuildingDataModel.class);
					if (buildingDataModel == null) // unique propertyId is not existing in db
						mongoOperation.save(new BuildingDataModel(buildingAndFlatData
								.getPropertyId(), buildingAndFlatData.getBuildingData()));
					else
					{
						if(buildingDataModel.getIsLocked()== true){
							return new PostForm("Building Entry already exist and is locked", "  u can add only tenant data");
						}
						else // is locked is false; u can update pg data
						{
							mongoOperation.remove(query, BuildingDataModel.class);
							mongoOperation.save(new BuildingDataModel(buildingAndFlatData
									.getPropertyId(), buildingAndFlatData.getBuildingData()));
							return new PostForm("Success", "Data successfully updated on server");
						}
					}
				}
				return new PostForm("Success", "Data successfully stored on server");
//		mongoOperation.save(new BuildingDataModel(buildingAndFlatData
//				.getPropertyId(), buildingAndFlatData.getBuildingData()));
//		mongoOperation.save(new FlatDataModel(buildingAndFlatData
//				.getPropertyId(), buildingAndFlatData.getFlatData()));
//		return new PostForm("Success", "Data successfully stored on server");
	}

}
