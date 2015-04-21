package forms;

import helperclasses.STATUS;

import java.util.List;

public class AppointmentAPIPost {

	private STATUS status;
	private String message;
	private List<AppointmentData> appointmentList;

	public AppointmentAPIPost(STATUS status, String message,
			List<AppointmentData> appointmentList) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
		this.appointmentList = appointmentList;
	}

	public AppointmentAPIPost(STATUS status, String message) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<AppointmentData> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<AppointmentData> appointmentList) {
		this.appointmentList = appointmentList;
	}

}
