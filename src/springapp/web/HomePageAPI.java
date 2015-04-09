package springapp.web;

import models.AttendenceModel;
import models.AuthenticationDetails;
import models.UserNameToken;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.TokenValidator;
import forms.HomePageData;

public class HomePageAPI {
	@RequestMapping(value = "/homepage", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody HomePageData showHomePage(
			@RequestBody HomePageData homePageData) throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		
		// AuthenticationDetails Validator
				AuthenticationDetails authenticationDetails = mongoOperation.findOne(new Query(Criteria
						.where("username").is(homePageData.getUsername())),
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
				
				//homepage data
				AttendenceModel attendenceModel = mongoOperation.findOne(new Query(Criteria
						.where("username").is(homePageData.getUsername())),
						AttendenceModel.class);
				return new HomePageData(2, 2, 300, 0.6);
				// have to implement its logic 
//				return new HomePageData(attendenceModel.getNumoftodayentries(), attendenceModel.getNumofcurrentmonthentries(), attendenceModel.getTargetforthemonth(), attendenceModel.getTargetachieved());
		
		
	}
}
