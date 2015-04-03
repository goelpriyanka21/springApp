package helperclasses;

public class ErrorFieldAndMessage {
	private String errorfield;
	private String errormessage;

	public ErrorFieldAndMessage(String errorfield, String errormessage) {
		// TODO Auto-generated constructor stub
		this.setErrorfield(errorfield);
		this.setErrormessage(errormessage);
	}

	public String getErrorfield() {
		return errorfield;
	}

	public void setErrorfield(String errorfield) {
		this.errorfield = errorfield;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

}
