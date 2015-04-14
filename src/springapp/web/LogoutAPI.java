package springapp.web;

import helperclasses.XmlApplicationContext;
import models.AuthenticationDetails;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.AuthenticationDetailsValidator;
import forms.LogoutData;
import forms.PostForm;

@Controller
public class LogoutAPI {

	@RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewPGandTenantData(
			@RequestBody LogoutData logoutData) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		// AuthenticationDetails Validator: AUTHENTICATION DETAILS FAILURE:
		AuthenticationDetails authenticationDetails = mongoOperation
				.findOne(
						new Query(Criteria.where("username").is(
								logoutData.getUsername())),
						AuthenticationDetails.class);

		if (authenticationDetails == null)
			return new PostForm("Failure", "Username does not exist");

		if (!AuthenticationDetailsValidator.validatedeviceId(
				authenticationDetails.getDeviceId(), logoutData.getDeviceId()))
			return new PostForm("Failure", "Unauthorized Device Logout");

		return new PostForm("Success", "User successfully logged out");
	}
}
