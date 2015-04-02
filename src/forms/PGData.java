package forms;

import helperclasses.*;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PGData {

	// specific to a pg
	@NotNull
	public List<SectionListOfFileNamePair> picturelist;
	@NotNull
	@Size(max = 50)
	public String pgName;
	@Size(max = 50)
	public String buildingname;
	@NotNull
	@Size(max = 100)
	public String addressl1;
	@NotNull
	@Size(max = 100)
	public String addressl2;
	@NotNull
	@Max(18)
	public Integer pincode;
	@Size(max = 100)
	public String landmark;
	public DepositAmount depositamount;
	@NotNull
	@Size(min = 1)
	private List<String> availableFor;
	private StudProfper stdprofper;
	@Size(max = 100)
	public String typeofprofessional;
	private TwoIntegerpair ageband;
	public Boolean spacious;
	public Boolean clean;
	public RatingAndListOfEs<SharingTypeRentbedsCombo> typesandavailability;
	public RatingAndListOfEs<String> serviceavailable;
	public RatingAndListOfEs<String> fooddetails;
	public RatingAndListOfEs<AmenityTypePricePair> chargedamenities;
	public RatingAndListOfEs<String> restrictions;
	private EntryTime entrytime;
	@NotNull
	private Location selectedlocation;

	/** Required for form instantiation. */
	public PGData(String pgName, List<SectionListOfFileNamePair> picturelist,
			String buildingname, String addressl1, String addressl2,
			int pincode, String landmark, DepositAmount depositamount,
			List<String> availableFor, StudProfper stdprofper,
			String typeofprofessional, TwoIntegerpair ageband,
			boolean spacious, boolean clean,
			RatingAndListOfEs<SharingTypeRentbedsCombo> typesandavailability,
			RatingAndListOfEs<String> serviceavailable,
			RatingAndListOfEs<String> fooddetails,
			RatingAndListOfEs<AmenityTypePricePair> chargedamenities,
			RatingAndListOfEs<String> restrictions, EntryTime entrytime,
			Location selectedlocation) {

		this.picturelist = picturelist;

		this.pgName = pgName;
		this.buildingname = buildingname;
		this.addressl1 = addressl1;
		this.addressl2 = addressl2;
		this.pincode = pincode;
		this.landmark = landmark;

		this.depositamount = depositamount;
		this.availableFor = availableFor;
		this.stdprofper = stdprofper;
		this.ageband = ageband;
		this.typeofprofessional = typeofprofessional;
		this.spacious = spacious;
		this.clean = clean;
		this.typesandavailability = typesandavailability;
		this.serviceavailable = serviceavailable;
		this.fooddetails = fooddetails;
		this.chargedamenities = chargedamenities;
		this.restrictions = restrictions;
		this.setEntrytime(entrytime);
		this.selectedlocation = selectedlocation;

	}

	public Location getselectedlocation() {
		return selectedlocation;
	}

	public void setselectedlocation(Location selectedlocation) {
		this.selectedlocation = selectedlocation;
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
		for (String availablefor : availableFor)
			this.availableFor.add(availablefor);

	}

	public StudProfper getStdprofper() {
		return stdprofper;
	}

	public TwoIntegerpair getAgeband() {
		return ageband;
	}

	public List<SectionListOfFileNamePair> getPicturelist() {
		return picturelist;
	}

	public void setPicturelist(List<SectionListOfFileNamePair> picturelist) {
		this.picturelist = picturelist;
	}

	public String getPgName() {
		return pgName;
	}

	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

	public String getBuildingname() {
		return buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public String getTypeofprofessional() {
		return typeofprofessional;
	}

	public void setTypeofprofessional(String typeofprofessional) {
		this.typeofprofessional = typeofprofessional;
	}

	public Boolean getSpacious() {
		return spacious;
	}

	public void setSpacious(Boolean spacious) {
		this.spacious = spacious;
	}

	public Boolean getClean() {
		return clean;
	}

	public void setClean(Boolean clean) {
		this.clean = clean;
	}

	public RatingAndListOfEs<SharingTypeRentbedsCombo> getTypesandavailability() {
		return typesandavailability;
	}

	public void setTypesandavailability(
			RatingAndListOfEs<SharingTypeRentbedsCombo> typesandavailability) {
		this.typesandavailability = typesandavailability;
	}

	public RatingAndListOfEs<String> getServiceavailable() {
		return serviceavailable;
	}

	public void setServiceavailable(RatingAndListOfEs<String> serviceavailable) {
		this.serviceavailable = serviceavailable;
	}

	public RatingAndListOfEs<String> getFooddetails() {
		return fooddetails;
	}

	public void setFooddetails(RatingAndListOfEs<String> fooddetails) {
		this.fooddetails = fooddetails;
	}

	public RatingAndListOfEs<AmenityTypePricePair> getChargedamenities() {
		return chargedamenities;
	}

	public void setChargedamenities(
			RatingAndListOfEs<AmenityTypePricePair> chargedamenities) {
		this.chargedamenities = chargedamenities;
	}

	public RatingAndListOfEs<String> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(RatingAndListOfEs<String> restrictions) {
		this.restrictions = restrictions;
	}

	public Location getSelectedlocation() {
		return selectedlocation;
	}

	public void setSelectedlocation(Location selectedlocation) {
		this.selectedlocation = selectedlocation;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public void setStdprofper(StudProfper stdprofper) {
		this.stdprofper = stdprofper;
	}

	public void setAgeband(TwoIntegerpair ageband) {
		this.ageband = ageband;
	}

	public EntryTime getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(EntryTime entrytime) {
		this.entrytime = entrytime;
	}

	// public List<RatingAndListOfEs> getTypesandavailability() {
	// return typesandavailability;
	// }
	//
	// public void setTypesandavailability(List<RatingAndListOfEs>
	// typesandavailability) {
	// this.typesandavailability = typesandavailability;
	// }

	// public ServiceAvailable getServiceavailable() {
	// return serviceavailable;
	// }
	//
	// public void setServiceavailable(ServiceAvailable serviceavailable) {
	// this.serviceavailable = serviceavailable;
	// }
	//
	// public FoodDetails getFooddetails() {
	// return fooddetails;
	// }
	//
	// public void setFooddetails(FoodDetails fooddetails) {
	// this.fooddetails = fooddetails;
	// }

	// public List<String> getRestrictions() {
	// return restrictions;
	// }
	//
	// public void setRestrictions(List<String> restrictions) {
	// this.restrictions = restrictions;
	// }

	// public ChargedAmenities getChargedamenities() {
	// return chargedamenities;
	// }
	//
	// public void setChargedamenities(ChargedAmenities chargedamenities) {
	// this.chargedamenities = chargedamenities;
	// }

	// public List<SectionFilePair> getPicture() {
	// return picturelist;
	// }
	//
	// public void setPicturelist(List<SectionFilePair> picture) {
	// this.picturelist = picture;
	// }

}
