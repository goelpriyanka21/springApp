package forms;

import helperclasses.STATUS;

import java.util.List;

import com.google.gson.JsonObject;

@SuppressWarnings("unused")
public class PostForm {

	// POST
	private STATUS status;
	private String message;
	private String token;
	private List<JsonObject> errors;
	private List<AppointmentData> appointmentList;

	public PostForm(STATUS status, String message) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
	}

	public PostForm(STATUS status, String message, List<JsonObject> errors) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public PostForm(STATUS status, String message, String token) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
		this.token = token;
	}

	public STATUS getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}