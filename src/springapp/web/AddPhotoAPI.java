package springapp.web;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import models.PhotoModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import validators.PhotoAPIValidator;

@Controller
public class AddPhotoAPI {

	@RequestMapping(value = "/uploadphoto", method = RequestMethod.POST)
	public @ResponseBody String addphoto(@RequestHeader String propertyId, @RequestHeader String flatnumber,
			@RequestHeader String propertyType, @RequestHeader String section,
			@RequestHeader String photoname,
			@RequestParam("file") MultipartFile file) throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		
		String photoAPIValidatorresult= PhotoAPIValidator.validate(propertyId, flatnumber, propertyType, section, photoname);
		if(!photoAPIValidatorresult.equals("Successful"))
			return photoAPIValidatorresult;

		// Create directory
		File files = new File("/Users/priyanka/DataCollectionAppPhotos/"
				+ propertyId + "/" + section);
		if (!files.exists()) {
			if (files.mkdirs()) {
				System.out.println("Multiple directories are created!");
			} else {
				System.out.println("Failed to create multiple directories!");
			}
		}

		String uploadedFileLocation = "/Users/priyanka/DataCollectionAppPhotos/"
				+ propertyId + "/" + section + "/" + photoname;
		// System.out.println(new File(uploadedFileLocation).getAbsolutePath());
		System.out.println(uploadedFileLocation);

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
