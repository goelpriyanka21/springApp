package springapp.web;

import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;
import models.AppointmentDataModel;
import models.AuthenticationDetails;
import models.TestingData;
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

		mongoOperation.save(new TestingData(
				new AppointmentData(username, token)));

		// AuthenticationDetails Validator
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(username)),
				AuthenticationDetails.class);

		AppointmentAPIPost appointmentAPIPost;
		if (authenticationDetails == null) {
			appointmentAPIPost = new AppointmentAPIPost(STATUS.Failure,
					AppointmentListAPIMsgs.USER_NOT_EXIST);
			mongoOperation.save(new TestingData(appointmentAPIPost));
			return appointmentAPIPost;
		}

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(username)), UserNameToken.class);
		
		if (usernametoken == null) {
			appointmentAPIPost=new AppointmentAPIPost(STATUS.Failure, AppointmentListAPIMsgs.USER_NOT_LOGGED_IN);
			mongoOperation.save(new TestingData(appointmentAPIPost));
			return appointmentAPIPost;
			}

		if (!TokenValidator.validate(usernametoken.gettoken(), token)) {
			appointmentAPIPost = new AppointmentAPIPost(STATUS.Failure,
					AppointmentListAPIMsgs.TOKEN_AUTHENTICATION_FAILED);
			mongoOperation.save(new TestingData(appointmentAPIPost));
			return appointmentAPIPost;
		}

		// show list of appointments
		AppointmentDataModel appointmentDataModel = mongoOperation.findOne(
				new Query(Criteria.where("username").is(username)),
				AppointmentDataModel.class);

		if (appointmentDataModel == null) {
			appointmentAPIPost = new AppointmentAPIPost(STATUS.Success,
					AppointmentListAPIMsgs.NO_APPOINTMENT_FOR_YOU);
			mongoOperation.save(new TestingData(appointmentAPIPost));
			return appointmentAPIPost;
		}

		appointmentAPIPost = new AppointmentAPIPost(STATUS.Success,
				AppointmentListAPIMsgs.APPOINTMENT_LIST_SORTED_TIME,
				appointmentDataModel.getSortedOrderList());
		mongoOperation.save(new TestingData(appointmentAPIPost));
		return appointmentAPIPost;
	}

}

class AppointmentData {
	String username;
	String token;

	public AppointmentData(String username, String token) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.token = token;
	}
}

class AppointmentListAPIMsgs {
	public static final String USER_NOT_EXIST = "Username does not exist";
	public static final String TOKEN_AUTHENTICATION_FAILED = "Token authentication failed";
	public static final String NO_APPOINTMENT_FOR_YOU = "There is/was no appointment for you";
	public static final String APPOINTMENT_LIST_SORTED_TIME = "Your appointment list (sorted acc to start time) is";
	public static final String USER_NOT_LOGGED_IN = "user is not logged in";
}
