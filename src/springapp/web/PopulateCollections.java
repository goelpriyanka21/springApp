package springapp.web;

import forms.AppointmentData;
import helperclasses.Location;
import helperclasses.XmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

import models.AppointmentDataModel;
import models.AuthenticationDetails;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PopulateCollections {

	@RequestMapping(value = "/populatecollections", method = RequestMethod.POST)
	public @ResponseBody String populatecollections() throws Exception {
		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		mongoOperation.dropCollection("authenticationDetails");
		mongoOperation.dropCollection("usernametoken");
		mongoOperation.dropCollection("buildingdata");
		mongoOperation.dropCollection("flatdata");
		mongoOperation.dropCollection("pgdata");
		mongoOperation.dropCollection("tenantdata");
		mongoOperation.dropCollection("photos");
		mongoOperation.dropCollection("attendence");
		mongoOperation.dropCollection("appointmentDetails");
		

		// authenticationDetails
		mongoOperation.save(new AuthenticationDetails("User1", "user1password",
				"user1deviceId"));
		mongoOperation.save(new AuthenticationDetails("User2", "user2password",
				"user2deviceId"));
		mongoOperation.save(new AuthenticationDetails("User3", "user3password",
				"user3deviceId"));
		// usernametoken
		mongoOperation.save(new UserNameToken("User1", "user1token"));
		mongoOperation.save(new UserNameToken("User2", "user2token"));
		mongoOperation.save(new UserNameToken("User3", "user3token"));
		//attendence
//		mongoOperation.save(new AttendenceModel("User1", 0, 0, 300, 0));
//		mongoOperation.save(new AttendenceModel("User2", 0, 0, 300, 0));
//		mongoOperation.save(new AttendenceModel("User3", 0, 0, 300, 0));
		
		//appointments
		AppointmentData appointmentData1 = new AppointmentData(
				"Rahi PG for ladies",
				"PG",
				"RahiPGKormangalaUniqueId",
				"Kormanagala 5th Block",
				"Bangalore",
				"Tuesday March 13, 2015",
				"03:30 am",
				"04:30 pm",
				"Dont forget neighbourhood pictures..You missed that last time",
				new Location(47.608942, -122.340145));
		AppointmentData appointmentData2 = new AppointmentData(
				"Woods Society",
				"Building",
				"WoodsSocietyUniqueId",
				"Kormanagala 5th Block",
				"Bangalore",
				"Tuesday March 13, 2015",
				"03:30 am",
				"04:30 pm",
				"Dont forget neighbourhood pictures..You missed that last time",
				new Location(47.608942, -122.340145));
		AppointmentData appointmentData3 = new AppointmentData(
				"Rhythm",
				"Building",
				"RhythmBuildingMarathalliUniqueId",
				"Kormanagala 5th Block",
				"Bangalore",
				"Tuesday March 14, 2015",
				"04:30 am",
				"05:30 pm",
				"Dont forget neighbourhood pictures..You missed that last time",
				new Location(47.608942, -122.340145));
		AppointmentData appointmentData4 = new AppointmentData(
				"Rhythm",
				"Building",
				"RhythmBuildingMarathalliUniqueId",
				"Kormanagala 5th Block",
				"Bangalore",
				"Tuesday March 13, 2015",
				"05:30 am",
				"06:30 pm",
				"Dont forget neighbourhood pictures..You missed that last time",
				new Location(47.608942, -122.340145));

		List<AppointmentData> appointmentList = new LinkedList<>();
//		appointmentList.add(appointmentData1);
//		appointmentList.add(appointmentData2);
//		appointmentList.add(appointmentData3);
//		appointmentList.add(appointmentData4);
		
		appointmentList.add(appointmentData2);
		appointmentList.add(appointmentData4);
		appointmentList.add(appointmentData1);
		appointmentList.add(appointmentData3);
		mongoOperation.save(new AppointmentDataModel("User1", appointmentList));

		return ("populate collections worked: all collections populated");

	}

}
