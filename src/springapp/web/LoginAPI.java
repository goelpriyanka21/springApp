package springapp.web;

import helperclasses.Location;

import java.io.FileWriter;
import java.io.IOException;

import models.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class LoginAPI {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
public @ResponseBody JsonNull testGet(@RequestParam String username, @RequestParam String password, @RequestParam Location gpslocation, @RequestParam String deviceid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Login login = new Login("Priyanka", "priya123",  "ba435a", gpslocation);
		String loginjson = gson.toJson(login);
		System.out.println(loginjson);
		try {  
			   //write converted json data to a file named "CountryGSON.json"  
			   FileWriter writer = new FileWriter("/Users/priyanka/git/grabhouse//LoginAPIGETJson.json");  
			   writer.write(loginjson);  
			   writer.close();  
			    
			  } catch (IOException e) {  
			   e.printStackTrace();  
			  }
		return null;  
    }

}
