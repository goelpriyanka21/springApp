package forms;

import java.util.List;

import helperclasses.FamilyBachPer;
import helperclasses.FlatTypeAvailabilityFlatsCombo;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfFileNamePair;
import helperclasses.TwoIntegerpair;

public class BuildingData {
	// GET

	private String societyname;
	private List<SectionListOfFileNamePair> picturelist;
	private String buildingname;
	private String addressl1;
	private String addressl2;
	private Integer pincode;
	private String landmark;

	private TwoIntegerpair rent;
	private TwoIntegerpair maintainancecharge;
	private TwoIntegerpair depositamount;
	private String buildingage;
	private String buildername;
	private Integer floornum;
	private Integer flatnum;
	private List<String> availableFor;
	private FamilyBachPer familyBachPer;
	private RatingAndListOfEs<FlatTypeAvailabilityFlatsCombo> typesandavailability;
	private RatingAndListOfEs<String> amenities;
	private RatingAndListOfEs<String> servicesavailable;
	private String[] cableoperators;
	private String[] broadbandoperators;
	private List<String> locality;
	private RatingAndListOfEs<String> safety;
	private String othersafetyissuesifany;
	private String gatekeepercontact;
	private String societymanagercontact;
	private String bestthingaboutsociety;
	private String areaofimprovement;
	private Location selectedlocation;

	public BuildingData(

			String societyname,
			List<SectionListOfFileNamePair> picturelist,
			String buildingname,
			String addressl1,
			String addressl2,
			Integer pincode,
			String landmark,

			TwoIntegerpair rent,
			TwoIntegerpair maintainancecharge,
			TwoIntegerpair depositamount,
			String buildingage,
			String buildername,
			Integer floornum,
			Integer flatnum,
			List<String> availableFor,
			FamilyBachPer familyBachPer,
			RatingAndListOfEs<FlatTypeAvailabilityFlatsCombo> typesandavailability,
			RatingAndListOfEs<String> amenities,
			RatingAndListOfEs<String> servicesavailable,
			String[] cableoperators, String[] broadbandoperators,
			List<String> locality, RatingAndListOfEs<String> safety,
			String othersafetyissuesifany, String gatekeepercontact,
			String societymanagercontact, String bestthingaboutsociety,
			String areaofimprovement, Location selectedlocation) {

		this.societyname = societyname;
		this.picturelist = picturelist;
		this.buildingname = buildingname;
		this.addressl1 = addressl1;
		this.addressl2 = addressl2;
		this.pincode = pincode;
		this.landmark = landmark;
		this.rent = rent;
		this.maintainancecharge = maintainancecharge;
		this.depositamount = depositamount;
		this.buildingage = buildingage;
		this.buildername = buildername;
		this.floornum = floornum;
		this.flatnum = flatnum;
		this.availableFor = availableFor;
		this.familyBachPer = familyBachPer;
		this.typesandavailability = typesandavailability;
		this.amenities = amenities;
		this.servicesavailable = servicesavailable;
		this.cableoperators = cableoperators;
		this.broadbandoperators = broadbandoperators;
		this.locality = locality;
		this.safety = safety;
		this.othersafetyissuesifany = othersafetyissuesifany;
		this.gatekeepercontact = gatekeepercontact;
		this.societymanagercontact = societymanagercontact;
		this.bestthingaboutsociety = bestthingaboutsociety;
		this.areaofimprovement = areaofimprovement;
		this.selectedlocation = selectedlocation;

	}

	public String getSocietyname() {
		return societyname;
	}

	public void setSocietyname(String societyname) {
		this.societyname = societyname;
	}

	public List<SectionListOfFileNamePair> getPicturelist() {
		return picturelist;
	}

	public void setPicturelist(List<SectionListOfFileNamePair> picturelist) {
		this.picturelist = picturelist;
	}

