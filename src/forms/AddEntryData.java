package forms;

import helperclasses.Location;

public class AddEntryData {

	// GET
	private String username;
	private String deviceId;
	private Location gpslocation;
	private String token;
	private String propertyNameinitials;
	private String propertyId;

	public AddEntryData(String username, String deviceId, Location gpslocation,
			String token, String propertyNameinitials, String propertyId) {
		this.username = username;
		this.deviceId = deviceId;
		this.gpslocation = gpslocation;
		this.token = token;
		this.setPropertyNameinitials(propertyNameinitials);
		this.propertyId = propertyId;
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

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyNameinitials() {
		return propertyNameinitials;
	}

	public void setPropertyNameinitials(String propertyNameinitials) {
		this.propertyNameinitials = propertyNameinitials;
	}

}
