package forms;

import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfFileNamePair;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


public class AddNewFlatData {
	// GET
	public String username;
	public String deviceId;
	public Location gpslocation;
	public String token;

	public String societyname;

	public List<SectionListOfFileNamePair> picturelist;
	String flatnumber;
	Integer floornumber;
	Integer numOfBathrooms;
	Integer numOfBalconys;
	String furnishingtype;
	String flattype;
	String facing;
	Integer rent;
	Integer maintainancecharges;
	Integer deposit;
	Boolean negotiable;
	List<String> availableFor;
	RatingAndListOfEs amenities;
	String servicesyouwillbeinterestedin;
	Location selectedlocation;
	String status;
	String message;

	public AddNewFlatData(
			// GET
			String username, 
			String deviceId, 
			Location gpslocation,
			String token,
			String societyname,
			List<SectionListOfFileNamePair> picturelist, String flatnumber,
			Integer floornumber, Integer numOfBathrooms, Integer numOfBalconys,
			String furnishingtype, String flattype, String facing,
			Integer rent, Integer maintainancecharges, Integer deposit,
			Boolean negotiable, List<String> availableFor,
			RatingAndListOfEs amenities, String servicesyouwillbeinterestedin,
			Location selectedlocation) {
		this.username = username;
		this.deviceId = deviceId;
		this.gpslocation = gpslocation;
		this.token = token;
		this.societyname = societyname;
		this.picturelist = picturelist;
		this.flatnumber = flatnumber;
		this.floornumber = floornumber;
		this.numOfBathrooms = numOfBathrooms;
		this.numOfBalconys = numOfBalconys;
		this.furnishingtype = furnishingtype;
		this.flattype = flattype;
		this.facing = facing;
		this.rent = rent;
		this.maintainancecharges = maintainancecharges;
		this.deposit = deposit;
		this.negotiable = negotiable;
		this.availableFor = availableFor;
		this.amenities = amenities;
		this.servicesyouwillbeinterestedin = servicesyouwillbeinterestedin;
		this.selectedlocation = selectedlocation;

	}
	
	public AddNewFlatData(String status, String message){
		this.status= status;
		this.message= message;
		
	}

}
