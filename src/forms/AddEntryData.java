package forms;

import helperclasses.Location;

public class AddEntryData {

	// GET
	private String username;
	private String deviceId;
	private Location gpslocation;
	private String token;
	

	public AddEntryData(String username, String deviceId, Location gpslocation,
			String token) {
		this.username = username;
		this.deviceId = deviceId;
		this.gpslocation = gpslocation;
		this.token = token;
		
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

	public Location getGpslocation() {
		return gpslocation;
	}

	public void setGpslocation(Location gpslocation) {
		this.gpslocation = gpslocation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

}
