package springapp.web;
import java.util.Map;

import models.AuthenticationDetails;
import models.PhotoModel;
import models.UserNameToken;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import validators.PhotoAPIValidator;
import validators.TokenValidator;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import forms.PostForm;

@Controller
public class AddPhotoAPI {
	
	@RequestMapping(value = "/uploadphoto", method = RequestMethod.POST)
	public @ResponseBody PostForm addphoto(@RequestParam("username") String username, @RequestParam("token") String token, @RequestParam("propertyId") String propertyId, @RequestParam("flatnumber") String flatnumber,
			@RequestParam("propertyType") String propertyType, @RequestParam("section") String section,
			@RequestParam("photoname") String photoname,
			@RequestParam("file") MultipartFile file) throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		
		// AuthenticationDetails Validators
				AuthenticationDetails authenticationDetails = mongoOperation.findOne(
						new Query(Criteria.where("username").is(
								username)),
						AuthenticationDetails.class);

				if (authenticationDetails == null)
					return new PostForm("Failure", "Username does not exist");

				// TOKEN AUTHENTICATION FAILURE:
				UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
						.where("username").is(username)),
						UserNameToken.class);

				if (!TokenValidator.validate(usernametoken.gettoken(),
						token))
					return new PostForm("Failure", "Token authentication failed");
				
		String photoAPIValidatorresult= PhotoAPIValidator.validate(propertyId, flatnumber, propertyType, section, photoname);
		if(!photoAPIValidatorresult.equals("Successful"))
			return new PostForm("Failure", photoAPIValidatorresult);
		try {
			// TODO : Make this configurable. Separate accounts for production and dev - shetty 10-apr-15
			
			// THIS IS FOR DEVELOPEMNT
			/*Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
					  "cloud_name", "grbh",
					  "api_key", "266747318345815",
					  "api_secret", "NID3oheFJGcg1Sisu2hTgePpiv0"));*/
			// PRODUCTION SETTINGS
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
					  "cloud_name", "grabhouse",
					  "api_key", "573923864849251",
					  "api_secret", "U7q8f_oV0proD8NDPu3evypgV6M"));
			
			Map params = ObjectUtils.asMap("folder", "/dc/" + propertyId);
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(), params);
			try {
				mongoOperation.save(new PhotoModel(propertyId, propertyType,
						section, photoname, (String) uploadResult.get("url")));
				return new PostForm("Success", "File uploaded successfully!");
			} catch (Exception e) {
				e.printStackTrace();
				return new PostForm("Failure", "Failed to upload the file "+e.getMessage());
			}
		} catch (RuntimeException  e) {
			return new PostForm("Failure", "Failed to upload the file : "+e.getMessage());
		}
	}
}
