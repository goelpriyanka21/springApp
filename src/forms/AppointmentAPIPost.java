package forms;

import java.util.List;

public class AppointmentAPIPost {

	private String status;
	private String message;
	private List<AppointmentData> appointmentList;

	public AppointmentAPIPost(String status, String message,
			List<AppointmentData> appointmentList) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
		this.appointmentList = appointmentList;
	}

	public AppointmentAPIPost(String status, String message) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
