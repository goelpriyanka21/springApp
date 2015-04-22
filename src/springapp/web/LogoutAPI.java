package springapp.web;

import helperclasses.LogoutAPIMsgs;
import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;
import models.AuthenticationDetails;
import models.TestingData;

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

		mongoOperation.save(new TestingData(logoutData));

		// AuthenticationDetails Validator: AUTHENTICATION DETAILS FAILURE:
		AuthenticationDetails authenticationDetails = mongoOperation
				.findOne(
						new Query(Criteria.where("username").is(
								logoutData.getUsername())),
						AuthenticationDetails.class);

		PostForm postform;
		if (authenticationDetails == null) {
			postform = new PostForm(STATUS.Failure, LogoutAPIMsgs.USER_NOT_EXIST);
			mongoOperation.save(new TestingData(postform));
			return postform;

		}

		 if (!AuthenticationDetailsValidator.validatedeviceId(
				authenticationDetails.getDeviceId(), logoutData.getDeviceId())) {
			postform = new PostForm(STATUS.Failure, LogoutAPIMsgs.UNAUTHORIZED_DEVICE);
			mongoOperation.save(new TestingData(postform));
			return postform;

		}

		else {
			postform = new PostForm(STATUS.Success, LogoutAPIMsgs.LOGGED_OUT_SUCCESSFULLY);
			mongoOperation.save(new TestingData(postform));
			return postform;
		}

	}
}


