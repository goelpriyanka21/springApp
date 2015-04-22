import forms.LogoutData;
import forms.PostForm;
import helperclasses.Location;
import helperclasses.LogoutAPIMsgs;
import helperclasses.STATUS;

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
		LogoutData logoutget = new LogoutData("Priyanka", "ba435a", new Location(47.608941, -122.340145));
		String logoutgetjson = gson.toJson(logoutget);
		System.out.println(logoutgetjson);
		writer.append("//GET\n");
		writer.append(logoutgetjson+"\n\n"); 
		
		//POST: Success
		PostForm logoutpost = new PostForm(STATUS.Success, LogoutAPIMsgs.LOGGED_OUT_SUCCESSFULLY);
		String logoutpostjson = gson.toJson(logoutpost);
		System.out.println(logoutpostjson);	  
		writer.append("//POST: Success\n");
		writer.append(logoutpostjson+"\n\n");
		
		 writer.close();
	}

}
