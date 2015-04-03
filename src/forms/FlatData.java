package forms;


import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfFileNamePair;

import java.util.List;

public class FlatData {

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
	RatingAndListOfEs<String> amenities;
	String servicesyouwillbeinterestedin;
	String status;
	String message;

	public FlatData(
			// GET

			List<SectionListOfFileNamePair> picturelist, String flatnumber,
			Integer floornumber, Integer numOfBathrooms, Integer numOfBalconys,
			String furnishingtype, String flattype, String facing,
			Integer rent, Integer maintainancecharges, Integer deposit,
			Boolean negotiable, List<String> availableFor,
			RatingAndListOfEs<String> amenities,
			String servicesyouwillbeinterestedin) {

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
		

	}

	public FlatData(String status, String message) {
		this.status = status;
		this.message = message;

	}

}
