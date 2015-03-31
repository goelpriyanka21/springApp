package models;

import java.sql.Time;
import java.util.*;

import helperclasses.Location;
import helperclasses.PropertyNameTypeisLocked;
import helperclasses.PropertyNameTypeisLocked;

public class AppointmentList {
	
	
	public AppointmentList(String string, String string2, Location location,
			String string3) {
		// TODO Auto-generated constructor stub
		this.username= username;
		this.deviceId= string2;
		this.gpslocation= location;
		this.token= string3;
	}
	public AppointmentList(List<PropertyNameTypeisLocked> asList) {
		this.appointmentList= asList;
		// TODO Auto-generated constructor stub
	}
	public AppointmentList(PropertyNameTypeisLocked selectedappointment) {
		// TODO Auto-generated constructor stub
		this.selectedappointment= selectedappointment;
	}
	
	public AppointmentList(PropertyNameTypeisLocked selectedappointment, String addressline1, String addressline2, Date date, Time appointmentstarttime, Time appointmentendtime, String notes) {
		// TODO Auto-generated constructor stub
		this.selectedappointment= selectedappointment;
		this.addressline1= addressline1;
		this.addressline2= addressline2;
		this.date= date;
		this.appointmentstarttime= appointmentstarttime;
		this.appointmentendtime= appointmentendtime;
		this.notes= notes;
	}
	
	

	// GET
	private String username;
    private String deviceId;
	private Location gpslocation;
	private String token;
	
	//POST
	private List<PropertyNameTypeisLocked> appointmentList;  // will contain property name and type
	
	//GET
	private PropertyNameTypeisLocked selectedappointment;
	
	//POST
	private String addressline1;
	private String addressline2;
	private Date date;
	private Time appointmentstarttime;
	private Time appointmentendtime;
	
	private String notes;
	
	
	
	
	

}
