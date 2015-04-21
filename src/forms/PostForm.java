package forms;

import helperclasses.ErrorFieldAndMessage;
import helperclasses.STATUS;

import java.util.List;

public class PostForm {
	
	// POST
		private STATUS status;
		private String message;
		private String token;
		  private List<ErrorFieldAndMessage> errorfieldandstring;
		  private List<AppointmentData> appointmentList;
		  
		  public PostForm(STATUS status, String msg) {
				// TODO Auto-generated constructor stub
				this.status = status;
				this.message = msg;
			}
			
			public PostForm(STATUS status, String msg,
					List<ErrorFieldAndMessage> errorfieldandstring) {
				// TODO Auto-generated constructor stub
				this.status = status;
				this.message = msg;
				this.errorfieldandstring= errorfieldandstring;
			}
			
			public PostForm(STATUS status, String message, String token) {
				// TODO Auto-generated constructor stub
				this.status= status;
				this.message= message;
				this.token= token;
			}
			
			

			public STATUS getStatus() {
				return status;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			public List<ErrorFieldAndMessage> getErrorfieldandstring() {
				return errorfieldandstring;
			}
			public void setErrorfieldandstring(
					List<ErrorFieldAndMessage> errorfieldandstring) {
				this.errorfieldandstring = errorfieldandstring;
			}

			public String getToken() {
				return token;
			}

			public void setToken(String token) {
				this.token = token;
			}

			public List<AppointmentData> getAppointmentList() {
				return appointmentList;
			}

			public void setAppointmentList(List<AppointmentData> appointmentList) {
				this.appointmentList = appointmentList;
			}
}