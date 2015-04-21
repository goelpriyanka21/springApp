import forms.LoginData;
import forms.PostForm;
import helperclasses.Location;
import helperclasses.STATUS;

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
		LoginData loginget = new LoginData("Priyanka", "priya123", "ba435a", new Location(47.608941, -122.340145));
		String logingetjson = gson.toJson(loginget);
		System.out.println(logingetjson);
		writer.append("//GET\n");
		writer.append(logingetjson+"\n\n"); 
		
		//POST: Failure
		PostForm loginpost = new PostForm(STATUS.Failure, "UserName does not exist");
				String loginpostjson = gson.toJson(loginpost);
				System.out.println(loginpostjson);	  
				writer.append("//POST: Failure\n");
				writer.append(loginpostjson+"\n\n");
				
				//POST: Failure
				 loginpost = new PostForm(STATUS.Failure, "UserName And Password does not match");
				 loginpostjson = gson.toJson(loginpost);
				System.out.println(loginpostjson);	  
				writer.append("//POST: Failure\n");
				writer.append(loginpostjson+"\n\n");
				
				//POST: Failure
				 loginpost = new PostForm(STATUS.Failure, "DeviceId Authentication failed");
				 loginpostjson = gson.toJson(loginpost);
				System.out.println(loginpostjson);	  
				writer.append("//POST: Failure\n");
				writer.append(loginpostjson+"\n\n");
		
		//POST: Success
		 loginpost = new PostForm(STATUS.Success, "Authentication successful, Keep the token for this session", "pritoken123");
		 loginpostjson = gson.toJson(loginpost);
		System.out.println(loginpostjson);	  
		writer.append("//POST\n");
		writer.append(loginpostjson+"\n\n");
		
		 writer.close();
	}

}
