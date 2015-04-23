package springapp.web;

import helperclasses.AddNewPGAndTenantDataAPIMsgs;
import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;

import java.util.Date;
import java.util.List;

import models.AuthenticationDetails;
import models.PGDataModel;
import models.TenantDataModel;
import models.TestingData;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import validators.TokenValidator;
import forms.PGAndTenantData;
import forms.PostForm;
import forms.TenantData;

@Controller
public class AddNewPGAndTenantDataAPI {

	@RequestMapping(value = "/addnewpgandtenantdata", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody PostForm addNewPGandTenantData(
			@RequestBody PGAndTenantData pgAndTenantData) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		mongoOperation.save(new TestingData(pgAndTenantData));

		PostForm postform;
		// AuthenticationDetails Validators

		if (pgAndTenantData.getUsername() == null) {
			postform = new PostForm(STATUS.Failure,
					AddNewPGAndTenantDataAPIMsgs.BLANK_USER);
			mongoOperation.save(new TestingData(postform));
			return postform;
		}

		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(
						pgAndTenantData.getUsername())),
				AuthenticationDetails.class);

		if (authenticationDetails == null) {
			postform = new PostForm(STATUS.Failure,
					AddNewPGAndTenantDataAPIMsgs.USER_NOT_EXIST);
			mongoOperation.save(new TestingData(postform));
			return postform;
		}

		// TOKEN AUTHENTICATION FAILURE:
		if (pgAndTenantData.getToken() == null) {
			postform = new PostForm(STATUS.Failure,
					AddNewPGAndTenantDataAPIMsgs.BLANK_TOKEN);
			mongoOperation.save(new TestingData(postform));
			return postform;
		}

		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(pgAndTenantData.getUsername())),
				UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(),
				pgAndTenantData.getToken())) {
			postform = new PostForm(STATUS.Failure,
					AddNewPGAndTenantDataAPIMsgs.TOKEN_AUTHENTICATION_FAILED);
			mongoOperation.save(new TestingData(postform));
			return postform;
		}

		// session expired please login again; will code later

		// DATA VALIDATION FAILURE:
		List<JsonObject> errors = pgAndTenantData.validate();

		if (errors != null) {
			postform = new PostForm(STATUS.Failure,
					AddNewPGAndTenantDataAPIMsgs.DATA_VALIDATION_FAILED, errors);
			mongoOperation.save(new TestingData(postform));
			return postform;
		}

		// TOKEN SUCCESSFUL VALIDATION; DATA SUCCESSFUL VALIDATION GENERATE

		// if tenant data!null; save tenant data
		// if pg data ! null; if unique propertyId is not existing in db; fine;
		// save pg
		// data
		// if unique propertyId is existing; if is locked is false ; update pg
		// data
		// if is locked is true; status: entry already exist; u can add only
		// tenant data; pg entry already exist & is locked
		Query query = new Query();
		query.addCriteria(Criteria.where("propertyId").is(
				pgAndTenantData.getPropertyId()));

		if (pgAndTenantData.getPgtenantlist() != null) {
			TenantDataModel tenantDataModel = mongoOperation.findOne(query,
					TenantDataModel.class);
			if (tenantDataModel == null) { // unique propertyId is not existing
											// in db
				mongoOperation.save(new TenantDataModel(pgAndTenantData
						.getpropertyId(), pgAndTenantData.getPgtenantlist()));
			} else { // append if existing
				List<TenantData> pgtenantlist = tenantDataModel
						.getPgtenantlist();
				pgtenantlist.addAll(pgAndTenantData.getPgtenantlist());
				Update update = new Update();
				update.set("pgtenantlist", pgtenantlist);
				mongoOperation
						.updateFirst(query, update, TenantDataModel.class);

			}
		}

		if (pgAndTenantData.getPgdata() != null) { // has some pg data

			PGDataModel pgDataModel = mongoOperation.findOne(query,
					PGDataModel.class);
			if (pgDataModel == null) // unique propertyId is not existing in db
			{
				mongoOperation.save(new PGDataModel(pgAndTenantData
						.getpropertyId(), pgAndTenantData.getPgdata(),
						pgAndTenantData.getUsername()));
			} else {
				if (pgDataModel.getIsLocked() == true) {
					postform = new PostForm(STATUS.Failure,
							AddNewPGAndTenantDataAPIMsgs.PG_ALREADY_EXIST);
					mongoOperation.save(new TestingData(postform));
					return postform;
				} else // is locked is false; u can update pg data
				{

					Update update = new Update();
					update.set("modifiedBy_username",
							pgAndTenantData.getUsername());
					update.set("modifiedDate", new Date());
					update.set("pgdata", pgAndTenantData.getPgdata());
					mongoOperation
							.updateFirst(query, update, PGDataModel.class);
					postform = new PostForm(
							STATUS.Success,
							AddNewPGAndTenantDataAPIMsgs.DATA_SUCCESSFULLY_UPDATED);
					mongoOperation.save(new TestingData(postform));
					return postform;
				}
			}
		}
		postform = new PostForm(STATUS.Success,
				AddNewPGAndTenantDataAPIMsgs.DATA_SUCCESSFULLY_STORED);
		mongoOperation.save(new TestingData(postform));
		return postform;
	}
}
