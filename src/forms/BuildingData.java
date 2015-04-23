package forms;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import helperclasses.FamilyBachPer;
import helperclasses.FlatTypeAvailabilityFlatsCombo;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.Section24hrsAvailablePreferredPlace;
import helperclasses.SectionListOfPhotoNameAndURLPair;
import helperclasses.TwoIntegerpair;

@SuppressWarnings("unused")
public class BuildingData {
	// GET

	private String societyname;
	private List<SectionListOfPhotoNameAndURLPair> picturelist;

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
	private List<Section24hrsAvailablePreferredPlace> locality;
	private RatingAndListOfEs<String> safety;
	private String othersafetyissuesifany;
	private String gatekeepercontact;
	private String societymanagercontact;
	private String[] bestthingaboutsociety;
	private String[] areaofimprovement;
	private Location selectedlocation;

	public BuildingData(

			String societyname,
			List<SectionListOfPhotoNameAndURLPair> picturelist,
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
			List<Section24hrsAvailablePreferredPlace> locality,
			RatingAndListOfEs<String> safety, String othersafetyissuesifany,
			String gatekeepercontact, String societymanagercontact,
			String[] bestthingaboutsociety, String[] areaofimprovement,
			Location selectedlocation) {

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

	public List<SectionListOfPhotoNameAndURLPair> getPicturelist() {
		return picturelist;
	}

	private int totalPictures() {
		int photocount = 0;
		for (SectionListOfPhotoNameAndURLPair pair : picturelist) {
			photocount += pair.getPhotonamelist().size();
		}
		return photocount;

	}

	public Location getSelectedLocation() {
		// TODO Auto-generated method stub
		return this.selectedlocation;
	}

	private JsonObject defineError(String name, String val) {
		JsonObject o = new JsonObject();
		o.addProperty(name, val);
		return o;
	}

	public List<JsonObject> validate() {
		// TODO Auto-generated method stub
		List<JsonObject> errors = new ArrayList<>();

		if ((societyname == null) || (societyname.length() > 50)) {
			errors.add(defineError("societyname",
					BuildingDataErrMsgs.SOCIETY_NAME_ERR));
		}

		if ((picturelist == null) || (picturelist.size() == 0)
				|| (totalPictures() < 5)) {
			errors.add(defineError("picturelist",
					BuildingDataErrMsgs.PICTURE_LIST_ERR));
		}

		if ((buildingname == null) || (buildingname.length() > 50)) {
			errors.add(defineError("buildingname",
					BuildingDataErrMsgs.BUILDING_NAME_ERR));
		}

		if ((addressl1 == null) || (addressl1.length() > 200)) {
			errors.add(defineError("addressl1",
					BuildingDataErrMsgs.ADDRESSL1_ERR));
		}

		if ((addressl2 != null) && (addressl2.length() > 200)) {
			errors.add(defineError("addressl2",
					BuildingDataErrMsgs.ADDRESSL2_ERR));
		}

		if ((pincode == null) || (pincode < 100000) || (pincode > 999999)) {
			errors.add(defineError("pincode", BuildingDataErrMsgs.PINCODE_ERR));
		}

		if ((landmark == null) || (landmark.length() > 200)) {
			errors.add(defineError("landmark", BuildingDataErrMsgs.LANDMARK_ERR));
		}

		if (rent == null || rent.getminlimit() == null
				|| rent.getmaxlimit() == null
				|| rent.getminlimit() > rent.getmaxlimit()) {
			errors.add(defineError("rent", BuildingDataErrMsgs.RENT_ERR));
		}

		if (maintainancecharge == null
				|| maintainancecharge.getminlimit() == null
				|| maintainancecharge.getmaxlimit() == null
				|| maintainancecharge.getminlimit() > maintainancecharge
						.getmaxlimit()) {
			errors.add(defineError("maintainancecharge",
					BuildingDataErrMsgs.MAINTAINANCE_CHARGE_ERR));
		}

		if (depositamount == null || depositamount.getminlimit() == null
				|| depositamount.getmaxlimit() == null
				|| depositamount.getminlimit() > depositamount.getmaxlimit()) {
			errors.add(defineError("depositamount",
					BuildingDataErrMsgs.DEPOSIT_AMOUNT_ERR));
		}

		if ((availableFor == null) || (availableFor.size() == 0)) {
			errors.add(defineError("availableFor",
					BuildingDataErrMsgs.AVAILABLE_FOR_ERR));
		}

		if ((typesandavailability != null)
				&& (typesandavailability.getAlldetails() != null)
				&& ((typesandavailability.getAlldetails().size() > 7))) {
			// TODO: check this error message
			errors.add(defineError("typesandavailability",
					BuildingDataErrMsgs.TYPESANDAVAILABILITY_ERR));
		}

		return errors.size() > 0 ? errors : null;
	}

}

class BuildingDataErrMsgs {
	static final String SOCIETY_NAME_ERR = "societyname cannot be blank/ less than 2 or more characters";
	static final String PICTURE_LIST_ERR = "Picture list cannot be blank/ size zero/ should contain at least 5 photo names";
	static final String BUILDING_NAME_ERR = "buildingname name cant be left blank/ more than 50 characters";
	static final String ADDRESSL1_ERR = "First Line Address can't be left blank/ more than 200 characters";
	static final String ADDRESSL2_ERR = "Second Line Address cant be more than 200 characters";
	static final String PINCODE_ERR = "Pincode can't be left blank/ should be 6 digits";
	static final String LANDMARK_ERR = "landmark cant be left blank/more than 200 characters";
	static final String RENT_ERR = "rent can't be left blank/ minlimit & maxlimit can't be left blank/ minlimit can't be greater than maxlimit";
	static final String MAINTAINANCE_CHARGE_ERR = "maintainancecharge can't be left blank/ minlimit & maxlimit can't be left blank/ minlimit can't be greater than maxlimit";
	static final String DEPOSIT_AMOUNT_ERR = "depositamount can't be left blank/ minlimit & maxlimit can't be left blank/ minlimit can't be greater than maxlimit";
	static final String AVAILABLE_FOR_ERR = "availableFor can't be left blank/ size can't be zero";
	static final String TYPESANDAVAILABILITY_ERR = "typesandavailability should not contain more than 7 items";
	static final String SELECTEDLOCATION_ERR = "selected location can't be left blank/ is not correct";
}
