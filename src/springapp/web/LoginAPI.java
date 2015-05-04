package springapp.web;

import helperclasses.LoginAPIMsgs;
import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;

import java.math.BigInteger;
import java.security.SecureRandom;

import models.AuthenticationDetails;
import models.TestingData;
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
	
	private static SecureRandom securerandom = new SecureRandom();

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewPGandTenantData(
			@RequestBody LoginData loginData) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		mongoOperation.save(new TestingData(loginData));

		// AuthenticationDetails Validator: AUTHENTICATION DETAILS FAILURE:
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username")
						.is(loginData.getUsername())),
				AuthenticationDetails.class);

		PostForm postform;
		if (authenticationDetails == null) {
			postform = new PostForm(STATUS.Failure, LoginAPIMsgs.USER_NOT_EXIST);
			mongoOperation.save(new TestingData(postform));
			return postform;

		}

		if (!AuthenticationDetailsValidator.validatepassword(
				authenticationDetails.getPassword(), loginData.getPassword())) {
			postform = new PostForm(STATUS.Failure,
					LoginAPIMsgs.INVALID_USERNAMEPASSWORD);
			mongoOperation.save(new TestingData(postform));
			return postform;

		}

		if (!AuthenticationDetailsValidator.validatedeviceId(
				authenticationDetails.getDeviceId(), loginData.getDeviceId())) {
			postform = new PostForm(STATUS.Failure,
					LoginAPIMsgs.UNAUTHORIZED_DEVICE);
			mongoOperation.save(new TestingData(postform));
			return postform;

		}
		// if already logged in; remove that token
		mongoOperation.remove(new Query(Criteria.where("username")
				.is(loginData.getUsername())),
				UserNameToken.class);
		
		String token = new BigInteger(130,securerandom).toString(32);
		mongoOperation.save(new UserNameToken(loginData.getUsername(), token));

		postform = new PostForm(STATUS.Success,
				LoginAPIMsgs.AUTHENTICATION_SUCCESSFUL, token);

		mongoOperation.save(new TestingData(postform));
		return postform;
	}

}
