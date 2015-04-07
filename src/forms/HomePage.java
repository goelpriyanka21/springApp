package forms;


public class HomePage {
	
	//GET
    private String username;
    private String deviceId;
	private String token;
	//POST
Integer numoftodayentries;
Integer numofcurrentmonthentries;
Integer targetforthemonth;
Integer targetachieved;

public HomePage(String username, String deviceId, String token){
	this.username= username;
	this.deviceId= deviceId;
	this.token= token;
	
}

public HomePage(int numoftodayentries, int numofcurrentmonthentries, int targetforthemonth, int targetachieved){
	this.numoftodayentries=numoftodayentries;
	this.numofcurrentmonthentries=numofcurrentmonthentries;
	this.targetforthemonth=targetforthemonth;
	this.targetachieved=targetachieved;
	
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

	public Integer getTargetachieved() {
		return targetachieved;
	}

	public void setTargetachieved(Integer targetachieved) {
		this.targetachieved = targetachieved;
	}

	

}
