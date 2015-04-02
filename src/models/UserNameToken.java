package models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usernametoken")
public class UserNameToken {
	String username;
	String token;
	
	public UserNameToken(String username, String token){
		this.username= username;
		this.token= token;
	}

	public String gettoken() {
		// TODO Auto-generated method stub
		return token;
	}

}
