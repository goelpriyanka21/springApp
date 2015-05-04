package springapp.web;

import helperclasses.AppointmentCheckAPIMsgs;
import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;
import models.AppointmentDataModel;
import models.AuthenticationDetails;
import models.TestingData;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.TokenValidator;
import forms.AppointmentAPIPost;
import forms.AppointmentData;

@Controller
public class AppointmentCheckAPI {

	@RequestMapping(value = "/checkappointment", method = RequestMethod.POST)
	public @ResponseBody AppointmentAPIPost checkAppointment(
			@RequestHeader String username, @RequestHeader String token,
			@RequestParam String appointmentId) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		mongoOperation.save(new TestingData(new AppointmentCheckData(username,
				token, appointmentId)));

		// AuthenticationDetails Validator
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(username)),
				AuthenticationDetails.class);
		AppointmentAPIPost appointmentAPIPost;
		if (authenticationDetails == null) {
			appointmentAPIPost = new AppointmentAPIPost(STATUS.Failure,
					AppointmentCheckAPIMsgs.USER_NOT_EXIST);
			mongoOperation.save(new TestingData(appointmentAPIPost));
			return appointmentAPIPost;
		}

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(username)), UserNameToken.class);
		
		if (usernametoken == null) {
			appointmentAPIPost=new AppointmentAPIPost(STATUS.Failure, AppointmentCheckAPIMsgs.USER_NOT_LOGGED_IN);
			mongoOperation.save(new TestingData(appointmentAPIPost));
			return appointmentAPIPost;
			}

		if (!TokenValidator.validate(usernametoken.gettoken(), token)) {
			appointmentAPIPost = new AppointmentAPIPost(STATUS.Failure,
					AppointmentCheckAPIMsgs.TOKEN_AUTHENTICATION_FAILED);
			mongoOperation.save(new TestingData(appointmentAPIPost));
			return appointmentAPIPost;
		}

		// show list of appointments
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		AppointmentDataModel appointmentDataModel = mongoOperation.findOne(
				query, AppointmentDataModel.class);

		if (appointmentDataModel == null) {
			appointmentAPIPost = new AppointmentAPIPost(STATUS.Failure,
					AppointmentCheckAPIMsgs.NO_APPOINTMENT_FOR_YOU);
			mongoOperation.save(new TestingData(appointmentAPIPost));
			return appointmentAPIPost;
		}

		for (AppointmentData appointmentData : appointmentDataModel
				.getAppointmentList()) {
			if (appointmentData.getAppointmentId().equals(appointmentId)) {
				appointmentDataModel.getAppointmentList().remove(
						appointmentData);
				mongoOperation.updateFirst(query, new Update().set(
						"appointmentList",
						appointmentDataModel.getAppointmentList()),
						AppointmentDataModel.class);
				appointmentAPIPost = new AppointmentAPIPost(STATUS.Success,
						AppointmentCheckAPIMsgs.DATA_SUCCESSFULLY_UPDATED);
				mongoOperation.save(new TestingData(appointmentAPIPost));
				return appointmentAPIPost;
			}
		}

		appointmentAPIPost = new AppointmentAPIPost(STATUS.Failure,
				AppointmentCheckAPIMsgs.NO_SUCH_APPOINTMENT_FOR_YOU);
		mongoOperation.save(new TestingData(appointmentAPIPost));
		return appointmentAPIPost;

	}

}

class AppointmentCheckData {
	String username;
	String token;
	String appointmentId;

	public AppointmentCheckData(String username, String token,
			String appointmentId) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.token = token;
		this.appointmentId = appointmentId;
	}
}


