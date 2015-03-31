import helperclasses.FamilyBachPer;
import helperclasses.TwoIntegerpair;
import helperclasses.AmenityTypePricePair;
import helperclasses.DepositAmount;
import helperclasses.EntryTime;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfFilePair;
import helperclasses.FlatTypeAvailabilityFlatsCombo;
import helperclasses.StudProfper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.AddNewBuildingData;
import models.AddNewPGData;
//import helperclasses.*;
import models.Login;

public class AddNewBuildingDataAPIJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//AddNewBuildingDataAPIJson.json"); 
		
		//GET
	    	Location gpslocation= new Location(47.608941, -122.340145);
	    	SectionListOfFilePair sfp1= new SectionListOfFilePair("Building",  Arrays.asList(new File("/Users/priyanka/srisaimanasabuilding")));
	    	SectionListOfFilePair sfp2= new SectionListOfFilePair("Rooms",  Arrays.asList(new File("/Users/priyanka/srisaimanasaroom1"), new File("/Users/priyanka/srisaimanasaroom2")));
	    	TwoIntegerpair rent= new TwoIntegerpair(20000, 30000);
	    	TwoIntegerpair maintainancecharge= new TwoIntegerpair(3000, 4000);
	    	TwoIntegerpair depositamount= new TwoIntegerpair(200000, 300000);
			  
			  String buildingage= " less than 3 years";
			  String buildername="Sobha";
			  Integer floornum=12;
			  Integer flatnum=180;
			   List<String> availableFor=Arrays.asList("Male", "Female");
			   FamilyBachPer familyBachPer= new FamilyBachPer(80, 20);
			   FlatTypeAvailabilityFlatsCombo strbc1= new FlatTypeAvailabilityFlatsCombo("1 BHK", true, 5);
			   FlatTypeAvailabilityFlatsCombo strbc2= new FlatTypeAvailabilityFlatsCombo("2 BHK", false, 10);
				RatingAndListOfEs<FlatTypeAvailabilityFlatsCombo> typesandavailability = new RatingAndListOfEs<FlatTypeAvailabilityFlatsCombo>(3, Arrays.asList(strbc1, strbc2)) ;
				
			   
			   RatingAndListOfEs<String> amenities= new RatingAndListOfEs<>(3, Arrays.asList("Elevator", "Swimming Pool"));
			   RatingAndListOfEs<String> servicesavailable= new RatingAndListOfEs<String>(3, Arrays.asList("Electrician", " Plumber"));
			   String[] cableoperators= {"Airtel", "TataSky"};
			   String[] broadbandoperators= {"Airtel", "HathWay"};
			   List<String> locality= Arrays.asList("Convenience Store", "24 hrs avaialble", "Bigbazaar");
			  RatingAndListOfEs safety= new RatingAndListOfEs<>(3, Arrays.asList("StreetDogs", "Mosquito"));;
			  String othersafetyissuesifany="None";
			  String gatekeepercontact="9876543210";
			  String societymanagercontact="9876543212";;
			  String bestthingaboutsociety="Good amenities";
			  String areaofimprovement="Ambience";
			  
			Location selectedlocation= new Location(47.608942, -122.340145);

			AddNewBuildingData addnewbuildingdata= new AddNewBuildingData("Priyanka",  "ba435a", gpslocation, "priyankatoken123", "Raheja Apartments", Arrays.asList(sfp1, sfp2), "#506", "Kormangala 5th block", "Bangalore", 274304, "Forum Mall",  rent,
			   
			    maintainancecharge,
				   depositamount,
				   buildingage,
				   buildername,
				   floornum,
				   flatnum,
				    availableFor,
				    familyBachPer,
				    typesandavailability,
				    amenities,
				    servicesavailable,
				    cableoperators,
				    broadbandoperators,
				   locality,
				   safety,
				   othersafetyissuesifany,
				   gatekeepercontact,
				   societymanagercontact,
				   bestthingaboutsociety,
				   areaofimprovement,
				    selectedlocation);
			
		String addnewbuildingdatajson = gson.toJson(addnewbuildingdata);
		System.out.println(addnewbuildingdatajson);
		writer.append("//GET\n");
		writer.append(addnewbuildingdatajson+"\n\n"); 
		
		//POST: failure
		AddNewBuildingData addnewbuildingdatapost = new AddNewBuildingData("Failure", "Token Authentication failed");
		String addnewbuildingdatapostjson = gson.toJson(addnewbuildingdatapost);
		System.out.println(addnewbuildingdatapostjson);	  
		writer.append("//POST: failure\n");
		writer.append(addnewbuildingdatapostjson+"\n\n");
		
		//Another POST: success
		AddNewBuildingData addNewBuildingDatapost2 = new AddNewBuildingData("Success", "Data successfully stored on server");
				String addNewBuildingDatapost2json = gson.toJson(addNewBuildingDatapost2);
				System.out.println(addNewBuildingDatapost2json);	  
				writer.append("//Another POST Sample: success\n");
				writer.append(addNewBuildingDatapost2json+"\n\n");
		
		 writer.close();
	}

}
