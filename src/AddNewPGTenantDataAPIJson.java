//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import models.AddNewPGData;
//import models.AddNewPGTenantData;
//import helperclasses.*;
//import models.Login;
//
//public class AddNewPGTenantDataAPIJson {
//	
//	static FileWriter writer;
//	public static void main(String[] args) throws IOException {
//		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		//write converted json data to a file named "CountryGSON.json"  
//	    writer= new FileWriter("/Users/priyanka/git/grabhouse//AddNewPGTenantDataAPIJson.json"); 
//		
//		//GET
//	    	Location gpslocation= new Location(47.608941, -122.340145);
//			String[] threebestthings= {"neighbouhood", "owner behaviour", "facilities"};
//			String[] threethingsyoudontlikeaboutPG= {"street dogs", "food", ""};
//			RatingAndListOfEsAndString safety = new RatingAndListOfEsAndString(4, Arrays.asList("Common area CCTV"), "None");
//			RatingAndListOfEs cleanliness = new RatingAndListOfEs(4, Arrays.asList("Bathroom", "CommonArea"));
//			List<String> otherRoommates= Arrays.asList("quiet", "orgainised");
//			Commute commute = new Commute(4, Arrays.asList("auto stand nearby", "bus stop nearby"), "Truffels");
//		//	String bestPlacesToHangout = ;
//			FoodOptions foodOptions = new FoodOptions(4, Arrays.asList("North Indian"), 5);
//			//Integer foodqualityrating=5;
//			Integer ownerAndServiceFeedBack=4;
//			Integer ownerInteractionReview=8;
//			String ownerflexibility= "Flexible in everything";
//			List<String> rentPaymentMode= Arrays.asList("Cash", "Cheque", "NEFT");;
//			Integer serviceReview=8;
//			Boolean referralpossibilty= true;
//			String servicesInterested= "Many";
//			String additionalComments= "Overall a Good PG";
//			Location selectedlocation= new Location(47.608942, -122.340145);
//			
//			
//			AddNewPGTenantData addnewpgtenantdata= new AddNewPGTenantData("Priyanka",  "ba435a", gpslocation, "priyankatoken123", "Sri Sai Manasa PG, #506, Kormangala 5th block, Bangalore, 274304, Forum Mall", "Sri Sai Manasa PG Kormangala UniquePropertyId", "Ram", "+91-9877812345", "ram@gmail.com", 25, "Software Professional",  threebestthings, threethingsyoudontlikeaboutPG, safety, cleanliness, otherRoommates, commute, foodOptions, ownerAndServiceFeedBack, ownerInteractionReview,  ownerflexibility, rentPaymentMode, serviceReview, referralpossibilty, servicesInterested, additionalComments, selectedlocation);  
//			
//		String addnewpgdatagetjson = gson.toJson(addnewpgtenantdata);
//		System.out.println(addnewpgdatagetjson);
//		writer.append("//GET\n");
//		writer.append(addnewpgdatagetjson+"\n\n"); 
//		
//		//POST: failure
//		AddNewPGData addnewpgdatapost = new AddNewPGData("Failure", "Token Authentication failed");
//		String addnewpgdatapostjson = gson.toJson(addnewpgdatapost);
//		System.out.println(addnewpgdatapostjson);	  
//		writer.append("//POST: failure\n");
//		writer.append(addnewpgdatapostjson+"\n\n");
//		
//		//Another POST: success
//				AddNewPGData addnewpgdatapost2 = new AddNewPGData("Success", "Data successfully stored on server");
//				String addnewpgdatapostjson2 = gson.toJson(addnewpgdatapost2);
//				System.out.println(addnewpgdatapostjson2);	  
//				writer.append("//Another POST Sample: success\n");
//				writer.append(addnewpgdatapostjson2+"\n\n");
//		
//		 writer.close();
//	}
//
//}
