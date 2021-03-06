package springapp.web;

import helperclasses.UnlockPropertyData;
import helperclasses.XmlApplicationContext;
import models.BuildingDataModel;
import models.PGDataModel;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UnlockEntries {

	@RequestMapping(value = "/unlockentries", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String unlockentries(@RequestBody UnlockPropertyData propertyTypeAndIdToBeUnlocked) throws Exception {
		
		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();
		
		if(propertyTypeAndIdToBeUnlocked.getPropertyType().equals("PG")){
		mongoOperation.updateFirst(
				new Query(Criteria.where("propertyId").is(
						propertyTypeAndIdToBeUnlocked.getPropertyId())), new Update().set("isLocked", false), 
						PGDataModel.class);
		

		}
		else if(propertyTypeAndIdToBeUnlocked.getPropertyType().equals("Building"))
			mongoOperation.updateFirst(
					new Query(Criteria.where("propertyId").is(
							propertyTypeAndIdToBeUnlocked.getPropertyId())), new Update().set("isLocked", false), 
							BuildingDataModel.class);
		

		return ("Unlocked successfully");

	}

}
