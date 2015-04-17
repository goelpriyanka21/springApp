package springapp.web;

import helperclasses.PropertyNameTypeisLocked;
import helperclasses.XmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import models.AuthenticationDetails;
import models.BuildingDataModel;
import models.PGDataModel;
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
import forms.AddEntryData;
import forms.ExistingPropertyData;

@Controller
public class AddEntryAPI {

	@RequestMapping(value = "/addentrydata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ExistingPropertyData addEntry(
			@RequestBody AddEntryData addEntryData) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		// AuthenticationDetails Validators
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(
						addEntryData.getUsername())),
				AuthenticationDetails.class);

		if (authenticationDetails == null)
			return new ExistingPropertyData("Failure",
					"Username does not exist");

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(addEntryData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				addEntryData.getToken()))
			return new ExistingPropertyData("Failure",
					"Token authentication failed");

//		if (addEntryData.getPropertyId() == null) {

			// send list of data on the basis of user's current location and all
			// pg's & Building info lying in area or subarea of his location
			// mongoOperation.find(new
			// Query(Criteria.where("pgdata.$selectedlocation").withinCenter(circle)),
			// PGDataModel.class);
			List<PropertyNameTypeisLocked> listofproperties = new ArrayList<>();

			
//			PGDataModel pgDataModel = mongoOperation.findOne(new Query(Criteria
//					.where("pgdata.pgName").is("Rahat PG")),
//					PGDataModel.class);
			
			Query query = new Query();
			query.addCriteria(Criteria.where("pgdata.selectedlocation.longi")
					.gt(addEntryData.getGpslocation().getLongi() - 2)
					.lt(addEntryData.getGpslocation().getLongi() + 2));
			query.addCriteria(Criteria.where("pgdata.selectedlocation.lat")
					.gt(addEntryData.getGpslocation().getLat() - 2)
					.lt(addEntryData.getGpslocation().getLat() + 2));
//			query.addCriteria(Criteria.where("pgdata.pgName").regex(addEntryData.getPropertyNameinitials()));
			List<PGDataModel> pgDataModelList = mongoOperation.find(query,
					PGDataModel.class);
			for (PGDataModel pgDataModel : pgDataModelList) {
				PropertyNameTypeisLocked pntp1 = new PropertyNameTypeisLocked(
						pgDataModel.getPgdata().getPgName(), "PG",
						pgDataModel.getPropertyId(), pgDataModel.getIsLocked());
				listofproperties.add(pntp1);
			}

			query = new Query();
			query.addCriteria(Criteria
					.where("buildingData.selectedlocation.longi")
					.gt(addEntryData.getGpslocation().getLongi() - 2)
					.lt(addEntryData.getGpslocation().getLongi() + 2));
			query.addCriteria(Criteria
					.where("buildingData.selectedlocation.lat")
					.gt(addEntryData.getGpslocation().getLat() - 2)
					.lt(addEntryData.getGpslocation().getLat() + 2));
//			query.addCriteria(Criteria.where("buildingData.societyname").regex(addEntryData.getPropertyNameinitials()));
			List<BuildingDataModel> buildingDataModellist = mongoOperation
					.find(query, BuildingDataModel.class);
			for (BuildingDataModel pgDataModel : buildingDataModellist) {
				PropertyNameTypeisLocked pntp1 = new PropertyNameTypeisLocked(
						pgDataModel.getBuildingData().getSocietyname(),
						"Building", pgDataModel.getPropertyId(),
						pgDataModel.getIsLocked());
				listofproperties.add(pntp1);
			}
			return new ExistingPropertyData("Success", "Existing property list is ", listofproperties);
//		}

//		else {
//			PGDataModel pgDataModel = mongoOperation.findOne(new Query(Criteria
//					.where("propertyId").is(addEntryData.getPropertyId())),
//					PGDataModel.class);
//			BuildingDataModel buildingDataModel = mongoOperation.findOne(
//					new Query(Criteria.where("propertyId").is(
//							addEntryData.getPropertyId())),
//					BuildingDataModel.class);
//
//			if (pgDataModel == null && buildingDataModel == null)
//				return new ExistingPropertyData("Entry does not exist: call add entry API",
//						addEntryData.getPropertyId());
//			else {
//				if (pgDataModel != null) { // pg already exists
//					if (pgDataModel.getIsLocked())
//						return new ExistingPropertyData(addEntryData.getPropertyId()+
//								"PG Entry already exists and is locked: U can only add PG tenant Details for this propertyID: Please call corresponding API",
//								addEntryData.getPropertyId());
//					else
//						return new ExistingPropertyData(addEntryData.getPropertyId()+
//								"PG Entry already exists and is unlocked: Please call API for updating PG Details or adding tenant details for this propertyID",
//								 addEntryData.getPropertyId());
//				} else {
//					if (buildingDataModel.getIsLocked())
//						return new ExistingPropertyData(
//								"Building Entry already exists and is locked U can only add Flat Details for this propertyID: Please call corresponding API",
//								addEntryData.getPropertyId());
//					else
//						return new ExistingPropertyData(
//								"Building Entry already exists and is unlocked: Please call API for updating Building Details or adding flat details for this propertyID",
//								addEntryData.getPropertyId());
//				}
//			}
//
//		}

	}

}
