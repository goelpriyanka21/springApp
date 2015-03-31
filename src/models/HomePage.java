package models;

import helperclasses.Location;

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

}
