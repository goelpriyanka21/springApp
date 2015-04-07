package springapp.web;



import helperclasses.PropertyNameTypeisLocked;

import java.util.ArrayList;
import java.util.List;

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

import forms.AddEntryData;
import forms.ExistingPropertyData;
import validators.TokenValidator;

@Controller
public class AddEntryAPI {

	@RequestMapping(value = "/addentrydata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ExistingPropertyData addEntry(
			@RequestBody AddEntryData addEntryData) throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		if (addEntryData.getPropertyId() == null) {

			// AuthenticationDetails Validators
			AuthenticationDetails authenticationDetails = mongoOperation
					.findOne(
							new Query(Criteria.where("username").is(
									addEntryData.getUsername())),
							AuthenticationDetails.class);

			if (authenticationDetails == null)
				return new ExistingPropertyData("Failure", "Username does not exist");

			// TOKEN AUTHENTICATION FAILURE:
			UserNameToken usernametoken = mongoOperation.findOne(new Query(
					Criteria.where("username").is(addEntryData.getUsername())),
					UserNameToken.class);

			if (!TokenValidator.validate(usernametoken.gettoken(),
					addEntryData.getToken()))
				return new ExistingPropertyData("Failure", "Token authentication failed");
			
			// send list of data on the basis of user's current location and all pg's & Building info lying in area or subarea of his location
//					mongoOperation.find(new Query(Criteria.where("pgdata.$selectedlocation").withinCenter(circle)), PGDataModel.class);
			Query query= new Query();
			query.addCriteria(Criteria.where("pgdata.selectedlocation.longi").is(47.608942));
			PGDataModel pgDataModel= mongoOperation.findOne(query, PGDataModel.class);
			List<PropertyNameTypeisLocked> listofproperties= new ArrayList<>();
			PropertyNameTypeisLocked pntp1= new PropertyNameTypeisLocked(pgDataModel.getPgdata().getPgName(), "PG", pgDataModel.getPropertyId(), pgDataModel.getIsLocked());
			listofproperties.add(pntp1);
			return new ExistingPropertyData(listofproperties);
		}

		else {
			PGDataModel pgDataModel = mongoOperation.findOne(new Query(Criteria
					.where("propertyId").is(addEntryData.getPropertyId())),
					PGDataModel.class);
			BuildingDataModel buildingDataModel = mongoOperation.findOne(
					new Query(Criteria.where("propertyId").is(
							addEntryData.getPropertyId())),
					BuildingDataModel.class);
			
			if (pgDataModel == null && buildingDataModel == null)
				return new ExistingPropertyData("Entry does not exist",
						"call add entry API");
			else {
				if (pgDataModel != null) {  // pg already exists
					if(pgDataModel.getIsLocked())
					return new ExistingPropertyData("PG Entry already exists and is locked", "U can only add PG tenant Details for this propertyID: Please call corresponding API");
					else return new ExistingPropertyData("PG Entry already exists and is unlocked", "Please call API for updating PG Details or adding tenant details for this propertyID");
				} else {
					if(buildingDataModel.getIsLocked())
						return new ExistingPropertyData("Building Entry already exists and is locked", "U can only add Flat Details for this propertyID: Please call corresponding API");
						else return new ExistingPropertyData("Building Entry already exists and is unlocked", "Please call API for updating Building Details or adding flat details for this propertyID");
				}
			}

		}
		
	}

}
