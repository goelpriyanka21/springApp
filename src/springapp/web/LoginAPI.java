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
import forms.LoginData;
import forms.PostForm;
import validators.AuthenticationDetailsValidator;
import validators.BuildingAndFlatDataValidator;
import validators.TokenValidator;

@Controller
public class LoginAPI {

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewPGandTenantData(
			@RequestBody LoginData loginData) throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

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
