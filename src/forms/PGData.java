package forms;

import helperclasses.AmenityTypePricePair;
import helperclasses.ContactPerson;
import helperclasses.DepositAmount;
import helperclasses.EntryTime;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfPhotoNameAndURLPair;
import helperclasses.SharingTypeRentbedsCombo;
import helperclasses.StudProfper;
import helperclasses.TwoIntegerpair;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

@SuppressWarnings("unused")
public class PGData {

	private String pgName;
	private List<SectionListOfPhotoNameAndURLPair> picturelist;
	private String buildingname;
	private String addressl1;
	private String addressl2;
	private Integer pincode;
	private String landmark;
	private ContactPerson contactperson;
	private DepositAmount depositamount;
	private List<String> availableFor;
	private StudProfper stdprofper;
	private String typeofprofessional;
	private TwoIntegerpair ageBand;
	private Boolean spacious;
	private Boolean clean;
	private RatingAndListOfEs<SharingTypeRentbedsCombo> typesandavailability;
	private RatingAndListOfEs<String> serviceavailable;
	private RatingAndListOfEs<String> fooddetails;
	private RatingAndListOfEs<AmenityTypePricePair> chargedamenities;
	private RatingAndListOfEs<String> restrictions;
	private EntryTime entrytime;
	private Location selectedlocation;

	public Location getSelectedLocation() {
		return selectedlocation;
	}

	/** Required for form instantiation. */
	public PGData(String pgName,
			List<SectionListOfPhotoNameAndURLPair> picturelist,
			String buildingname, String addressl1, String addressl2,
			int pincode, String landmark, ContactPerson contactperson,
			DepositAmount depositamount, List<String> availableFor,
			StudProfper stdprofper, String typeofprofessional,
			TwoIntegerpair ageBand, boolean spacious, boolean clean,
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
		this.contactperson = contactperson;
		this.depositamount = depositamount;
		this.availableFor = availableFor;
		this.stdprofper = stdprofper;
		this.ageBand = ageBand;
		this.typeofprofessional = typeofprofessional;
		this.spacious = spacious;
		this.clean = clean;
		this.typesandavailability = typesandavailability;
		this.serviceavailable = serviceavailable;
		this.fooddetails = fooddetails;
		this.chargedamenities = chargedamenities;
		this.restrictions = restrictions;
		this.entrytime = entrytime;
		this.selectedlocation = selectedlocation;

	}

	public String getPgName() {
		return this.pgName;
	}

	public List<SectionListOfPhotoNameAndURLPair> getPicturelist() {
		return this.picturelist;
	}

	private JsonObject defineError(String name, String val) {
		JsonObject o = new JsonObject();
		o.addProperty(name, val);
		return o;
	}

	private int totalPictures() {
		int photocount = 0;
		for (SectionListOfPhotoNameAndURLPair pair : picturelist) {
			photocount += pair.getPhotonamelist().size();
		}
		return photocount;

	}

	private int bedCount() {
		int bedcount = 0;
		for (SharingTypeRentbedsCombo sharingTypeRentbedsCombo : typesandavailability
				.getAlldetails()) {
			bedcount += sharingTypeRentbedsCombo.getBedsavailable();
		}
		return bedcount;
	}

	public List<JsonObject> validate() {
		List<JsonObject> errors = new ArrayList<>();

		if ((pgName == null) || (pgName.length() > 50)) {
			errors.add(defineError("pgName", PGDataErrMsgs.PGNAME_ERR));
		}

		if ((picturelist == null) || (picturelist.size() == 0)
				|| (totalPictures() < 5)) {
			errors.add(defineError("picturelist", PGDataErrMsgs.PICTURELIST_ERR));
		}

		if ((buildingname == null) || (buildingname.length() > 50)) {
			errors.add(defineError("buildingname",
					PGDataErrMsgs.BUILDINGNAME_ERR));
		}

		if ((addressl1 == null) || (addressl1.length() > 200)) {
			errors.add(defineError("addressl1", PGDataErrMsgs.ADDRESSL1_ERR));
		}

		if ((addressl2 != null) && (addressl2.length() > 200)) {
			errors.add(defineError("addressl2", PGDataErrMsgs.ADDRESSL2_ERR));
		}

		if ((pincode == null) || (pincode < 100000) || (pincode > 999999)) {
			errors.add(defineError("pincode", PGDataErrMsgs.PINCODE_ERR));
		}

		if ((landmark == null) || (landmark.length() > 200)) {
			errors.add(defineError("landmark", PGDataErrMsgs.LANDMARK_ERR));
		}

		if (contactperson == null || contactperson.getName1() == null
				|| contactperson.getPhoneno1() == null
				|| contactperson.getName2() == null
				|| contactperson.getPhoneno2() == null
				|| contactperson.getName3() == null
				|| contactperson.getPhoneno3() == null) {
			errors.add(defineError("contactperson", PGDataErrMsgs.CONTACTPERSON_ERR));
		}
		if ((availableFor == null) || (availableFor.size() == 0)) {
			errors.add(defineError("availableFor",
					PGDataErrMsgs.AVAILABLE_FOR_ERR));
		}

		if (stdprofper!=null && (stdprofper.getstudper() + stdprofper.getprofper() != 100)) {
			errors.add(defineError("stdprofper", PGDataErrMsgs.STDPROFPER_ERR));
		}

		if ((typeofprofessional != null) && (typeofprofessional.length() > 200)) {
			errors.add(defineError("typeofprofessional",
					PGDataErrMsgs.TYPEOFPROFESSIONAL_ERR));
		}

		if(ageBand!=null && ageBand.getminlimit()!=null && ageBand.getmaxlimit()!=null && ageBand.getminlimit()>ageBand.getmaxlimit())
		{
			errors.add(defineError("ageBand",
					PGDataErrMsgs.AGEBAND_ERR));
		}
		if ((typesandavailability != null)
				&& (typesandavailability.getAlldetails() != null)
				&& ((typesandavailability.getAlldetails().size() > 7) || (bedCount() > 100))) {
			// TODO: check this error message
			errors.add(defineError("typesandavailability",
					PGDataErrMsgs.TYPESANDAVAILABILITY_ERR));
		}

		return errors.size() > 0 ? errors : null;
	}
}

class PGDataErrMsgs {

	public static final String AGEBAND_ERR = "age band min limit cannot be greater than max limit";
	public static final String CONTACTPERSON_ERR = "Please provide 3 contact details";
	static final String PICTURELIST_ERR = "Picture list can't be blank/ size zero/ should contain at least 5 photo names";
	static final String PGNAME_ERR = "pg name can't be left blank/ more than 50 characters";
	static final String BUILDINGNAME_ERR = "buildingname name cant be null & more than 50 characters";
	static final String ADDRESSL1_ERR = "First Line Address can't be left blank/ more than 200 characters";
	static final String ADDRESSL2_ERR = "Second Line Address cant be more than 200 characters";
	static final String PINCODE_ERR = "Pincode can't be left blank/ should be 6 digits";
	static final String LANDMARK_ERR = "landmark cant be left blank/more than 200 characters";
	static final String AVAILABLE_FOR_ERR = "availableFor can't be left blank/ size can't be zero";
	static final String STDPROFPER_ERR = "student and professional percentage sum not making 100";
	static final String TYPEOFPROFESSIONAL_ERR = "typeofprofessional cant be more than 200 characters";
	static final String TYPESANDAVAILABILITY_ERR = "typesandavailability should not contain more than 7 items/ bed count should not be more than 100";
}
