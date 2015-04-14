import helperclasses.Location;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import forms.AppointmentData;

public class AppointmentListAPIJson {
	static FileWriter writer;

	public static void main(String[] args) throws IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// write converted json data to a file named "CountryGSON.json"
		writer = new FileWriter(
				"/Users/priyanka/git/grabhouse//AppointmentListAPIJson.json");

		// POST: Appointment list

		AppointmentData appointmentData1 = new AppointmentData(
				"Rahi PG for ladies",
				"PG",
				"RahiPGKormangalaUniqueId",
				"Kormanagala 5th Block",
				"Bangalore",
				"Tuesday March 13, 2015",
				"05:30 am",
				"07:30 pm",
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
		appointmentList.add(appointmentData1);
		appointmentList.add(appointmentData2);
		appointmentList.add(appointmentData3);
		appointmentList.add(appointmentData4);
		String appointmentListpostjson = gson.toJson(appointmentList);
		System.out.println(appointmentListpostjson);
		writer.append("//POST\n");
		writer.append(appointmentListpostjson + "\n\n");

		

		writer.close();
	}

}
