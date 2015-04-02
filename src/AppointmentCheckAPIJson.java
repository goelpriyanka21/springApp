import forms.AppointmentCheck;
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
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AppointmentCheckAPIJson {
	static FileWriter writer;
	
	
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//AppointmentCheckAPIJson.json"); 
		
		//GET
	    PropertyNameTypeisLocked pntp2= new PropertyNameTypeisLocked("Woods Society", "Building", "WoodsSocietyUniqueId");
	    PropertyNameTypeisLocked pntp3= new PropertyNameTypeisLocked("Rhythm", "Building", "RhythmUniqueID");
		List<PropertyNameTypeisLocked> appointmentdoneList =  (Arrays.asList( pntp2, pntp3));
	    AppointmentCheck appointmentCheckget = new AppointmentCheck("Priyanka", "ba435a", new Location(47.608941, -122.340145), "priyatoken123", appointmentdoneList);
		String appointmentCheckgetjson = gson.toJson(appointmentCheckget);
		System.out.println(appointmentCheckgetjson);
		writer.append("//GET\n");
		writer.append(appointmentCheckgetjson+"\n\n"); 
		
		
		
		//POST: Appointment list successfully updated
		
	    AppointmentCheck appointmentCheckpost = new AppointmentCheck("success", "appointment list successfully updated");
		String appointmentCheckpostjson = gson.toJson(appointmentCheckpost);
		System.out.println(appointmentCheckpostjson);
		writer.append("//GET\n");
		writer.append(appointmentCheckpostjson+"\n\n"); 
		
		
		 writer.close();
	}

}
