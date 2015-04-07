import forms.AddEntryData;
import forms.ExistingPropertyData;
import forms.PostForm;
import helperclasses.Location;
import helperclasses.PropertyNameTypeisLocked;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EntryPageAPIJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//EntryPageAPIJson.json"); 
		
		//GET
	    AddEntryData entryget = new AddEntryData("Priyanka", "ba435a", new Location(47.608941, -122.340145), "priya123");
		String entrygetjson = gson.toJson(entryget);
		System.out.println(entrygetjson);
		writer.append("//GET\n");
		writer.append(entrygetjson+"\n\n"); 
		
		
		// POST: Username does not exist
		
		//POST: failure: backend
		PostForm entrypost = new PostForm("Failure", "Token Authentication failed");
				String entrypostjson = gson.toJson(entrypost);
				System.out.println(entrypostjson);	  
				writer.append("//POST: failure\n");
				writer.append(entrypostjson+"\n\n");
		
		//POST: success: List of Property Name and Type on the basis of gps location received: backend
				PropertyNameTypeisLocked pntp1= new PropertyNameTypeisLocked("Raheja Apartment", "Building", "RahejaApartmentUniqueId123", true);
				PropertyNameTypeisLocked pntp2= new PropertyNameTypeisLocked("Rahul PG for Gents", "PG", "Rahul PG for GentsUniqueId123", true);
				List<PropertyNameTypeisLocked> listofproperties= new ArrayList<>();
				listofproperties.add(pntp1);
				listofproperties.add(pntp2);
//				ExistingPropertyData entrypost2 = new ExistingPropertyData(Arrays.asList(pntp1, pntp2));
				ExistingPropertyData entrypost2 = new ExistingPropertyData(listofproperties);
				
				 entrypostjson = gson.toJson(entrypost2);
				System.out.println(entrypostjson);	  
				writer.append("//POST: List of Property Details on the basis of gps location received\n");
				writer.append(entrypostjson+"\n\n");
				
				//GET
				 entryget = new AddEntryData("RahejaApartmentUniqueId123");
				 entrygetjson = gson.toJson(entryget);
				System.out.println(entrygetjson);
				writer.append("//GET\n");
				writer.append(entrygetjson+"\n\n"); 
				
				// entry does not exist; please call add entry API
				
				//POST: entry already exists and is locked only on front end ; v l check all this in addpg/building api;
				 entrypost = new PostForm("Entry already exists and is locked", "Would you like to add Flat/PG tenant Details");
				 entrypostjson = gson.toJson(entrypost);
				System.out.println(entrypostjson);	  
				writer.append("//POST: locked entry (entry already exists)\n");
				writer.append(entrypostjson+"\n\n");
				
				//POST: Entry already exists but is unlocked: will display ExistingPropertyData directly: no API calling
				writer.append("//POST: unlocked entry will display ExistingPropertyData API\n");
				
		
	
		
		 writer.close();
	}

}
