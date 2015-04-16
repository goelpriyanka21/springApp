package springapp.web;

import helperclasses.XmlApplicationContext;
import models.AppointmentDataModel;
import models.AuthenticationDetails;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.TokenValidator;
import forms.AppointmentAPIPost;

@Controller
public class AppointmentListAPI {

	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	public @ResponseBody AppointmentAPIPost showAppointments(
			@RequestHeader String username, @RequestHeader String token)
			throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		// AuthenticationDetails Validator
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(username)),
				AuthenticationDetails.class);

		if (authenticationDetails == null)
			return new AppointmentAPIPost("Failure", "Username does not exist");

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(username)), UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(), token))
			return new AppointmentAPIPost("Failure",
					"Token authentication failed");

		// show list of appointments
		AppointmentDataModel appointmentDataModel = mongoOperation.findOne(
				new Query(Criteria.where("username").is(username)),
				AppointmentDataModel.class);

		if (appointmentDataModel == null)
			return new AppointmentAPIPost("Success",
					"No Appointmnets for you: Enjoy");

		return new AppointmentAPIPost("Success",
				"Your appointment list (sorted acc to start time) is",
				appointmentDataModel.getSortedOrderList());
	}

}
