import helperclasses.TwoIntegerpair;
import helperclasses.AmenityTypePricePair;
import helperclasses.DepositAmount;
import helperclasses.EntryTime;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
import helperclasses.SectionListOfFilePair;
import helperclasses.SharingTypeRentbedsCombo;
import helperclasses.StudProfper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.AddNewPGData;
//import helperclasses.*;
import models.Login;

public class AddNewPGDataAPIJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//AddNewPGDataAPIJson.json"); 
		
		//GET
	    	Location gpslocation= new Location(47.608941, -122.340145);
	    	SectionListOfFilePair sfp1= new SectionListOfFilePair("Building",  Arrays.asList(new File("/Users/priyanka/srisaimanasabuilding")));
	    	SectionListOfFilePair sfp2= new SectionListOfFilePair("Rooms",  Arrays.asList(new File("/Users/priyanka/srisaimanasaroom1"), new File("/Users/priyanka/srisaimanasaroom2")));
//			SectionFilePair sfp3= new SectionFilePair("Rooms",  );
			DepositAmount da= new DepositAmount(1000, false);
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
			AddNewPGData addnewpgdata= new AddNewPGData("Priyanka",  "ba435a", gpslocation, "priyankatoken123", "Sri Sai Manasa PG", Arrays.asList(sfp1, sfp2), "#506", "Kormangala 5th block", "Bangalore", 274304, "Forum Mall", da, Arrays.asList("Male", "Female"), spp, "IT", ab, true, true, typesandavailability, sa, fd, ca, restrictions, new EntryTime(7, 30, "pm"), selectedlocation);
			
		String addnewpgdatagetjson = gson.toJson(addnewpgdata);
		System.out.println(addnewpgdatagetjson);
		writer.append("//GET\n");
		writer.append(addnewpgdatagetjson+"\n\n"); 
		
		//POST: failure
		AddNewPGData addnewpgdatapost = new AddNewPGData("Failure", "Token Authentication failed");
		String addnewpgdatapostjson = gson.toJson(addnewpgdatapost);
		System.out.println(addnewpgdatapostjson);	  
		writer.append("//POST: failure\n");
		writer.append(addnewpgdatapostjson+"\n\n");
		
		//Another POST: success
				AddNewPGData addnewpgdatapost2 = new AddNewPGData("Success", "Data successfully stored ons server");
				String addnewpgdatapostjson2 = gson.toJson(addnewpgdatapost2);
				System.out.println(addnewpgdatapostjson2);	  
				writer.append("//Another POST Sample: success\n");
				writer.append(addnewpgdatapostjson2+"\n\n");
		
		 writer.close();
	}

}
