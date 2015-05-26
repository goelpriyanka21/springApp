package forms;

import helperclasses.Location;

import java.util.Date;

@SuppressWarnings("unused")
public class AppointmentData implements Comparable<AppointmentData> {

	// @Id
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

	public AppointmentData(String appointmentId, String propertyId,
			String propertyName, String propertyType, String addressline1,
			String addressline2, Date appointmentStTime,
			Date appointmentEndTime, String notes, Location location) {
		// TODO Auto-generated constructor stub
		this.appointmentId = appointmentId;
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.appointmentStTime = appointmentStTime;
		this.appointmentEndTime = appointmentEndTime;
		this.notes = notes;
		this.location = location;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	@Override
	public int compareTo(AppointmentData o) {
		Long startThis = appointmentStTime.getTime();
		Long startThat = o.appointmentStTime.getTime();

		return startThis.compareTo(startThat);
		// return Long.compare(startThis, startThat);
	}

}
