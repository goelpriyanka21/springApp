import forms.ExistingPropertyData;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExistingPropertyDataAPIJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//ExistingPropertyDataAPIJson.json"); 
		
		//GET
	    ExistingPropertyData existingpropertydataget = new ExistingPropertyData("User1", "user1token", "RahejaApartmentUniqueId123");
		String existingpropertydatagetjson = gson.toJson(existingpropertydataget);
		System.out.println(existingpropertydatagetjson);
		writer.append("//GET\n");
		writer.append(existingpropertydatagetjson+"\n\n"); 
		
		//POST: will be all the details on server for this property name
		
		writer.append("//POST: will be all the deatils on server for this property name\n");
		
		
		
		
		 writer.close();
	}

}
