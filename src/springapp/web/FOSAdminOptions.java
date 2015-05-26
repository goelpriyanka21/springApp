package springapp.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import forms.AppointmentAPIPost;
import forms.AppointmentData;
import helperclasses.Location;
import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;
import models.AdminAuthenticationDetails;
import models.AppointmentDataModel;
import models.AuthenticationDetails;
import models.BuildingDataModel;
import models.PGDataModel;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FOSAdminOptions {

	@RequestMapping(value = "/fosadminlogin", method = RequestMethod.POST)
	public @ResponseBody String fosadminlogin(
			@RequestParam String fosadmin_username,
			@RequestParam String fosadmin_password, HttpServletResponse response)
			throws Exception {
		//
		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		AdminAuthenticationDetails adminAuthenticationDetails = mongoOperation
				.findOne(
						new Query(Criteria.where("fosadmin_username").is(
								fosadmin_username)),
						AdminAuthenticationDetails.class);

		if (adminAuthenticationDetails == null)
			return "Unauthorized login attempt (No such admin)";
		if (!adminAuthenticationDetails.getPassword().equals(fosadmin_password))
			return "Unauthorized login attempt (Invalid credentials)";

		response.sendRedirect("http://localhost:8080/dcapi/pages/fosoptions.jsp");
		return "";

	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public @ResponseBody String adduser(@RequestParam String username,
			@RequestParam String password, @RequestParam String deviceId,
			HttpServletResponse response) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(username)),
				AuthenticationDetails.class);
		//
		if (authenticationDetails != null)
			return "user already registered";

		mongoOperation.save(new AuthenticationDetails(username, password,
				deviceId));
		return "user successfully registered";

	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public @ResponseBody String deleteuser(@RequestParam String username,
			HttpServletResponse response) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		Query query = new Query(Criteria.where("username").is(username));
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				query, AuthenticationDetails.class);
		//
		if (authenticationDetails == null)
			return "There is no such user registered";

		mongoOperation.remove(query, AuthenticationDetails.class);
		return "user successfully deleted";

	}

	@RequestMapping(value = "/addappointment", method = RequestMethod.POST)
	public @ResponseBody AppointmentAPIPost addappointment(
			@RequestParam String username, @RequestParam String propertyId,
			@RequestParam String propertyName,
			@RequestParam String propertyType,
			@RequestParam String addressline1,
			@RequestParam String addressline2,
			@RequestParam String appointmentStDate,
			@RequestParam String appointmentStTime,
			@RequestParam String appointmentEndDate,
			@RequestParam String appointmentEndTime,
			@RequestParam String notes, @RequestParam Double latclicked,
			@RequestParam Double longclicked, HttpServletResponse response)
			throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		Query query = new Query(Criteria.where("username").is(username));
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				query, AuthenticationDetails.class);
		if (authenticationDetails == null)
			return new AppointmentAPIPost(STATUS.Failure,
					AppointmentListAPIMsgs.USER_NOT_EXIST);

		String appointmentId = new String(propertyName + " "
				+ new Timestamp(System.currentTimeMillis()));

		Location location = new Location(longclicked, latclicked);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		AppointmentData appointmentData = new AppointmentData(appointmentId,
				propertyId, propertyName, propertyType, addressline1,
				addressline2, sdf.parse(appointmentStDate + " "
						+ appointmentStTime), sdf.parse(appointmentEndDate
						+ " " + appointmentEndTime), notes, location);
		// AppointmentData appointmentData = new AppointmentData(appointmentId,
		// propertyId, propertyName, propertyType, addressline1,
		// addressline2, sdf.parse("13-03-2015 05:30"),
		// sdf.parse("13-03-2015 05:30"), notes,
		// location);
		AppointmentDataModel appointmentDataModel = mongoOperation.findOne(
				query, AppointmentDataModel.class);
		if (appointmentDataModel == null) { // first appointment for this user
			List<AppointmentData> appointmentList = new ArrayList<>();
			appointmentList.add(appointmentData);
			mongoOperation.save(new AppointmentDataModel(username,
					appointmentList));
		} else { // append if existing
			List<AppointmentData> appointmentList = appointmentDataModel
					.getAppointmentList();
			appointmentList.add(appointmentData);
			Update update = new Update();
			update.set("appointmentList", appointmentList);
			mongoOperation.updateFirst(query, update,
					AppointmentDataModel.class);

		}
		// show list of appointments
		appointmentDataModel = mongoOperation.findOne(query,
				AppointmentDataModel.class);
		AppointmentAPIPost appointmentAPIPost = new AppointmentAPIPost(
				STATUS.Success,
				AppointmentListAPIMsgs.APPOINTMENT_LIST_SORTED_TIME,
				appointmentDataModel.getSortedOrderList());
		return appointmentAPIPost;
	}

	@RequestMapping(value = "/unlockentry", method = RequestMethod.POST)
	public @ResponseBody String unlockentries(@RequestParam String propertyId,
			@RequestParam String propertyType) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		if (propertyType.equals("PG")) {
			mongoOperation.updateFirst(new Query(Criteria.where("propertyId")
					.is(propertyId)), new Update().set("isLocked", false),
					PGDataModel.class);

		} else if (propertyType.equals("Building"))
			mongoOperation.updateFirst(new Query(Criteria.where("propertyId")
					.is(propertyId)), new Update().set("isLocked", false),
					BuildingDataModel.class);

		return ("Unlocked successfully");

	}

}
