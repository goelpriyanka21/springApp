package forms;

import helperclasses.Location;

public class AppointmentData {

	private String appointmentId;
	private String propertyName;
	private String propertyType;
	private String addressline1;
	private String addressline2;
	private String date; //date in string format
	private String appointmentstarttime;
	private String appointmentendtime;
		
	private String notes;
	private Location location;

	public AppointmentData(String appointmentId, String propertyName,
			String propertyType, String addressline1, String addressline2,
			 String date, String appointmentstarttime, String appointmentendtime,
			String notes, Location location) {
		// TODO Auto-generated constructor stub
		this.appointmentId = appointmentId;
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.date = date;
		this.appointmentstarttime = appointmentstarttime;
		this.appointmentendtime = appointmentendtime;
		this.notes = notes;
		this.setLocation(location);
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAppointmentstarttime() {
		return appointmentstarttime;
	}

	public String getAppointmentendtime() {
		return appointmentendtime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
