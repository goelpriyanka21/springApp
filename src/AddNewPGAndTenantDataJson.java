import forms.PGAndTenantData;
import forms.PGData;
import forms.TenantData;
import helperclasses.Commute;
import helperclasses.ContactPerson;
import helperclasses.FoodOptions;
import helperclasses.RatingAndListOfEsAndString;
import helperclasses.SectionListOfFileNamePair;
import helperclasses.TwoIntegerpair;
import helperclasses.AmenityTypePricePair;
import helperclasses.DepositAmount;
import helperclasses.EntryTime;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.SharingTypeRentbedsCombo;
import helperclasses.StudProfper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class AddNewPGAndTenantDataJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//AddNewPGAndTenantDataJson.json"); 
		
		//GET
	    	Location gpslocation= new Location(47.608941, -122.340145);
	    	
	    	SectionListOfFileNamePair sfp1= new SectionListOfFileNamePair("Building",  Arrays.asList("srisaimanasabuilding"));
	    	SectionListOfFileNamePair sfp2= new SectionListOfFileNamePair("Rooms",  Arrays.asList("srisaimanasaroom1", "srisaimanasaroom2"));
			DepositAmount da= new DepositAmount(1000, false);
			ContactPerson contactperson= new ContactPerson("Person1", "+91-986667918", "Person2", "+91-986867918", "Person3", "+91-9866227918");
			StudProfper spp= new StudProfper(30, 70);
			TwoIntegerpair ab= new TwoIntegerpair(20, 35);
			SharingTypeRentbedsCombo strbc1= new SharingTypeRentbedsCombo("2-sharing", 5000, 5);
			SharingTypeRentbedsCombo strbc2= new SharingTypeRentbedsCombo("3-sharing", 8000, 10);
			RatingAndListOfEs<SharingTypeRentbedsCombo> typesandavailability = new RatingAndListOfEs<SharingTypeRentbedsCombo>(3, Arrays.asList(strbc1, strbc2)) ;
			RatingAndListOfEs<String> sa= new RatingAndListOfEs<>(5, Arrays.asList("HouseKeeping", "Laundary"));
			RatingAndListOfEs<String> fd= new RatingAndListOfEs<>(5, Arrays.asList("BreakFast", "Lunch"));
			AmenityTypePricePair atpp1= new AmenityTypePricePair("Microwave", 100);
			AmenityTypePricePair atpp2= new AmenityTypePricePair("Refrigerator", 200);
			RatingAndListOfEs<AmenityTypePricePair> ca= new RatingAndListOfEs<>(5, Arrays.asList(atpp1, atpp2));
			RatingAndListOfEs<String> restrictions = new RatingAndListOfEs<String>(4, Arrays.asList("Guardian allowed", "Smoking allowed"));
			Location selectedlocation= new Location(47.608942, -122.340145);
			PGData pgdata= new PGData("Sri Sai Manasa PG", Arrays.asList(sfp1, sfp2), "#506", "Kormangala 5th block", "Bangalore", 274304, "Forum Mall", contactperson, da, Arrays.asList("Male", "Female"), spp, "IT", ab, true, true, typesandavailability, sa, fd, ca, restrictions, new EntryTime(7, 30, "pm"), 
					selectedlocation);
			
			String[] threebestthings= {"neighbouhood", "owner behaviour", "facilities"};
			String[] threethingsyoudontlikeaboutPG= {"street dogs", "food", ""};
			RatingAndListOfEsAndString<String> safety = new RatingAndListOfEsAndString<>(4, Arrays.asList("Common area CCTV"), "None");
			RatingAndListOfEs<String> cleanliness = new RatingAndListOfEs<>(4, Arrays.asList("Bathroom", "CommonArea"));
			List<String> otherRoommates= Arrays.asList("quiet", "orgainised");
			Commute<String> commute = new Commute<>(4, Arrays.asList("auto stand nearby", "bus stop nearby"), "Truffels");
			FoodOptions<String> foodOptions = new FoodOptions<>(4, Arrays.asList("North Indian"), 5);
			Integer ownerAndServiceFeedBack=4;
			Integer ownerInteractionReview=8;
			String ownerflexibility= "Flexible in everything";
			List<String> rentPaymentMode= Arrays.asList("Cash", "Cheque", "NEFT");;
			Integer serviceReview=8;
			Boolean referralpossibilty= true;
			String servicesInterested= "Many";
			String additionalComments= "Overall a Good PG";
			TenantData tenantData1= new TenantData("Ram", "+91-9877812345", "ram@gmail.com", 25, "Software Professional",  threebestthings, threethingsyoudontlikeaboutPG, safety, cleanliness, otherRoommates, commute, foodOptions, ownerAndServiceFeedBack, ownerInteractionReview,  ownerflexibility, rentPaymentMode, serviceReview, referralpossibilty, servicesInterested, additionalComments);  
			TenantData tenantData2= new TenantData("Ashu", "+91-987781422", "ashu@gmail.com", 30, "Student",  threebestthings, threethingsyoudontlikeaboutPG, safety, cleanliness, otherRoommates, commute, foodOptions, ownerAndServiceFeedBack, ownerInteractionReview,  ownerflexibility, rentPaymentMode, serviceReview, referralpossibilty, servicesInterested, additionalComments);  
			
			PGAndTenantData addnewpgdata= new PGAndTenantData("Priyanka",  "ba435a", gpslocation, "priyankatoken123", "SriSaiKormanagalaattimesatmp10:23", pgdata, Arrays.asList(tenantData1, tenantData2));
			
		String addnewpgdatagetjson = gson.toJson(addnewpgdata);
		System.out.println(addnewpgdatagetjson);
		writer.append("//GET\n");
		writer.append(addnewpgdatagetjson+"\n\n"); 
		
		//POST: failure
		PGAndTenantData addnewpgdatapost = new PGAndTenantData("Failure", "Token Authentication failed");
		String addnewpgdatapostjson = gson.toJson(addnewpgdatapost);
		System.out.println(addnewpgdatapostjson);	  
		writer.append("//POST: failure\n");
		writer.append(addnewpgdatapostjson+"\n\n");
		
		//Another POST: success
		PGAndTenantData addnewpgdatapost2 = new PGAndTenantData("Success", "Data successfully stored on server: Dont forget to upload photos");
				String addnewpgdatapostjson2 = gson.toJson(addnewpgdatapost2);
				System.out.println(addnewpgdatapostjson2);	  
				writer.append("//Another POST Sample: success\n");
				writer.append(addnewpgdatapostjson2+"\n\n");
		
		 writer.close();
	}

}
