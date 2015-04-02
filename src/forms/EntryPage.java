package forms;

import java.util.List;

import helperclasses.Location;
import helperclasses.PropertyNameTypeisLocked;
import helperclasses.PropertyNameTypeisLocked;

public class EntryPage {
	//GET
    private String username;
    private String deviceId;
	private Location gpslocation;
	private String token;
	
	//POST:failure
	private String status;
	private String message;
	
	//POST: on the basis of location
	private List<PropertyNameTypeisLocked> propertyNameTypeisLocked;
	
	
	//GET
	private String propertyId;
	
	//POST
	private Boolean isLocked;
	
	
	
	public EntryPage(String username, String deviceId, Location gpslocation, String token){
		this.username= username;
		this.deviceId= deviceId;
		this.gpslocation= gpslocation;
		this.token= token;
	}
	
	public EntryPage(List<PropertyNameTypeisLocked> propertyNameTypeisLocked){
		this.propertyNameTypeisLocked= propertyNameTypeisLocked;
		
	}
	
	public EntryPage(String propertyId){
		this.propertyId= propertyId;
	}
	
	public EntryPage(boolean isLocked){
		this.isLocked= isLocked;
		
	}

	public EntryPage(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.status= string;
		this.message= string2;
	}

}


