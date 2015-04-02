package forms;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import helperclasses.Commute;
import helperclasses.FoodOptions;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
//import helperclasses.RatingAndListOfStrings;
import helperclasses.RatingAndListOfEsAndString;

public class TenantData {
	// GET: specific to a pg tenant

	public String tenantname;
	public String contact;
	public String emailId;
	public int age;
	public String profession;
	public String[] threeBestThingsAboutPG = new String[3];
	public String[] threethingsyoudontlikeaboutPG = new String[3];
	RatingAndListOfEsAndString safety;

	RatingAndListOfEs cleanliness;
	List<String> otherRoommates;
	Commute commute;
	FoodOptions foodOptions;
	Integer ownerAndServiceFeedBack;
	Integer ownerInteractionReview;
	String ownerflexibility;
	List<String> rentPaymentMode;
	Integer serviceReview;
	Boolean referralpossibilty;
	String servicesInterested;
	String additionalComments;

	public TenantData(
			String tenantname, String contact, String emailId, int age,
			String profession, String[] threeBestThingsAboutPG,
			String[] threethingsyoudontlikeaboutPG,
			RatingAndListOfEsAndString safety, RatingAndListOfEs cleanliness,
			List<String> otherRoommates, Commute commute,
			FoodOptions foodOptions, Integer ownerAndServiceFeedBack,
			Integer ownerInteractionReview, String ownerflexibility,
			List<String> rentPaymentMode, Integer serviceReview,
			Boolean referralpossibilty, String servicesInterested,
			String additionalComments) {

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

	
}
