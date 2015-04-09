package springapp.web;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import models.PhotoModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import validators.PhotoAPIValidator;

@Controller
public class AddPhotoAPI {
	
	private static Properties prop;
	
	@RequestMapping(value = "/findconfigproperty", method = RequestMethod.POST)
	private @ResponseBody String getConfigProperty() throws IOException {
		if(prop == null){
			prop = new Properties();
			InputStream input = AddPhotoAPI.class.getClassLoader().getResourceAsStream("config.properties");
			if(input==null){
				return "config.properties file not found";  // make it null wen u dont want to use dis method anymore ..
			}
			prop.load(input);
			input.close();
		}
		return prop.getProperty("filepath");
	}
	
	@RequestMapping(value = "/uploadphoto", method = RequestMethod.POST)
	public @ResponseBody String addphoto(@RequestParam String propertyId, @RequestParam String flatnumber,
			@RequestParam String propertyType, @RequestParam String section,
			@RequestParam String photoname,
			@RequestParam("file") MultipartFile file) throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		
		String photoAPIValidatorresult= PhotoAPIValidator.validate(propertyId, flatnumber, propertyType, section, photoname);
		if(!photoAPIValidatorresult.equals("Successful"))
			return photoAPIValidatorresult;

		// Create directory
		if(getConfigProperty()==null) return "config.properties file not found";
		File files = new File(getConfigProperty()
				+ propertyId + "/" + section);
		if (!files.exists()) {
			if (files.mkdirs()) {
				System.out.println("Multiple directories are created!");
			} else {
				System.out.println("Failed to create multiple directories!");
			}
		}

		String uploadedFileLocation = getConfigProperty()
				+ propertyId + "/" + section + "/" + photoname;
// updated file if file already exists
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(uploadedFileLocation)));
				stream.write(bytes);
				stream.close();
				mongoOperation.save(new PhotoModel(propertyId, propertyType,
						section, photoname, uploadedFileLocation));
				return "You successfully uploaded " + "!";
			} catch (Exception e) {
				return "You failed to upload  => " + e.getMessage();
			}
		} else {
			return "You failed to upload because the file was empty.";
		}
		

	}
}
