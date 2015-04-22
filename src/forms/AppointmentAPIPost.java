package forms;

import helperclasses.STATUS;

import java.util.List;

@SuppressWarnings("unused")
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

	

}
