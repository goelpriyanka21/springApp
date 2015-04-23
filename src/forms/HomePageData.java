package forms;

import helperclasses.STATUS;

@SuppressWarnings("unused")
public class HomePageData {

	// GET
	
	private String username;
	private String deviceId;
	private String token;
	// POST
	private STATUS status;
	private String message;

	private Integer numoftodayentries;
	private Integer numofcurrentmonthentries;
	private Integer targetforthemonth;
	private Double targetachieved;

	public HomePageData(String username, String deviceId, String token) {
		this.username = username;
		this.deviceId = deviceId;
		this.token = token;

	}

	public HomePageData(STATUS status, String message, int numoftodayentries, int numofcurrentmonthentries,
			int targetforthemonth, Double targetachieved) {
		
		this.status = status;
		this.message = message;
		this.numoftodayentries = numoftodayentries;
		this.numofcurrentmonthentries = numofcurrentmonthentries;
		this.targetforthemonth = targetforthemonth;
		this.targetachieved = targetachieved;

	}

	public HomePageData(STATUS status, String message) {
		this.status = status;
		this.message = message;
	}

	public Object getUsername() {
		return this.username;
	}

	public String getToken() {
		return this.token;
	}

}
