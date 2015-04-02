import forms.AppointmentList;
import forms.EntryPage;
import forms.Login;
import helperclasses.Location;
import helperclasses.PropertyNameTypeisLocked;
import helperclasses.PropertyNameTypeisLocked;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AppointmentListAPIJson {
	static FileWriter writer;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//AppointmentListAPIJson.json"); 
		
		//GET
	    AppointmentList appointmentListget = new AppointmentList("Priyanka", "ba435a", new Location(47.608941, -122.340145), "priyatoekn123");
		String appointmentListgetjson = gson.toJson(appointmentListget);
		System.out.println(appointmentListgetjson);
		writer.append("//GET\n");
		writer.append(appointmentListgetjson+"\n\n"); 
		
		
		
		//POST: Appointment list
		PropertyNameTypeisLocked pntp1= new PropertyNameTypeisLocked("Rahi PG for ladies", "PG", "RahiPGKormangalaUniqueId");
		PropertyNameTypeisLocked pntp2= new PropertyNameTypeisLocked("Woods Society", "Building", "WoodsSocietyUniqueId");
		PropertyNameTypeisLocked pntp3= new PropertyNameTypeisLocked("Rhythm", "Building", "RhythmBuildingMarathalliUniqueId");
		AppointmentList appointmentListpost = new AppointmentList(Arrays.asList(pntp1, pntp2, pntp3));
		String appointmentListpostjson = gson.toJson(appointmentListpost);
		System.out.println(appointmentListpostjson);	  
		writer.append("//POST\n");
		writer.append(appointmentListpostjson+"\n\n");
		
		//GET
	     appointmentListget = new AppointmentList(pntp3);
		 appointmentListgetjson = gson.toJson(appointmentListget);
		System.out.println(appointmentListgetjson);
		writer.append("//GET\n");
		writer.append(appointmentListgetjson+"\n\n"); 
		
		
		//POST: Appointment list
				 appointmentListpost = new AppointmentList(pntp3, "Kormanagala 5th Block", "Bangalore", new Date(115, 02, 13, 0, 0), new Time(3, 30, 00), new Time(4, 30, 00), "Dont forget neighbourhood pictures..You missed that last time");
				 appointmentListpostjson = gson.toJson(appointmentListpost);
				System.out.println(appointmentListpostjson);	  
				writer.append("//POST\n");
				writer.append(appointmentListpostjson+"\n\n");
		
		 writer.close();
	}

}
