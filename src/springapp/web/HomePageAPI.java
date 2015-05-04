package springapp.web;

import helperclasses.HomePageAPIMsgs;
import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;
//import models.AttendenceModel;
import models.AuthenticationDetails;
import models.BuildingDataModel;
import models.PGDataModel;
import models.TestingData;
import models.UserNameToken;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validators.TokenValidator;
import forms.HomePageData;

@Controller
public class HomePageAPI {
	public static final Integer TARGET_FOR_EVERY_FOS_FOR_EVERY_MONTH = 300;

	@RequestMapping(value = "/homepage", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody HomePageData showHomePage(
			@RequestBody HomePageData homePageData) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		mongoOperation.save(new TestingData(homePageData));

		// AuthenticationDetails Validator
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(
						homePageData.getUsername())),
				AuthenticationDetails.class);

		HomePageData postForm;
		if (authenticationDetails == null) {
			postForm = new HomePageData(STATUS.Failure,
					HomePageAPIMsgs.USER_NOT_EXIST);
			mongoOperation.save(new TestingData(postForm));
			return postForm;

		}

		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(homePageData.getUsername())),
				UserNameToken.class);

		if (usernametoken == null) {
			postForm = new HomePageData(STATUS.Failure,
					HomePageAPIMsgs.USER_NOT_LOGGED_IN);
			mongoOperation.save(new TestingData(postForm));
			return postForm;
		}

		if (!TokenValidator.validate(usernametoken.gettoken(),
				homePageData.getToken())) {
			postForm = new HomePageData(STATUS.Failure,
					HomePageAPIMsgs.TOKEN_AUTHENTICATION_FAILED);
			mongoOperation.save(new TestingData(postForm));
			return postForm;

		}

		// get the midnight of the start of the day and start of the
		// month
		DateTime now = DateTime.now();
		LocalDate today = now.toLocalDate();
		DateTime startm = now.withDayOfMonth(1).toLocalDate()
				.toDateTimeAtStartOfDay();
		DateTime endm = startm.plusMonths(1);
		LocalDate tomorrow = today.plusDays(1);

		DateTime startOfToday = today.toDateTimeAtStartOfDay(now.getZone());
		DateTime startOfTomorrow = tomorrow.toDateTimeAtStartOfDay(now
				.getZone());
		final Query todayq = new Query(Criteria
				.where("createdDate")
				.gte(startOfToday.toDate())
				.andOperator(
						Criteria.where("createdDate").lt(
								startOfTomorrow.toDate()))
				.and("createdBy_username").is(homePageData.getUsername()));
		int todaysCount = (int) mongoOperation.count(todayq, PGDataModel.class);
		todaysCount += (int) mongoOperation.count(todayq,
				BuildingDataModel.class);

		final Query monthq = new Query(Criteria.where("createdDate")
				.gte(startm.toDate())
				.andOperator(Criteria.where("createdDate").lt(endm.toDate()))
				.and("createdBy_username").is(homePageData.getUsername()));
		int monthsCount = (int) mongoOperation.count(monthq, PGDataModel.class);
		monthsCount += (int) mongoOperation.count(monthq,
				BuildingDataModel.class);
		postForm = new HomePageData(
				STATUS.Success,
				HomePageAPIMsgs.HOMEPAGE_DATA,
				todaysCount,
				monthsCount,
				TARGET_FOR_EVERY_FOS_FOR_EVERY_MONTH,
				(double) (monthsCount / TARGET_FOR_EVERY_FOS_FOR_EVERY_MONTH) * 100);

		mongoOperation.save(new TestingData(postForm));
		return postForm;

	}
}
