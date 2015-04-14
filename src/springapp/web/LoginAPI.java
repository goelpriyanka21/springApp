package springapp.web;

import helperclasses.XmlApplicationContext;
import models.AuthenticationDetails;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.AuthenticationDetailsValidator;
import forms.LoginData;
import forms.PostForm;

@Controller
public class LoginAPI {

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewPGandTenantData(
			@RequestBody LoginData loginData) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		// AuthenticationDetails Validator: AUTHENTICATION DETAILS FAILURE:
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username")
						.is(loginData.getUsername())),
				AuthenticationDetails.class);

		if (authenticationDetails == null)
			return new PostForm("Failure", "Username does not exist");

		if (!AuthenticationDetailsValidator.validatepassword(
				authenticationDetails.getPassword(), loginData.getPassword()))
			return new PostForm("Failure",
					"Username and password doesnot match");

		if (!AuthenticationDetailsValidator.validatedeviceId(
				authenticationDetails.getDeviceId(), loginData.getDeviceId()))
			return new PostForm("Failure", "Unauthorized Device Login");

		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(loginData.getUsername())),
				UserNameToken.class);

		return new PostForm("Success",
				"Authentication successful, Keep the token for this session",
				usernametoken.gettoken());
	}

}
