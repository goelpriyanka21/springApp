package forms;

import helperclasses.ErrorFieldAndMessage;

import java.util.List;

public class PostForm {
	
	// POST
		private String status;
		private String message;
		private String token;
		  private List<ErrorFieldAndMessage> errorfieldandstring;
		  
		  public PostForm(String string, String string2) {
				// TODO Auto-generated constructor stub
				this.setStatus(string);
				this.setMessage(string2);
			}
			
			public PostForm(String string, String string2,
					List<ErrorFieldAndMessage> errorfieldandstring) {
				// TODO Auto-generated constructor stub
				this.setStatus(string);
				this.setMessage(string2);
				this.errorfieldandstring= errorfieldandstring;
			}
			
			public PostForm(String status, String message, String token) {
				// TODO Auto-generated constructor stub
				this.status= status;
				this.message= message;
				this.token= token;
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


}
