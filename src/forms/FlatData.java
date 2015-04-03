package forms;


import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfFileNamePair;

import java.util.List;

public class FlatData {

	public List<SectionListOfFileNamePair> picturelist;
	public List<SectionListOfFileNamePair> getPicturelist() {
		return picturelist;
	}

	public void setPicturelist(List<SectionListOfFileNamePair> picturelist) {
		this.picturelist = picturelist;
	}

	public String getFlatnumber() {
		return flatnumber;
	}

	public void setFlatnumber(String flatnumber) {
		this.flatnumber = flatnumber;
	}

	public Integer getFloornumber() {
		return floornumber;
	}

	public void setFloornumber(Integer floornumber) {
		this.floornumber = floornumber;
	}

	public Integer getNumOfBathrooms() {
		return numOfBathrooms;
	}

	public void setNumOfBathrooms(Integer numOfBathrooms) {
		this.numOfBathrooms = numOfBathrooms;
	}

	public Integer getNumOfBalconys() {
		return numOfBalconys;
	}

	public void setNumOfBalconys(Integer numOfBalconys) {
		this.numOfBalconys = numOfBalconys;
	}

	public String getFurnishingtype() {
		return furnishingtype;
	}

	public void setFurnishingtype(String furnishingtype) {
		this.furnishingtype = furnishingtype;
	}

	public String getFlattype() {
		return flattype;
	}

	public void setFlattype(String flattype) {
		this.flattype = flattype;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	public Integer getMaintainancecharges() {
		return maintainancecharges;
	}

	public void setMaintainancecharges(Integer maintainancecharges) {
		this.maintainancecharges = maintainancecharges;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Boolean getNegotiable() {
		return negotiable;
	}

	public void setNegotiable(Boolean negotiable) {
		this.negotiable = negotiable;
	}

	public List<String> getAvailableFor() {
		return availableFor;
	}

	public void setAvailableFor(List<String> availableFor) {
		this.availableFor = availableFor;
	}

	public RatingAndListOfEs<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(RatingAndListOfEs<String> amenities) {
		this.amenities = amenities;
	}

	public String getServicesyouwillbeinterestedin() {
		return servicesyouwillbeinterestedin;
	}

	public void setServicesyouwillbeinterestedin(
			String servicesyouwillbeinterestedin) {
		this.servicesyouwillbeinterestedin = servicesyouwillbeinterestedin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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
