import forms.AppointmentList;
import forms.HomePage;
import helperclasses.Location;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HomePageAPIJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//HomePageAPIJson.json"); 
	    
	  //GET
	  		HomePage homepageget = new HomePage("Priyanka", "ba435a",  "priyatoken123");
	  		String homepagegetjson = gson.toJson(homepageget);
	  		System.out.println(homepagegetjson);
	  		writer.append("//GET\n");
	  		writer.append(homepagegetjson+"\n\n"); 
	  		
		
		//POST
		HomePage homepagepost = new HomePage(9, 78, 300, 25);
		String homepagepostjson = gson.toJson(homepagepost);
		System.out.println(homepagepostjson);
		writer.append("//POST\n");
		writer.append(homepagepostjson+"\n\n"); 
		
		
		 writer.close();
	}

}
