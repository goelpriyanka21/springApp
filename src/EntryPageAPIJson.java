import forms.AddEntryData;
import forms.ExistingPropertyData;
import forms.PostForm;
import helperclasses.Location;
import helperclasses.PropertyNameTypeisLocked;
import helperclasses.STATUS;

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
		// write converted json data to a file named "CountryGSON.json"
		writer = new FileWriter(
				"/Users/priyanka/git/grabhouse//EntryPageAPIJson.json");

		// GET
		AddEntryData entryget = new AddEntryData("User1", "ba435a",
				new Location(47.608941, -122.340145), "user1token");
		String entrygetjson = gson.toJson(entryget);
		System.out.println(entrygetjson);
		writer.append("//GET\n");
		writer.append(entrygetjson + "\n\n");

		// POST: Username does not exist

		// POST: Failure: backend
		PostForm entrypost = new PostForm(STATUS.Failure,
				"Token Authentication failed");
		String entrypostjson = gson.toJson(entrypost);
		System.out.println(entrypostjson);
		writer.append("//POST: Failure\n");
		writer.append(entrypostjson + "\n\n");

		// POST: Success: List of Property Name and Type on the basis of gps
		// location received: backend
		PropertyNameTypeisLocked pntp1 = new PropertyNameTypeisLocked(
				"Raheja Apartment", "Building", "RahejaApartmentUniqueId123",
				true);
		PropertyNameTypeisLocked pntp2 = new PropertyNameTypeisLocked(
				"Rahul PG for Gents", "PG", "Rahul PG for GentsUniqueId123",
				true);
		List<PropertyNameTypeisLocked> listofproperties = new ArrayList<>();
		listofproperties.add(pntp1);
		listofproperties.add(pntp2);
		// ExistingPropertyData entrypost2 = new
		// ExistingPropertyData(Arrays.asList(pntp1, pntp2));
		ExistingPropertyData entrypost2 = new ExistingPropertyData(STATUS.Success,
				"Existing property list is ", listofproperties);
		entrypostjson = gson.toJson(entrypost2);
		System.out.println(entrypostjson);
		writer.append("//POST: List of Property Details on the basis of gps location received\n");
		writer.append(entrypostjson + "\n\n");

		writer.close();
	}

}
