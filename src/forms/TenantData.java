package forms;

import helperclasses.Commute;
import helperclasses.FoodOptions;
import helperclasses.RatingAndListOfEs;
import helperclasses.RatingAndListOfEsAndString;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

public class TenantData {
	// GET: specific to a pg tenant
	public String tenantname;
	public String contact;
	public String emailId;
	public Integer age;
	public String profession;
	public String[] threeBestThingsAboutPG = new String[3];
	public String[] threethingsyoudontlikeaboutPG = new String[3];
	RatingAndListOfEsAndString<String> safety;
	RatingAndListOfEs<String> cleanliness;
	List<String> otherRoommates;
	Commute<String> commute;
	FoodOptions<String> foodOptions;
	Integer ownerAndServiceFeedBack;
	Integer ownerInteractionReview;
	String ownerflexibility;
	List<String> rentPaymentMode;
	Integer serviceReview;
	Boolean referralpossibilty;
	String servicesInterested;
	String additionalComments;

	public String getTenantname() {
		return tenantname;
	}

	public void setTenantname(String tenantname) {
		this.tenantname = tenantname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String[] getThreeBestThingsAboutPG() {
		return threeBestThingsAboutPG;
	}

	public void setThreeBestThingsAboutPG(String[] threeBestThingsAboutPG) {
		this.threeBestThingsAboutPG = threeBestThingsAboutPG;
	}

	public String[] getThreethingsyoudontlikeaboutPG() {
		return threethingsyoudontlikeaboutPG;
	}

	public void setThreethingsyoudontlikeaboutPG(
			String[] threethingsyoudontlikeaboutPG) {
		this.threethingsyoudontlikeaboutPG = threethingsyoudontlikeaboutPG;
	}

	public RatingAndListOfEsAndString<String> getSafety() {
		return safety;
	}

	public void setSafety(RatingAndListOfEsAndString<String> safety) {
		this.safety = safety;
	}

	public RatingAndListOfEs<String> getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(RatingAndListOfEs<String> cleanliness) {
		this.cleanliness = cleanliness;
	}

	public List<String> getOtherRoommates() {
		return otherRoommates;
	}

	public void setOtherRoommates(List<String> otherRoommates) {
		this.otherRoommates = otherRoommates;
	}

	public Commute<String> getCommute() {
		return commute;
	}

	public void setCommute(Commute<String> commute) {
		this.commute = commute;
	}

	public FoodOptions<String> getFoodOptions() {
		return foodOptions;
	}

	public void setFoodOptions(FoodOptions<String> foodOptions) {
		this.foodOptions = foodOptions;
	}

	public Integer getOwnerAndServiceFeedBack() {
		return ownerAndServiceFeedBack;
	}

	public void setOwnerAndServiceFeedBack(Integer ownerAndServiceFeedBack) {
		this.ownerAndServiceFeedBack = ownerAndServiceFeedBack;
	}

	public Integer getOwnerInteractionReview() {
		return ownerInteractionReview;
	}

	public void setOwnerInteractionReview(Integer ownerInteractionReview) {
		this.ownerInteractionReview = ownerInteractionReview;
	}

	public String getOwnerflexibility() {
		return ownerflexibility;
	}

	public void setOwnerflexibility(String ownerflexibility) {
		this.ownerflexibility = ownerflexibility;
	}

	public List<String> getRentPaymentMode() {
		return rentPaymentMode;
	}

	public void setRentPaymentMode(List<String> rentPaymentMode) {
		this.rentPaymentMode = rentPaymentMode;
	}

	public Integer getServiceReview() {
		return serviceReview;
	}

	public void setServiceReview(Integer serviceReview) {
		this.serviceReview = serviceReview;
	}

	public Boolean getReferralpossibilty() {
		return referralpossibilty;
	}

	public void setReferralpossibilty(Boolean referralpossibilty) {
		this.referralpossibilty = referralpossibilty;
	}

	public String getServicesInterested() {
		return servicesInterested;
	}

	public void setServicesInterested(String servicesInterested) {
		this.servicesInterested = servicesInterested;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	public TenantData(String tenantname, String contact, String emailId,
			int age, String profession, String[] threeBestThingsAboutPG,
			String[] threethingsyoudontlikeaboutPG,
			RatingAndListOfEsAndString<String> safety,
			RatingAndListOfEs<String> cleanliness, List<String> otherRoommates,
			Commute<String> commute, FoodOptions<String> foodOptions,
			Integer ownerAndServiceFeedBack, Integer ownerInteractionReview,
			String ownerflexibility, List<String> rentPaymentMode,
			Integer serviceReview, Boolean referralpossibilty,
			String servicesInterested, String additionalComments) {

		this.tenantname = tenantname;
		this.contact = contact;
		this.emailId = emailId;
		this.age = age;
		this.profession = profession;
		this.threeBestThingsAboutPG = threeBestThingsAboutPG;
		this.threethingsyoudontlikeaboutPG = threethingsyoudontlikeaboutPG;
		this.safety = safety;
		this.cleanliness = cleanliness;
		this.otherRoommates = otherRoommates;
		this.commute = commute;
		this.foodOptions = foodOptions;
		this.ownerAndServiceFeedBack = ownerAndServiceFeedBack;
		this.ownerInteractionReview = ownerInteractionReview;
		this.ownerflexibility = ownerflexibility;
		this.rentPaymentMode = rentPaymentMode;
		this.serviceReview = serviceReview;
		this.referralpossibilty = referralpossibilty;
		this.servicesInterested = servicesInterested;
		this.additionalComments = additionalComments;

	}

	private JsonObject defineError(String name, String val) {
		JsonObject o = new JsonObject();
		o.addProperty(name, val);
		return o;
	}

	public List<JsonObject> validate() {
		List<JsonObject> errors = new ArrayList<>();

		if (tenantname == null) {
			errors.add(defineError("tenantname",
					TenantDataErrMsgs.TENANTNAME_ERR));
		} else { // trimmed string should not be empty
			tenantname = tenantname.trim();
			if (tenantname.equals("")) {
				errors.add(defineError("tenantname",
						TenantDataErrMsgs.TENANTNAME_ERR));
			}
		}

		if (contact == null) {
			errors.add(defineError("contact", TenantDataErrMsgs.CONTACT_ERR));
		} else {
			contact = contact.trim();
			if (contact.length() != 10) { // empty string is taken care in this
											// check
				errors.add(defineError("contact", TenantDataErrMsgs.CONTACT_ERR));
			}
		}

		if (emailId == null) {
			errors.add(defineError("emailId", TenantDataErrMsgs.EMAILID_ERR));
		} else {
			StringBuilder emailstbuilder = new StringBuilder(emailId);
			if (emailstbuilder.indexOf("@") == -1 // empty string is taken care
													// in this check
					|| emailstbuilder.indexOf(".") == -1
					|| emailstbuilder.lastIndexOf("@") > emailstbuilder
							.lastIndexOf(".")) {
				errors.add(defineError("emailId", TenantDataErrMsgs.EMAILID_ERR));
			}
		}

		if ((age == null) || (age < 10) || (age > 99)) {
			errors.add(defineError("age", TenantDataErrMsgs.AGE_ERR));
		}

		return errors.size() > 0 ? errors : null;
	}

}

class TenantDataErrMsgs {

	public static final String THREETHINGSYOUDONTLIKEABOUTPG_ERR = "threethingsyoudontlikeaboutPG strings cant be empty strings";
	public static final String THREEBESTTHINGSABOUTPG_ERR = "threeBestThingsAboutPG strings cant be empty strings";
	public static final String PROFESSION_ERR = "profession cant be empty string";
	static final String TENANTNAME_ERR = "tenant name cant be null/empty string";
	static final String CONTACT_ERR = "tenant contact is null/ invalid";
	static final String EMAILID_ERR = "tenant emailId is invalid";
	static final String AGE_ERR = "tenant age cant be null and should be a two digit number";
}
