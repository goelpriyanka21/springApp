package springapp.web;

import models.AuthenticationDetails;
import models.UserNameToken;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import forms.User;

@Controller
public class PopulateCollections {

	@RequestMapping(value = "/populatecollections", method = RequestMethod.POST)
	public @ResponseBody String populatecollections() throws Exception {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		mongoOperation.dropCollection("authenticationDetails");
		mongoOperation.dropCollection("usernametoken");
		mongoOperation.dropCollection("buildingdata");
		mongoOperation.dropCollection("flatdata");
		mongoOperation.dropCollection("pgdata");
		mongoOperation.dropCollection("tenantdata");

		// authenticationDetails
		mongoOperation.save(new AuthenticationDetails("User1", "user1password",
				"user1deviceId"));
		mongoOperation.save(new AuthenticationDetails("User2", "user2password",
				"user2deviceId"));
		mongoOperation.save(new AuthenticationDetails("User3", "user3password",
				"user3deviceId"));
		// usernametoken
		mongoOperation.save(new UserNameToken("User1", "user1token"));
		mongoOperation.save(new UserNameToken("User2", "user2token"));
		mongoOperation.save(new UserNameToken("User3", "user3token"));

		return ("populate collections worked: all collections populated");

	}

}
