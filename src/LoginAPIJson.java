import forms.Login;
import helperclasses.Location;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginAPIJson {
	static FileWriter writer;
	public static void main(String[] args) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//write converted json data to a file named "CountryGSON.json"  
	    writer= new FileWriter("/Users/priyanka/git/grabhouse//LoginAPIJson.json"); 
		
		//GET
		Login loginget = new Login("Priyanka", "priya123", "ba435a", new Location(47.608941, -122.340145));
		String logingetjson = gson.toJson(loginget);
		System.out.println(logingetjson);
		writer.append("//GET\n");
		writer.append(logingetjson+"\n\n"); 
		
		//POST: Failure
				Login loginpost = new Login("Failure", "UserName does not exist");
				String loginpostjson = gson.toJson(loginpost);
				System.out.println(loginpostjson);	  
				writer.append("//POST: Failure\n");
				writer.append(loginpostjson+"\n\n");
				
				//POST: Failure
				 loginpost = new Login("Failure", "UserName And Password does not match");
				 loginpostjson = gson.toJson(loginpost);
				System.out.println(loginpostjson);	  
				writer.append("//POST: Failure\n");
				writer.append(loginpostjson+"\n\n");
				
				//POST: Failure
				 loginpost = new Login("Failure", "DeviceId Authentication failed");
				 loginpostjson = gson.toJson(loginpost);
				System.out.println(loginpostjson);	  
				writer.append("//POST: Failure\n");
				writer.append(loginpostjson+"\n\n");
		
		//POST: success
		 loginpost = new Login("success", "Authentication successful, Keep the token for this session", "pritoken123");
		 loginpostjson = gson.toJson(loginpost);
		System.out.println(loginpostjson);	  
		writer.append("//POST\n");
		writer.append(loginpostjson+"\n\n");
		
		 writer.close();
	}

}
