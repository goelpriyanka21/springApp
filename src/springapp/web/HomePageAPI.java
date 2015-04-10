package springapp.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//import models.AttendenceModel;
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

import validators.TokenValidator;
import forms.HomePageData;

@Controller
public class HomePageAPI {
	public static final Integer TARGET_FOR_EVERY_FOS_FOR_EVERY_MONTH = 300;

	@RequestMapping(value = "/homepage", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody HomePageData showHomePage(
			@RequestBody HomePageData homePageData) throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		// AuthenticationDetails Validator
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(
						homePageData.getUsername())),
				AuthenticationDetails.class);

		if (authenticationDetails == null)
			return new HomePageData("Failure", "Username does not exist");

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(homePageData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				homePageData.getToken()))
			return new HomePageData("Failure", "Token authentication failed");

		// homepage data
		// AttendenceModel attendenceModel = mongoOperation.findOne(new Query(
		// Criteria.where("username").is(homePageData.getUsername())),
		// AttendenceModel.class);
		Query query = new Query();
		query.addCriteria(Criteria.where("createdBy_username").is(
				homePageData.getUsername()));
		String currentdatetime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				.format(new Date());
		int numoftodayentries = 0;
		int numofcurrentmonthentries = 0;

		// for PG
		List<PGDataModel> pgDataModelList = mongoOperation.find(query,
				PGDataModel.class);
		for (PGDataModel pgDataModel : pgDataModelList) {
			if (currentdatetime.substring(8, 10).equals(
					pgDataModel.getCreatedDate().substring(8, 10)))
				numoftodayentries++;
			if (currentdatetime.substring(5, 7).equals(
					pgDataModel.getCreatedDate().substring(5, 7)))
				numofcurrentmonthentries++;
		}
		// for Building
				List<BuildingDataModel> buildingDataModellist = mongoOperation.find(query,
						BuildingDataModel.class);
				for (BuildingDataModel buildingDataModel : buildingDataModellist) {
					if (currentdatetime.substring(8, 10).equals(
							buildingDataModel.getCreatedDate().substring(8, 10)))
						numoftodayentries++;
					if (currentdatetime.substring(5, 7).equals(
							buildingDataModel.getCreatedDate().substring(5, 7)))
						numofcurrentmonthentries++;
				}

		return new HomePageData(numoftodayentries, numofcurrentmonthentries,
				TARGET_FOR_EVERY_FOS_FOR_EVERY_MONTH,
				(double) numofcurrentmonthentries
						/ TARGET_FOR_EVERY_FOS_FOR_EVERY_MONTH*100);

	}
}
