package models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authenticationDetails")
public class AuthenticationDetails {

	private String username;
	private String password;
	private String deviceId;
	
	public AuthenticationDetails(String username,
			String password,
			String deviceId) {
		// TODO Auto-generated constructor stub
		this.username= username;
		this.password= password;
		this.deviceId= deviceId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
