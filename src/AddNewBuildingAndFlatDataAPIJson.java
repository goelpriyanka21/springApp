import forms.BuildingAndFlatData;
import forms.BuildingData;
import forms.FlatData;
import helperclasses.FamilyBachPer;
import helperclasses.Section24hrsAvailablePreferredPlace;
import helperclasses.SectionListOfFileNamePair;
import helperclasses.TwoIntegerpair;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.FlatTypeAvailabilityFlatsCombo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class AddNewBuildingAndFlatDataAPIJson {
	static FileWriter writer;

	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//AddNewBuildingAndFlatDataAPIJson.json"); 
		
		//GET
	    	Location gpslocation= new Location(47.608941, -122.340145);
	    	SectionListOfFileNamePair sfp1= new SectionListOfFileNamePair("Building",  Arrays.asList("srisaimanasabuilding"));
	    	SectionListOfFileNamePair sfp2= new SectionListOfFileNamePair("Rooms",  Arrays.asList("srisaimanasaroom1", "srisaimanasaroom2"));
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
			   Section24hrsAvailablePreferredPlace section24hrsAvailablePreferredPlace1= new Section24hrsAvailablePreferredPlace("Convenience Store", true, "Bigbazaar");
			   Section24hrsAvailablePreferredPlace section24hrsAvailablePreferredPlace2= new Section24hrsAvailablePreferredPlace("Restraunts/Pub", false, "Punjab Grill");
			   Section24hrsAvailablePreferredPlace section24hrsAvailablePreferredPlace3= new Section24hrsAvailablePreferredPlace("Schools", "Ebenezer");
				  
			   List<Section24hrsAvailablePreferredPlace> locality= Arrays.asList(section24hrsAvailablePreferredPlace1, section24hrsAvailablePreferredPlace2, section24hrsAvailablePreferredPlace3);
			  RatingAndListOfEs<String> safety= new RatingAndListOfEs<>(3, Arrays.asList("StreetDogs", "Mosquito"));;
			  String othersafetyissuesifany="None";
			  String gatekeepercontact="9876543210";
			  String societymanagercontact="9876543212";;
			  String[] bestthingaboutsociety={"Good amenities", "Safety", "ClubHouse"};
			  String[] areaofimprovement={"Ambience", "Locality"};
			  
			Location selectedlocation= new Location(47.608942, -122.340145);
			BuildingData buildingData= new BuildingData("Raheja Apartments", Arrays.asList(sfp1, sfp2), "#506", "Kormangala 5th block", "Bangalore", 274304, "Forum Mall",  rent,
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
			
					SectionListOfFileNamePair sfp5 = new SectionListOfFileNamePair("BedRoom",
							Arrays.asList("RahejaFlatBedroom"));
				SectionListOfFileNamePair sfp4 = new SectionListOfFileNamePair("Hall",
							Arrays.asList("RahejaFlatHall1",
									"RahejaFlatBedroomHall2"));
					List<SectionListOfFileNamePair> picturelist = Arrays.asList(sfp5, sfp4);
					List<String> flatavailableFor = Arrays.asList("Family", "Male Tenant",
							"Female Tenant");
					RatingAndListOfEs<String> flatamenities = new RatingAndListOfEs<>(3,
							Arrays.asList("AC", "PoojaRoom", "Cupboards"));
					

					FlatData flatData1 = new FlatData(picturelist, "603", 6, 2, 2,
							"Semi-furnished", "2BHK", "East", 26500, 3000, 200000, false,
							flatavailableFor, flatamenities, "None");		
					FlatData flatData2 = new FlatData(picturelist, "604", 6, 2, 2,
							"Semi-furnished", "2BHK", "East", 26500, 3000, 200000, false,
							flatavailableFor, flatamenities, "None");
			BuildingAndFlatData buildingAndFlatData= new BuildingAndFlatData("Priyanka",  "ba435a", gpslocation, 
					"priyankatoken123", "SriSaiKormanagalaattimesatmp10:23",
					buildingData,
					Arrays.asList(flatData1, flatData2));
							 
			    
			
		String addnewbuildingdatajson = gson.toJson(buildingAndFlatData);
		System.out.println(addnewbuildingdatajson);
		writer.append("//GET\n");
		writer.append(addnewbuildingdatajson+"\n\n"); 
		
		//POST: failure
		BuildingAndFlatData addnewbuildingdatapost = new BuildingAndFlatData("Failure", "Token Authentication failed");
		String addnewbuildingdatapostjson = gson.toJson(addnewbuildingdatapost);
		System.out.println(addnewbuildingdatapostjson);	  
		writer.append("//POST: failure\n");
		writer.append(addnewbuildingdatapostjson+"\n\n");
		
		//Another POST: success
		BuildingAndFlatData addNewBuildingDatapost2 = new BuildingAndFlatData("Success", "Data successfully stored on server");
				String addNewBuildingDatapost2json = gson.toJson(addNewBuildingDatapost2);
				System.out.println(addNewBuildingDatapost2json);	  
				writer.append("//Another POST Sample: success\n");
				writer.append(addNewBuildingDatapost2json+"\n\n");
		
		 writer.close();
	}
}
