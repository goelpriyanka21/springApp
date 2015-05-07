package springapp.web;

import helperclasses.PhotoNameAndURLPair;
import helperclasses.STATUS;
import helperclasses.SectionListOfPhotoNameAndURLPair;
import helperclasses.XmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import models.AuthenticationDetails;
import models.BuildingDataModel;
import models.FlatDataModel;
import models.PGDataModel;
import models.TestingData;
import models.UserNameToken;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import validators.TokenValidator;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import forms.FlatData;
import forms.PostForm;

@Controller
public class AddPhotoAPI {

	static class ConfigProperties {
		static Properties prop;

		static void loadPropertiesFile() throws IOException {
			prop = new Properties();
//			InputStream input = new FileInputStream("config.properties");
			InputStream input = AddPhotoAPI.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);
			input.close();
		}

		static Properties getproperties() throws IOException {
			if (prop == null) {
				loadPropertiesFile();
			}
			return prop;
		}
	}

	@RequestMapping(value = "/uploadphoto", method = RequestMethod.POST)
	public @ResponseBody PostForm addphoto(
			@RequestParam("username") String username,
			@RequestParam("token") String token,
			@RequestParam("propertyId") String propertyId,
			@RequestParam("flatnumber") String flatnumber,
			@RequestParam("propertyType") String propertyType,
			@RequestParam("section") String section,
			@RequestParam("photoname") String photoname,
			@RequestParam("file") MultipartFile file) throws Exception {

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		mongoOperation
				.save(new TestingData(new AddPhotoData(username, token,
						propertyId, flatnumber, propertyType, section,
						photoname, file)));

		// AuthenticationDetails Validators
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(username)),
				AuthenticationDetails.class);

		PostForm postForm;
		if (authenticationDetails == null) {
			postForm = new PostForm(STATUS.Failure,
					AddPhotoAPIMsgs.USER_NOT_EXIST);
			mongoOperation.save(new TestingData(postForm));
			return postForm;
		}

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(username)), UserNameToken.class);

		if (usernametoken == null) {
			postForm = new PostForm(STATUS.Failure,
					AddPhotoAPIMsgs.USER_NOT_LOGGED_IN);
			mongoOperation.save(new TestingData(postForm));
			return postForm;
		}

		if (!TokenValidator.validate(usernametoken.gettoken(), token)) {
			postForm = new PostForm(STATUS.Failure,
					AddPhotoAPIMsgs.TOKEN_AUTHENTICATION_FAILED);
			mongoOperation.save(new TestingData(postForm));
			return postForm;
		}

		postForm = validateAndUploadPhoto(propertyId, flatnumber, propertyType,
				section, photoname, file);
		mongoOperation.save(new TestingData(postForm));
		return postForm;

	}

	@SuppressWarnings("rawtypes")
	private static Map uploadToCloud(String propertyId, MultipartFile file) {

		Map params = ObjectUtils.asMap("folder", "/dc/" + propertyId);
		Map result = null;
		try {
			Properties prop = ConfigProperties.getproperties();
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
					"cloud_name", prop.getProperty("cloud_name"), "api_key",
					prop.getProperty("api_key"), "api_secret",
					prop.getProperty("api_secret")));
			result = cloudinary.uploader().upload(file.getBytes(), params);
		} catch (IOException e) {
			throw new RuntimeException(
					"failed to load picture to cloud. exception received is "
							+ e);
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	private static PostForm updateToCloudAndDB(
			List<SectionListOfPhotoNameAndURLPair> sectionList, String section,
			String photoname, String propertyId, MultipartFile file,
			Query query, Class clazz, Object data, String fieldName) {
		for (SectionListOfPhotoNameAndURLPair sectionListOfFileNamePair : sectionList) {
			if (sectionListOfFileNamePair.getSection().equals(section)) {
				for (PhotoNameAndURLPair dbphotonameandurl : sectionListOfFileNamePair
						.getPhotonamelist()) {
					if (dbphotonameandurl.getPhotoname().equals(photoname)) {
						try {
							Map uploadResult = uploadToCloud(propertyId, file);

							dbphotonameandurl.setUrl((String) uploadResult
									.get("url"));
							MongoOperations mongoOperation = XmlApplicationContext.CONTEXT
									.getDB();
							mongoOperation.updateFirst(query,
									new Update().set(fieldName, data), clazz);

							return new PostForm(STATUS.Success,
									AddPhotoAPIMsgs.FILE_UPLOADED_SUCCESSFULLY);
						} catch (RuntimeException e) {
							return new PostForm(STATUS.Failure,
									e.getMessage());
						}
					}
				}
				return new PostForm(STATUS.Failure,
						AddPhotoAPIMsgs.NO_SUCH_PHOTONAME);
			}
		}
		return new PostForm(STATUS.Failure, AddPhotoAPIMsgs.NO_SUCH_SECTION);
	}

	private static PostForm uploadPGPhoto(String section, String photoname,
			String propertyId, MultipartFile file) {
		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();
		Query query = new Query();
		query.addCriteria(Criteria.where("propertyId").is(propertyId));
		PGDataModel pgDataModel = mongoOperation.findOne(query,
				PGDataModel.class);
		if (pgDataModel == null) {
			return new PostForm(STATUS.Failure,
					AddPhotoAPIMsgs.NO_SUCH_PROPERTY_ID);
		} else {
			return updateToCloudAndDB(pgDataModel.getPgdata().getPicturelist(),
					section, photoname, propertyId, file, query,
					PGDataModel.class, pgDataModel.getPgdata(), "pgdata");
		}
	}

	private static PostForm uploadBuildingPhoto(String section,
			String photoname, String propertyId, MultipartFile file) {
		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();
		Query query = new Query();
		query.addCriteria(Criteria.where("propertyId").is(propertyId));
		BuildingDataModel buildingDataModel = mongoOperation.findOne(query,
				BuildingDataModel.class);
		if (buildingDataModel == null) {
			return new PostForm(STATUS.Failure,
					AddPhotoAPIMsgs.NO_SUCH_PROPERTY_ID);
		} else {
			return updateToCloudAndDB(buildingDataModel.getBuildingData()
					.getPicturelist(), section, photoname, propertyId, file,
					query, BuildingDataModel.class,
					buildingDataModel.getBuildingData(), "buildingdata");
		}
	}

	private static PostForm uploadFlatPhoto(String section, String flatnumber,
			String photoname, String propertyId, MultipartFile file) {
		if (flatnumber == null) {
			return new PostForm(STATUS.Failure, AddPhotoAPIMsgs.NO_FLAT_NUMBER);
		}

		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();
		Query query = new Query();
		query.addCriteria(Criteria.where("propertyId").is(propertyId));
		FlatDataModel flatDataModel = mongoOperation.findOne(query,
				FlatDataModel.class);
		if (flatDataModel == null) {
			return new PostForm(STATUS.Failure,
					AddPhotoAPIMsgs.NO_SUCH_PROPERTY_ID);
		}

		for (FlatData flatData : flatDataModel.getFlatdatalist()) {
			if (flatData.getFlatnumber().equals(flatnumber)) {
				return updateToCloudAndDB(flatData.getPicturelist(), section,
						photoname, propertyId, file, query,
						FlatDataModel.class, flatDataModel.getFlatdatalist(),
						"flatdatalist");
			}
		}
		return new PostForm(STATUS.Failure, AddPhotoAPIMsgs.NO_SUCH_FLAT_NUMBER);
	}

	public static PostForm validateAndUploadPhoto(String propertyId,
			String flatnumber, String propertyType, String section,
			String photoname, MultipartFile file) {
		PostForm retVal = null;
		switch (propertyType) {
		case "PG":
			retVal = uploadPGPhoto(section, photoname, propertyId, file);
			break;
		case "Building":
			retVal = uploadBuildingPhoto(section, photoname, propertyId, file);
			break;
		case "Flat":
			retVal = uploadFlatPhoto(section, flatnumber, photoname,
					propertyId, file);
			break;
		default:
			retVal = new PostForm(STATUS.Failure,
					AddPhotoAPIMsgs.NO_SUCH_PROPERTY_TYPE);
		}
		return retVal;
	}

	class AddPhotoData {
		String username;
		String token;
		String propertyId;
		String flatnumber;
		String propertyType;
		String section;
		String photoname;
		MultipartFile file;

		AddPhotoData(String username, String token, String propertyId,
				String flatnumber, String propertyType, String section,
				String photoname, MultipartFile file) {
			this.username = username;
			this.token = token;
			this.propertyId = propertyId;
			this.flatnumber = flatnumber;
			this.propertyType = propertyType;
			this.section = section;
			this.file = file;

		}

	}
}

class AddPhotoAPIMsgs {
	public static final String USER_NOT_EXIST = "Username does not exist";
	public static final String TOKEN_AUTHENTICATION_FAILED = "Token authentication failed";
	public static final String NO_SUCH_PROPERTY_ID = "There is no such propertyId existing on server";
	public static final String NO_FLAT_NUMBER = "flatnumber can't be left blank uploading files for flats";
	public static final String NO_SUCH_PHOTONAME = "There is no such photoname on server for this propertyId and section";
	public static final String NO_SUCH_SECTION = "There is no such section on server for this propertyId";
	public static final String NO_SUCH_FLAT_NUMBER = "There is no such flat number on server for this propertyId";
	public static final String NO_SUCH_PROPERTY_TYPE = "There is no such propertyType: propertyType can only be PG/Building?Flat";
	public static final String FILE_UPLOADED_SUCCESSFULLY = "File uploaded successfully!";
	public static final String FILE_UPLOADED_FAILED = "File upload failed!";
	public static final String USER_NOT_LOGGED_IN = "user is not logged in";
}

enum PropertyType {
	PG, Building, Flat;
}
