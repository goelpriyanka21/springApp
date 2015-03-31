package models;

import java.util.List;

import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
//import helperclasses.RatingAndListOfStrings;

public class AddNewPGTenantData {
	//GET
		public String username;
		public String deviceId;
		public Location gpslocation;
		public String token;
		public String pgName;
		public String tenantname;
		public String contact;
		public String emailId;
		public int age;
		public String profession;
		public String[] threeBestThingsAboutPG=  new String[3];
		public String[] threethingsyoudontlikeaboutPG=  new String[3];
		RatingAndListOfEs safety;
		String othersafetyissuesifany;
		RatingAndListOfEs cleanliness;
		List<String> otherRoommates;
		RatingAndListOfEs commute;
		String bestPlacesToHangout;
		RatingAndListOfEs foodOptions;
		Integer foodqualityrating;
		Integer ownerAndServiceFeedBack;
		Integer ownerInteractionReview;
		String ownerflexibility;
		List<String> rentPaymentMode;
		Integer serviceReview;
		Boolean referralpossibilty;
		String servicesInterested;
		String additionalComments;
		public Location selectedlocation;
		String status;
		String message;
		
		public AddNewPGTenantData( String username, 
				String deviceId,
				Location gpslocation,
				String token,
				String pgName,
				String tenantname, 
				String contact,
				String emailId,
				int age, 
				String profession,
		String[] threeBestThingsAboutPG,
		String[] threethingsyoudontlikeaboutPG,
		RatingAndListOfEs safety, 
		String othersafetyissuesifany,
		RatingAndListOfEs cleanliness,
		List<String> otherRoommates, 
		RatingAndListOfEs commute,
		String bestPlacesToHangout, 
		RatingAndListOfEs foodOptions,
		Integer foodqualityrating,
		Integer ownerAndServiceFeedBack,
		Integer ownerInteractionReview,
		String ownerflexibility,
		List<String> rentPaymentMode,
		Integer serviceReview,
		Boolean referralpossibilty,
		String servicesInterested,
		String additionalComments,
		 Location selectedlocation){
			
			this.username= username;
			this.deviceId= deviceId;
			this.gpslocation= gpslocation;
			this.token= token;
			this.pgName= pgName;
			this.tenantname= tenantname;
			this.contact= contact;
			this.emailId= emailId;
			this.age= age;
			this.profession= profession;
			this.threeBestThingsAboutPG= threeBestThingsAboutPG;
			this.threethingsyoudontlikeaboutPG= threethingsyoudontlikeaboutPG;
			this.safety= safety;
			this.othersafetyissuesifany= othersafetyissuesifany;
			this.cleanliness= cleanliness;
			this.otherRoommates= otherRoommates;
			this.bestPlacesToHangout= bestPlacesToHangout;
			this.foodOptions= foodOptions;
			this.foodqualityrating= foodqualityrating;
			this.ownerAndServiceFeedBack= ownerAndServiceFeedBack;
			this.ownerInteractionReview= ownerInteractionReview;
			this.ownerflexibility= ownerflexibility;
			this.rentPaymentMode= rentPaymentMode;
			this.serviceReview= serviceReview;
			this.referralpossibilty= referralpossibilty;
			this.servicesInterested= servicesInterested;
			this.additionalComments= additionalComments;
			this.selectedlocation= selectedlocation;
			
		}

		

}
