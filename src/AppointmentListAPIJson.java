import helperclasses.Location;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import forms.AppointmentData;

public class AppointmentListAPIJson {
	static FileWriter writer;

	public static void main(String[] args) throws IOException, ParseException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// write converted json data to a file named "CountryGSON.json"
		writer = new FileWriter(
				"/Users/priyanka/git/grabhouse//AppointmentListAPIJson.json");

		// POST: Appointment list

		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		
		//appointments
		AppointmentData appointmentData1 = new AppointmentData(
				"RahiPGKormangalaAppointmentId",
				"", 
				"Rahi PG for ladies",
				"PG",
				"Kormanagala 5th Block",
				"Bangalore",
				sdf.parse("13-03-2015 05:30"),
				sdf.parse("13-03-2015 07:30"),
				"Dont forget neighbourhood pictures..You missed that last time",
				new Location(47.608942, -122.340145));
		AppointmentData appointmentData2 = new AppointmentData(
				"WoodsSocietyAppointmentId",
				"WoodsSocietyPropertyId",
				"Woods Society",
				"Building",
				"Kormanagala 5th Block",
				"Bangalore",
				sdf.parse("13-03-2015 08:30"),
				sdf.parse("13-03-2015 09:30"),
				"Dont forget neighbourhood pictures..You missed that last time",
				new Location(47.608942, -122.340145));
		AppointmentData appointmentData3 = new AppointmentData(
				"RhythmBuildingMarathalliAppointmentId",
				"",
				"Rhythm",
				"Building",
				"Kormanagala 5th Block",
				"Bangalore",
				sdf.parse("14-03-2015 02:30"),
				sdf.parse("14-03-2015 03:30"),
				"Dont forget neighbourhood pictures..You missed that last time",
				new Location(47.608942, -122.340145));
		AppointmentData appointmentData4 = new AppointmentData(
				"SattireBuildingMarathalliAppointmentId",
				"SattireBuildingMarathalliPropertyId",
				"Sattire",
				"Building",
				"Kormanagala 5th Block",
				"Bangalore",
				sdf.parse("13-03-2015 02:30"),
				sdf.parse("13-03-2015 03:30"),
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
		String appointmentListpostjson = gson.toJson(appointmentList);
		System.out.println(appointmentListpostjson);
		writer.append("//POST\n");
		writer.append(appointmentListpostjson + "\n\n");

		

		writer.close();
	}

}
