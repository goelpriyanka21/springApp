package models;

import helperclasses.Location;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "login")
public class Login {

	@Id
    private String id;
//GET
    private String username;
    private String password;
    private String deviceId;
	private Location gpslocation;
	
	
	//POST
	private String status;
	private String message;
	private String token;
	
    
    public Login() {}

    public Login(String username, String password,  String deviceId, Location gpslocation) {
        this.username = username;
        this.password = password;
        this.gpslocation = gpslocation;
        this.deviceId = deviceId;
        
    }
    
    public Login(String status, String message) {
		// TODO Auto-generated constructor stub
    	this.status = status;
        this.message = message;
        //this.token = token;
	}

    public Login(String status, String message, String token) {
		// TODO Auto-generated constructor stub
    	this.status = status;
        this.message = message;
        this.token = token;
	}

	@Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s']",
                id, username, password);
    }

}
