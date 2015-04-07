package forms;

import java.sql.Time;
import java.util.*;



import helperclasses.Location;
import helperclasses.PropertyNameTypeisLocked;



public class AppointmentList {
	
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
			String addressline1; String addressline2; Date date; Time appointmentstarttime; Time appointmentendtime; String notes;
			
		
		
		public AppointmentList(String username, String deviceId, Location gpslocation,
				String token) {
			// TODO Auto-generated constructor stub
			this.username= username;
			this.deviceId= deviceId;
			this.gpslocation= gpslocation;
			this.token= token;
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
		
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Location getGpslocation() {
		return gpslocation;
	}

	public void setGpslocation(Location gpslocation) {
		this.gpslocation = gpslocation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<PropertyNameTypeisLocked> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<PropertyNameTypeisLocked> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public PropertyNameTypeisLocked getSelectedappointment() {
		return selectedappointment;
	}

	public void setSelectedappointment(PropertyNameTypeisLocked selectedappointment) {
		this.selectedappointment = selectedappointment;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getAppointmentstarttime() {
		return appointmentstarttime;
	}

	public void setAppointmentstarttime(Time appointmentstarttime) {
		this.appointmentstarttime = appointmentstarttime;
	}

	public Time getAppointmentendtime() {
		return appointmentendtime;
	}

	public void setAppointmentendtime(Time appointmentendtime) {
		this.appointmentendtime = appointmentendtime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
