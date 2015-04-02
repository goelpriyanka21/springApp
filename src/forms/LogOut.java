package forms;

import helperclasses.Location;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class LogOut {

	@Id
    private String id;
//GET
    private String username;
    private String deviceId;
	private Location gpslocation;
	
	
	//POST
	private String status;
	private String message;
	
    
    public LogOut() {}

    public LogOut(String username, String deviceId, Location gpslocation) {
        this.username = username;
        this.gpslocation = gpslocation;
        this.deviceId = deviceId;
        
    }

    public LogOut(String status, String message) {
		// TODO Auto-generated constructor stub
    	this.status = status;
        this.message = message;
        
	}

	@Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s']",
                id, username);
    }

}
