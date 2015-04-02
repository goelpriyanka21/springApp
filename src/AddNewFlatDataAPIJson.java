//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import models.AddNewFlatData;
//import helperclasses.*;
//
//public class AddNewFlatDataAPIJson {
//	static FileWriter writer;
//
//	public static void main(String[] args) throws IOException {
//
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		// write converted json data to a file named "CountryGSON.json"
//		writer = new FileWriter(
//				"/Users/priyanka/git/grabhouse//AddNewFlatDataAPIJson.json");
//
//		Location gpslocation = new Location(47.608941, -122.340145);
//		SectionListOfFilePair sfp1 = new SectionListOfFilePair("BedRoom",
//				Arrays.asList(new File("/Users/priyanka/RahejaFlatBedroom")));
//		SectionListOfFilePair sfp2 = new SectionListOfFilePair("Hall",
//				Arrays.asList(new File("/Users/priyanka/RahejaFlatHall1"),
//						new File("/Users/priyanka/RahejaFlatBedroomHall2")));
//		List<SectionListOfFilePair> picturelist = Arrays.asList(sfp1, sfp2);
//		List<String> availableFor = Arrays.asList("Family", "Male Tenant",
//				"Female Tenant");
//		RatingAndListOfEs<String> amenities = new RatingAndListOfEs<>(3,
//				Arrays.asList("AC", "PoojaRoom", "Cupboards"));
//		Location selectedlocation = new Location(47.608942, -122.340145);
//
//		AddNewFlatData addNewFlatData = new AddNewFlatData(
//
//		"Priyanka", "ba435a", gpslocation, "priyankatoken123",
//				"Springfields Apartment", picturelist, "603", 6, 2, 2,
//				"Semi-furnished", "2BHK", "East", 26500, 3000, 200000, false,
//				availableFor, amenities, "None", selectedlocation);
//		
//		//List<AddNewFlatData> flats= Arrays.asList(addNewFlatData, addNewFlatData);
//
//		// GET
//		String addNewFlatDatajson = gson.toJson(addNewFlatData);
////		String addNewFlatDatajson = gson.toJson(flats);
//		System.out.println(addNewFlatDatajson);
//		writer.append("//GET\n");
//		writer.append(addNewFlatDatajson + "\n\n");
//
//		// POST: failure
//		AddNewFlatData addNewFlatDatapost = new AddNewFlatData("Failure",
//				"Token Authentication failed");
//		String addNewFlatDatapostjson = gson.toJson(addNewFlatDatapost);
//		System.out.println(addNewFlatDatapostjson);
//		writer.append("//POST: failure\n");
//		writer.append(addNewFlatDatapostjson + "\n\n");
//
//		// Another POST: success
//		addNewFlatDatapost = new AddNewFlatData("Success",
//				"Data successfully stored on server");
//		String addNewFlatDatapostjson2 = gson.toJson(addNewFlatDatapost);
//		System.out.println(addNewFlatDatapostjson2);
//		writer.append("//Another POST Sample: success\n");
//		writer.append(addNewFlatDatapostjson2 + "\n\n");
//
//		writer.close();
//	}
//
//}
