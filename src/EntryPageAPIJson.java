import forms.EntryPage;
import helperclasses.Location;
import helperclasses.PropertyNameTypeisLocked;
import helperclasses.PropertyNameTypeisLocked;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EntryPageAPIJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//EntryPageAPIJson.json"); 
		
		//GET
		EntryPage entryget = new EntryPage("Priyanka", "ba435a", new Location(47.608941, -122.340145), "priya123");
		String entrygetjson = gson.toJson(entryget);
		System.out.println(entrygetjson);
		writer.append("//GET\n");
		writer.append(entrygetjson+"\n\n"); 
		
		//POST: failure
		EntryPage entrypost = new EntryPage("Failure", "Token Authentication failed");
				String entrypostjson = gson.toJson(entrypost);
				System.out.println(entrypostjson);	  
				writer.append("//POST: failure\n");
				writer.append(entrypostjson+"\n\n");
		
		//POST: success: List of Property Name and Type on the basis of gps location received
				PropertyNameTypeisLocked pntp1= new PropertyNameTypeisLocked("Raheja Apartment", "Building", "RahejaApartmentUniqueId123", true);
				PropertyNameTypeisLocked pntp2= new PropertyNameTypeisLocked("Rahul PG for Gents", "PG", "Rahul PG for GentsUniqueId123", true);
		 entrypost = new EntryPage(Arrays.asList(pntp1, pntp2));
				 entrypostjson = gson.toJson(entrypost);
				System.out.println(entrypostjson);	  
				writer.append("//POST: List of Property Details on the basis of gps location received\n");
				writer.append(entrypostjson+"\n\n");
				
				//GET
				 entryget = new EntryPage("RahejaApartmentUniqueId123");
				 entrygetjson = gson.toJson(entryget);
				System.out.println(entrygetjson);
				writer.append("//GET\n");
				writer.append(entrygetjson+"\n\n"); 
				
				//POST: locked entry (entry already exists)
				 
				 entrypost = new EntryPage(true);
				 entrypostjson = gson.toJson(entrypost);
				System.out.println(entrypostjson);	  
				writer.append("//POST: locked entry (entry already exists)\n");
				writer.append(entrypostjson+"\n\n");
				
				//POST: unlocked entry will display ExistingPropertyData API
				writer.append("//POST: unlocked entry will display ExistingPropertyData API\n");
				
		
	
		
		 writer.close();
	}

}
