package forms;

import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfPhotoNameAndURLPair;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

public class FlatData {

	private List<SectionListOfPhotoNameAndURLPair> picturelist;
	private String flatnumber;
	private Integer floornumber;
	private Integer numOfBathrooms;
	private Integer numOfBalconys;
	private String furnishingtype;
	private String flattype;
	private String facing;
	private Integer rent;
	private Integer maintainancecharges;
	private Integer deposit;
	private Boolean negotiable;
	private List<String> availableFor;
	private RatingAndListOfEs<String> amenities;
	private String servicesyouwillbeinterestedin;

	public FlatData() {

	}

	public List<SectionListOfPhotoNameAndURLPair> getPicturelist() {
		return picturelist;
	}

	public void setPicturelist(
			List<SectionListOfPhotoNameAndURLPair> picturelist) {
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

	public FlatData(
			// GET

			List<SectionListOfPhotoNameAndURLPair> picturelist,
			String flatnumber, Integer floornumber, Integer numOfBathrooms,
			Integer numOfBalconys, String furnishingtype, String flattype,
			String facing, Integer rent, Integer maintainancecharges,
			Integer deposit, Boolean negotiable, List<String> availableFor,
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
	
	private int totalPictures() {
		int photocount = 0;
		for (SectionListOfPhotoNameAndURLPair pair : picturelist) {
			photocount += pair.getPhotonamelist().size();
		}
		return photocount;

	}
	

	private JsonObject defineError(String name, String val) {
		JsonObject o = new JsonObject();
		o.addProperty(name, val);
		return o;
	}

	public List<JsonObject> validate() {
		// TODO Auto-generated method stub
		List<JsonObject> errors = new ArrayList<>();

		if (flatnumber == null) {
			errors.add(defineError("flatnumber", FlatDataErrMsgs.FLATNUMBER_ERR));
		}
		
		if ((picturelist == null) || (picturelist.size() == 0)
				|| (totalPictures() < 5)) {
			errors.add(defineError("picturelist",
					FlatDataErrMsgs.PICTURE_LIST_ERR));
		}
		
		if ((availableFor == null) || (availableFor.size() == 0)) {
			errors.add(defineError("availableFor",
					FlatDataErrMsgs.AVAILABLE_FOR_ERR));
		}

		return errors.size() > 0 ? errors : null;
	}

}

class FlatDataErrMsgs {
	public static final String FLATNUMBER_ERR = "flat number cannot be left blank";
	static final String PICTURE_LIST_ERR = "Picture list cannot be blank/ size zero/ should contain at least 5 photo names";
	static final String AVAILABLE_FOR_ERR = "availableFor cannot be left blank/ size cannot be zero";
}
