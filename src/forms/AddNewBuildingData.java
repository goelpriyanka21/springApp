package forms;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import helperclasses.FamilyBachPer;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfFileNamePair;

import helperclasses.StudProfper;
import helperclasses.TwoIntegerpair;


public class AddNewBuildingData {
	//GET
		public String username;
		public String deviceId;
		public Location gpslocation;
		public String token;
		
		  public String societyname;
		  public List<SectionListOfFileNamePair> picturelist;
		  public String buildingname;
		  public String addressl1;
		  public String addressl2;
		  public Integer pincode;
		  public String landmark;
		  
		  TwoIntegerpair rent;
		  TwoIntegerpair maintainancecharge;
		  TwoIntegerpair depositamount;
		  String buildingage;
		  String buildername;
		  Integer floornum;
		  Integer flatnum;
		  public List<String> availableFor;
		  public FamilyBachPer familyBachPer;
		  public RatingAndListOfEs typesandavailability;
		  public RatingAndListOfEs amenities;
		  public RatingAndListOfEs servicesavailable;
		  private String[] cableoperators;
		  private String[] broadbandoperators;
		  public List<String> locality;
		  RatingAndListOfEs safety;
		  String othersafetyissuesifany;
		  String gatekeepercontact;
		  String societymanagercontact;
		  String bestthingaboutsociety;
		  String areaofimprovement;
		  public Location selectedlocation;
		  String status;
		  String message;
		  
		  public AddNewBuildingData(
				//GET
				 String username,
				 String DeviceId,
				 Location gpslocation,
				 String token,
				
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
				   RatingAndListOfEs typesandavailability,
				   RatingAndListOfEs amenities,
				   RatingAndListOfEs servicesavailable,
				   String[] cableoperators,
				   String[] broadbandoperators,
				   List<String> locality,
				  RatingAndListOfEs safety,
				  String othersafetyissuesifany,
				  String gatekeepercontact,
				  String societymanagercontact,
				  String bestthingaboutsociety,
				  String areaofimprovement,
				   Location selectedlocation){
			  
			  this.username= username;
			  this.deviceId= deviceId;
			  this.gpslocation= gpslocation;
			  this.token= token;
			  this.societyname= societyname;
			  this.picturelist= picturelist;
			  this.buildingname= buildingname;
			  this.addressl1= addressl1;
			  this.addressl2= addressl2;
			  this.pincode= pincode;
			  this.landmark= landmark;
			  this.rent= rent;
			  this.maintainancecharge= maintainancecharge;
			  this.depositamount= depositamount;
			  this.buildingage= buildingage;
			  this.buildername= buildername;
			  this.floornum= floornum;
			  this.flatnum= flatnum;
			  this.availableFor= availableFor;
			  this.familyBachPer= familyBachPer;
			  this.typesandavailability= typesandavailability;
			  this.amenities= amenities;
			  this.servicesavailable= servicesavailable;
			  this.cableoperators= cableoperators;
			  this.broadbandoperators= broadbandoperators;
			  this.locality= locality;
			  this.safety= safety;
			  this.othersafetyissuesifany= othersafetyissuesifany;
			  this.gatekeepercontact= gatekeepercontact;
			  this.societymanagercontact= societymanagercontact;
			  this.bestthingaboutsociety= bestthingaboutsociety;
			  this.areaofimprovement= areaofimprovement;
			  this.selectedlocation= selectedlocation;
			 
			  
			  
			  
		  }

		public AddNewBuildingData(String string, String string2) {
			// TODO Auto-generated constructor stub
			this.status= string;
			this.message= string2;
		}
		  
		  
	

}
