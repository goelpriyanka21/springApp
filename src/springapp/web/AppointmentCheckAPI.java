package springapp.web;


import helperclasses.XmlApplicationContext;
import models.AppointmentDataModel;
import models.AuthenticationDetails;
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
				@RequestHeader String username, @RequestHeader String token, @RequestParam String appointmentId) throws Exception {
			
			MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

			// AuthenticationDetails Validator
			AuthenticationDetails authenticationDetails = mongoOperation.findOne(new Query(Criteria
					.where("username").is(username)),
					AuthenticationDetails.class);

			if (authenticationDetails == null)
				return new AppointmentAPIPost("Failure", "Username does not exist");

			// TOKEN AUTHENTICATION FAILURE:
			UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
					.where("username").is(username)),
					UserNameToken.class);

			if (!TokenValidator.validate(usernametoken.gettoken(),
					token))
				return new AppointmentAPIPost("Failure", "Token authentication failed");
			
			//show list of appointments
			Query query= new Query();
			query.addCriteria(Criteria
					.where("username").is(username));
			AppointmentDataModel appointmentDataModel = mongoOperation.findOne(query,
					AppointmentDataModel.class);
			
			if(appointmentDataModel==null) return new AppointmentAPIPost("Failure", "There was no appointment for you");
			
			for(AppointmentData appointmentData: appointmentDataModel.getAppointmentList()){
				if(appointmentData.getAppointmentId().equals(appointmentId)){
					appointmentDataModel.getAppointmentList().remove(appointmentData);
					mongoOperation.updateFirst(query, new Update().set("appointmentList", appointmentDataModel.getAppointmentList()), AppointmentDataModel.class);
					return new AppointmentAPIPost("success", "appointment list successfully updated");
				}
			}
			

			return new AppointmentAPIPost("Failure", "There was no such appointment ID for you");
		}


}
