package springapp.web;

import helperclasses.ErrorFieldAndMessage;
import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;

import java.util.Date;
import java.util.List;

import models.AuthenticationDetails;
import models.BuildingDataModel;
import models.FlatDataModel;
import models.TestingData;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.BuildingAndFlatDataValidator;
import validators.TokenValidator;
import forms.BuildingAndFlatData;
import forms.PostForm;

@Controller
public class AddNewBuildingAndFlatDataAPI {

	@RequestMapping(value = "/addnewbuildingandflatdata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewBuildingAndFlatData(
			@RequestBody BuildingAndFlatData buildingAndFlatData)
			throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		// to log test data input
		mongoOperation.save(new TestingData(buildingAndFlatData));

		PostForm postform;
		if (buildingAndFlatData.getUsername() == null) {
			postform = new PostForm(STATUS.Failure, "username can't be left blank");
			mongoOperation.save(new TestingData(postform));
			return postform;
		}
		
		if (buildingAndFlatData.getToken() == null){
			postform = new PostForm(STATUS.Failure,
					" token can't be left blank");
			mongoOperation.save(new TestingData(postform));
			return postform;
			}

		// AuthenticationDetails Validator
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(
						buildingAndFlatData.getUsername())),
				AuthenticationDetails.class);

		if (authenticationDetails == null){
			postform = new PostForm(STATUS.Failure, "username does not exist");
			mongoOperation.save(new TestingData(postform));
			return postform;
			}

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(buildingAndFlatData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				buildingAndFlatData.getToken())){
			postform =  new PostForm(STATUS.Failure, "Token authentication failed");
		mongoOperation.save(new TestingData(postform));
		return postform;
		}

		// session expired please login again; will code later

		List<ErrorFieldAndMessage> errorfieldandstringlist = BuildingAndFlatDataValidator
				.validate(buildingAndFlatData);

		if (errorfieldandstringlist.size() != 0){
			postform =  new PostForm(STATUS.Failure, "Data validation failed",
					errorfieldandstringlist);
			mongoOperation.save(new TestingData(postform));
			return postform;
			}

		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION
		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION GENERATE

		// if tenant data!null; save tenant data if not existing; update if
		// already existing
		// if pg data ! null; if unique propertyId is not existing in db; fine;
		// save pg
		// data
		// if unique propertyId is existing; if is locked is false ; update pg
		// data
		// if is locked is true; status: entry already exist; u can add only
		// tenant data; pg entry already exist & is locked

		if (buildingAndFlatData.getFlatData() != null)
			// save if non existing
			mongoOperation.save(new FlatDataModel(buildingAndFlatData
					.getPropertyId(), buildingAndFlatData.getFlatData()));
		// update if existing

		if (buildingAndFlatData.getBuildingData() != null) { // has some
																// building data
			Query query = new Query();
			query.addCriteria(Criteria.where("propertyId").is(
					buildingAndFlatData.getPropertyId()));
			BuildingDataModel buildingDataModel = mongoOperation.findOne(query,
					BuildingDataModel.class);
			if (buildingDataModel == null) // unique propertyId is not existing
											// in db
				mongoOperation.save(new BuildingDataModel(buildingAndFlatData
						.getPropertyId(),
						buildingAndFlatData.getBuildingData(),
						buildingAndFlatData.getUsername()));
			else {
				if (buildingDataModel.getIsLocked() == true) {
					postform= new PostForm(
							STATUS.Success,
							" Building Entry already exist and is locked u can add only tenant data");
					mongoOperation.save(new TestingData(postform));
					return postform;
				} else // is locked is false; u can update pg data
				{
					// String createdBy_username=
					// buildingDataModel.getCreatedBy_username();
					// Date createdDate= buildingDataModel.getCreatedDate();
					// mongoOperation.remove(query, BuildingDataModel.class);
					// mongoOperation.save(new
					// BuildingDataModel(buildingAndFlatData
					// .getPropertyId(), buildingAndFlatData.getBuildingData(),
					// createdBy_username, createdDate,
					// buildingAndFlatData.getUsername()));
					Update update = new Update();
					update.set("modifiedBy_username",
							buildingAndFlatData.getUsername());
					update.set("modifiedDate", new Date());
					update.set("buildingData",
							buildingAndFlatData.getBuildingData());
					mongoOperation.updateFirst(query, update,
							BuildingDataModel.class);
					postform=  new PostForm(STATUS.Success,
							"Data successfully updated on server");
					mongoOperation.save(new TestingData(postform));
					return postform;
				}
			}
		}
		postform= new PostForm(STATUS.Success, "Data successfully stored on server");
		mongoOperation.save(new TestingData(postform));
		return postform;
		// mongoOperation.save(new BuildingDataModel(buildingAndFlatData
		// .getPropertyId(), buildingAndFlatData.getBuildingData()));
		// mongoOperation.save(new FlatDataModel(buildingAndFlatData
		// .getPropertyId(), buildingAndFlatData.getFlatData()));
		// return new PostForm("Success", "Data successfully stored on server");
	}

}
