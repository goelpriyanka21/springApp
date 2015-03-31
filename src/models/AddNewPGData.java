package models;


import helperclasses.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



/**
 * Backing class for the PG data form.
 * Requirements:
 * <ul>
 * <li> All fields are public, 
 * <li> All fields are of type String or List[String].
 * <li> A public no-arg constructor.
 * <li> A validate() method that returns null or a List[ValidationError].
 * </ul>
 */

public class AddNewPGData {
	//GET
	public String username;
	public String DeviceId;
	public Location gpslocation;
	public String token;
	public String pgName;
  public List<SectionListOfFilePair> picturelist;
  
  public String buildingname;
  public String addressl1;
  public String addressl2;
  public Integer pincode;
  public String landmark;
  public DepositAmount depositamount;
  public List<String> availableFor; 
  public StudProfper stdprofper;
  public String typeofprofessional;
  public TwoIntegerpair ageband;
  public Boolean spacious;
  public Boolean clean;
  public RatingAndListOfEs typesandavailability;
  public RatingAndListOfEs serviceavailable; 
  public RatingAndListOfEs fooddetails; 
  public RatingAndListOfEs chargedamenities; 
  public RatingAndListOfEs restrictions; 
  private EntryTime entrytime;
  public Location selectedlocation;
  
//POST
	private String status;
	private String message;
  


  
  /** Required for form instantiation. */
  public AddNewPGData(String username,  String DeviceId, Location gpslocation, String token, String pgName, List<SectionListOfFilePair> picturelist, String buildingname, String addressl1, String addressl2, int pincode, String landmark, DepositAmount depositamount, List<String> availableFor, StudProfper stdprofper, String typeofprofessional, TwoIntegerpair ageband, boolean spacious, boolean clean, RatingAndListOfEs typesandavailability, RatingAndListOfEs serviceavailable, RatingAndListOfEs fooddetails, RatingAndListOfEs chargedamenities, RatingAndListOfEs restrictions, EntryTime entrytime, Location selectedlocation) {
  this.username= username;
  this.gpslocation= gpslocation;
  this.DeviceId= DeviceId;
  this.token= token;
  this.picturelist= picturelist;
  this.pgName= pgName;
  this.picturelist= picturelist;
  this.buildingname= buildingname;
  this.addressl1= addressl1;
  this.addressl2= addressl2;
  this.pincode= pincode;
  this.landmark= landmark;
  this.depositamount= depositamount;
  this.availableFor= availableFor;
  this.stdprofper= stdprofper;
  this.ageband= ageband;
  this.typeofprofessional= typeofprofessional;
  this.spacious= spacious;
  this.clean= clean;
  this.typesandavailability= typesandavailability;
  this.serviceavailable= serviceavailable;
  this.fooddetails= fooddetails;
  this.chargedamenities= chargedamenities;
  this.restrictions= restrictions;
  this.entrytime= entrytime;
  this.selectedlocation= selectedlocation;
  }
  
  public AddNewPGData(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.status= string;
		this.message= string2;
	}


public void setusername(String username) {
		// TODO Auto-generated method stub
		this.username= username;
	}

public String getPgName() {
	return pgName;
}

public void setPgName(String pgName) {
	this.pgName = pgName;
}

public String getAddressl1() {
	return addressl1;
}

public void setAddressl1(String addressl1) {
	this.addressl1 = addressl1;
}

public String getAddressl2() {
	return addressl2;
}

public void setAddressl2(String addressl2) {
	this.addressl2 = addressl2;
}

public int getPincode() {
	return pincode;
}

public void setPincode(int pincode) {
	this.pincode = pincode;
}

public String getLandmark() {
	return landmark;
}

public void setLandmark(String landmark) {
	this.landmark = landmark;
}

public DepositAmount getDepositamount() {
	return depositamount;
}

public void setDepositamount(DepositAmount depositamount) {
	this.depositamount = depositamount;
}

public List<String> getAvailableFor() {
	return availableFor;
}

public void setAvailableFor(List<String> availableFor) {
	for(String availablefor: availableFor)
	this.availableFor.add(availablefor); 
}

//public List<RatingAndListOfEs> getTypesandavailability() {
//	return typesandavailability;
//}
//
//public void setTypesandavailability(List<RatingAndListOfEs> typesandavailability) {
//	this.typesandavailability = typesandavailability;
//}

//public ServiceAvailable getServiceavailable() {
//	return serviceavailable;
//}
//
//public void setServiceavailable(ServiceAvailable serviceavailable) {
//	this.serviceavailable = serviceavailable;
//}
//
//public FoodDetails getFooddetails() {
//	return fooddetails;
//}
//
//public void setFooddetails(FoodDetails fooddetails) {
//	this.fooddetails = fooddetails;
//}

//public List<String> getRestrictions() {
//	return restrictions;
//}
//
//public void setRestrictions(List<String> restrictions) {
//	this.restrictions = restrictions;
//}

//public ChargedAmenities getChargedamenities() {
//	return chargedamenities;
//}
//
//public void setChargedamenities(ChargedAmenities chargedamenities) {
//	this.chargedamenities = chargedamenities;
//}

//public List<SectionFilePair> getPicture() {
//	return picturelist;
//}
//
//public void setPicturelist(List<SectionFilePair> picture) {
//	this.picturelist = picture;
//}

}






