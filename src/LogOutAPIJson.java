import forms.LogOut;
import helperclasses.Location;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LogOutAPIJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//LogOutAPIJson.json"); 
		
		//GET
		LogOut logoutget = new LogOut("Priyanka", "ba435a", new Location(47.608941, -122.340145));
		String logoutgetjson = gson.toJson(logoutget);
		System.out.println(logoutgetjson);
		writer.append("//GET\n");
		writer.append(logoutgetjson+"\n\n"); 
		
		//POST: success
		LogOut logoutpost = new LogOut("success", "User Logged out successfully");
		String logoutpostjson = gson.toJson(logoutpost);
		System.out.println(logoutpostjson);	  
		writer.append("//POST: success\n");
		writer.append(logoutpostjson+"\n\n");
		
		//POST: failure
				 logoutpost = new LogOut("Failure", "Looks like some error in logging out");
				 logoutpostjson = gson.toJson(logoutpost);
				System.out.println(logoutpostjson);	  
				writer.append("//POST: failure\n");
				writer.append(logoutpostjson+"\n\n");
		
		 writer.close();
	}

}
