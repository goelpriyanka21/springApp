package forms;

import helperclasses.Location;

import java.util.Date;

public class AppointmentData implements Comparable<AppointmentData> {
	
//	@Id
	private String appointmentId;
	private String propertyId;
	private String propertyName;
	private String propertyType;
	private String addressline1;
	private String addressline2;
	private Date appointmentStTime;
	private Date appointmentEndTime;
		
	private String notes;
	private Location location;

	public AppointmentData(String appointmentId, String propertyId, String propertyName,
			String propertyType, String addressline1, String addressline2,
			 Date appointmentStTime, Date appointmentEndTime,
			String notes, Location location) {
		// TODO Auto-generated constructor stub
		this.appointmentId = appointmentId;
		this.setPropertyId(propertyId);
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.appointmentStTime = appointmentStTime;
		this.appointmentEndTime = appointmentEndTime;
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

	public Date getAppointmentstarttime() {
		return appointmentStTime;
	}

	public Date getAppointmentendtime() {
		return appointmentEndTime;
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

	@Override
	public int compareTo(AppointmentData o) {
		long startThis = appointmentStTime.getTime();
		long startThat = o.appointmentStTime.getTime();
		
		return Long.compare(startThis, startThat);
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	

}
