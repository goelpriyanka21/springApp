package models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "adminauthenticationDetails")
public class AdminAuthenticationDetails {

	private String fosadmin_username;
	private String fosadmin_password;

	public AdminAuthenticationDetails(String fosadmin_username, String fosadmin_password) {
		this.fosadmin_username = fosadmin_username;
		this.fosadmin_password = fosadmin_password;
	}

	public String getUsername() {
		return fosadmin_username;
	}

	public void setUsername(String username) {
		this.fosadmin_username = username;
	}

	public String getPassword() {
		return fosadmin_password;
	}

	public void setPassword(String password) {
		this.fosadmin_password = password;
	}

}