	public String getBuildingname() {
		return buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
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

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public TwoIntegerpair getRent() {
		return rent;
	}

	public void setRent(TwoIntegerpair rent) {
		this.rent = rent;
	}

	public TwoIntegerpair getMaintainancecharge() {
		return maintainancecharge;
	}

	public void setMaintainancecharge(TwoIntegerpair maintainancecharge) {
		this.maintainancecharge = maintainancecharge;
	}

	public TwoIntegerpair getDepositamount() {
		return depositamount;
	}

	public void setDepositamount(TwoIntegerpair depositamount) {
		this.depositamount = depositamount;
	}

	public String getBuildingage() {
		return buildingage;
	}

	public void setBuildingage(String buildingage) {
		this.buildingage = buildingage;
	}

	public String getBuildername() {
		return buildername;
	}

	public void setBuildername(String buildername) {
		this.buildername = buildername;
	}

	public Integer getFloornum() {
		return floornum;
	}

	public void setFloornum(Integer floornum) {
		this.floornum = floornum;
	}

	public Integer getFlatnum() {
		return flatnum;
	}

	public void setFlatnum(Integer flatnum) {
		this.flatnum = flatnum;
	}

	public List<String> getAvailableFor() {
		return availableFor;
	}

	public void setAvailableFor(List<String> availableFor) {
		this.availableFor = availableFor;
	}

	public FamilyBachPer getFamilyBachPer() {
		return familyBachPer;
	}

	public void setFamilyBachPer(FamilyBachPer familyBachPer) {
		this.familyBachPer = familyBachPer;
	}

	public RatingAndListOfEs<FlatTypeAvailabilityFlatsCombo> getTypesandavailability() {
		return typesandavailability;
	}

	public void setTypesandavailability(
			RatingAndListOfEs<FlatTypeAvailabilityFlatsCombo> typesandavailability) {
		this.typesandavailability = typesandavailability;
	}

	public RatingAndListOfEs<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(RatingAndListOfEs<String> amenities) {
		this.amenities = amenities;
	}

	public RatingAndListOfEs<String> getServicesavailable() {
		return servicesavailable;
	}

	public void setServicesavailable(RatingAndListOfEs<String> servicesavailable) {
		this.servicesavailable = servicesavailable;
	}

	public String[] getCableoperators() {
		return cableoperators;
	}

	public void setCableoperators(String[] cableoperators) {
		this.cableoperators = cableoperators;
	}

	public String[] getBroadbandoperators() {
		return broadbandoperators;
	}

	public void setBroadbandoperators(String[] broadbandoperators) {
		this.broadbandoperators = broadbandoperators;
	}

	public List<String> getLocality() {
		return locality;
	}

	public void setLocality(List<String> locality) {
		this.locality = locality;
	}

	public RatingAndListOfEs<String> getSafety() {
		return safety;
	}

	public void setSafety(RatingAndListOfEs<String> safety) {
		this.safety = safety;
	}

	public String getOthersafetyissuesifany() {
		return othersafetyissuesifany;
	}

	public void setOthersafetyissuesifany(String othersafetyissuesifany) {
		this.othersafetyissuesifany = othersafetyissuesifany;
	}

	public String getGatekeepercontact() {
		return gatekeepercontact;
	}

	public void setGatekeepercontact(String gatekeepercontact) {
		this.gatekeepercontact = gatekeepercontact;
	}

	public String getSocietymanagercontact() {
		return societymanagercontact;
	}

	public void setSocietymanagercontact(String societymanagercontact) {
		this.societymanagercontact = societymanagercontact;
	}

	public String getBestthingaboutsociety() {
		return bestthingaboutsociety;
	}

	public void setBestthingaboutsociety(String bestthingaboutsociety) {
		this.bestthingaboutsociety = bestthingaboutsociety;
	}

	public String getAreaofimprovement() {
		return areaofimprovement;
	}

	public void setAreaofimprovement(String areaofimprovement) {
		this.areaofimprovement = areaofimprovement;
	}

	public Location getSelectedlocation() {
		return selectedlocation;
	}

	public void setSelectedlocation(Location selectedlocation) {
		this.selectedlocation = selectedlocation;
	}

}
