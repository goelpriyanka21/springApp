package forms;


public class HomePageData {
	
	//GET
    private String username;
    private String deviceId;
	private String token;
	//POST
	private String status;
	private String message;
	
private Integer numoftodayentries;
private Integer numofcurrentmonthentries;
private Integer targetforthemonth;
private Double targetachieved;

public HomePageData(String username, String deviceId, String token){
	this.username= username;
	this.deviceId= deviceId;
	this.token= token;
	
}

public HomePageData(int numoftodayentries, int numofcurrentmonthentries, int targetforthemonth, Double targetachieved){
	this.numoftodayentries=numoftodayentries;
	this.numofcurrentmonthentries=numofcurrentmonthentries;
	this.targetforthemonth=targetforthemonth;
	this.targetachieved=targetachieved;
	
}

public HomePageData(String status, String message) {
	// TODO Auto-generated constructor stub
	this.setStatus(status);
	this.setMessage(message);
}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getNumoftodayentries() {
		return numoftodayentries;
	}

	public void setNumoftodayentries(Integer numoftodayentries) {
		this.numoftodayentries = numoftodayentries;
	}

	public Integer getNumofcurrentmonthentries() {
		return numofcurrentmonthentries;
	}

	public void setNumofcurrentmonthentries(Integer numofcurrentmonthentries) {
		this.numofcurrentmonthentries = numofcurrentmonthentries;
	}

	public Integer getTargetforthemonth() {
		return targetforthemonth;
	}

	public void setTargetforthemonth(Integer targetforthemonth) {
		this.targetforthemonth = targetforthemonth;
	}

	public Double getTargetachieved() {
		return targetachieved;
	}

	public void setTargetachieved(Double targetachieved) {
		this.targetachieved = targetachieved;
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

	

}
