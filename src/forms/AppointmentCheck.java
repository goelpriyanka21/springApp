package forms;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import helperclasses.Location;
import helperclasses.PropertyNameTypeisLocked;
import helperclasses.PropertyNameTypeisLocked;


public class AppointmentCheck {
	
	public AppointmentCheck(String string, String string2, Location location,
			String string3,  List<PropertyNameTypeisLocked> asList) {
		// TODO Auto-generated constructor stub
		this.username= string;
		this.deviceId= string2;
		this.gpslocation= location;
		this.token= string3;
		this.appointmentdoneList= asList;
	}
		public AppointmentCheck(String string, String string2) {
		// TODO Auto-generated constructor stub
			this.status= string;
			this.message= string2;
	}
		// GET
		private String username;
	    private String deviceId;
		private Location gpslocation;
		private String token;
		
		private List<PropertyNameTypeisLocked> appointmentdoneList;  // will contain property name and type
		
		//POST
		private String status;
		private String message;
		

}
