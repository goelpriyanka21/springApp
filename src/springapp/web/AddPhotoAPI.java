package springapp.web;

import helperclasses.PhotoNameAndURLPair;
import helperclasses.SectionListOfPhotoNameAndURLPair;
import helperclasses.STATUS;
import helperclasses.XmlApplicationContext;

import java.io.IOException;
import java.util.Map;

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
		
		mongoOperation.save(new TestingData(new AddPhotoData(username, token, propertyId, flatnumber, propertyType, section, photoname, file)));

		// AuthenticationDetails Validators
		AuthenticationDetails authenticationDetails = mongoOperation.findOne(
				new Query(Criteria.where("username").is(username)),
				AuthenticationDetails.class);

		PostForm postForm;
		if (authenticationDetails == null){
			postForm= new PostForm(STATUS.Failure, "Username does not exist");
			mongoOperation.save(new TestingData(postForm));
			return postForm;
			}

		// TOKEN AUTHENTICATION FAILURE:
		UserNameToken usernametoken = mongoOperation.findOne(new Query(Criteria
				.where("username").is(username)), UserNameToken.class);

		if (!TokenValidator.validate(usernametoken.gettoken(), token)){
			postForm= new PostForm(STATUS.Failure, "Token authentication failed");
			mongoOperation.save(new TestingData(postForm));
			return postForm;
		}

		postForm= validateAndUploadPhoto(propertyId, flatnumber, propertyType,
				section, photoname, file);
		mongoOperation.save(new TestingData(postForm));
		return postForm;

	}

	public static PostForm validateAndUploadPhoto(String propertyId,
			String flatnumber, String propertyType, String section,
			String photoname, MultipartFile file) {
		// Validations of fields
		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		Query query = new Query();
		query.addCriteria(Criteria.where("propertyId").is(propertyId));

		// PG
		if (propertyType.equals("PG")) {
			PGDataModel pgDataModel = mongoOperation.findOne(query,
					PGDataModel.class);
			if (pgDataModel == null)
				return new PostForm(STATUS.Failure,
						"There is no such propertyId existing on server");

			for (SectionListOfPhotoNameAndURLPair sectionListOfFileNamePair : pgDataModel
					.getPgdata().getPicturelist()) {
				if (sectionListOfFileNamePair.getSection().equals(section)) {
					for (PhotoNameAndURLPair dbphotonameandurl : sectionListOfFileNamePair
							.getPhotonamelist()) {
						if (dbphotonameandurl.getPhotoname().equals(photoname)) {
							try {
								// TODO : Make this configurable. Separate
								// accounts for production and dev - shetty
								// 10-apr-15

								// THIS IS FOR DEVELOPEMNT
								/*
								 * Cloudinary cloudinary = new
								 * Cloudinary(ObjectUtils.asMap( "cloud_name",
								 * "grbh", "api_key", "266747318345815",
								 * "api_secret",
								 * "NID3oheFJGcg1Sisu2hTgePpiv0"));
								 */
								// PRODUCTION SETTINGS
								Cloudinary cloudinary = new Cloudinary(
										ObjectUtils.asMap("cloud_name",
												"grabhouse", "api_key",
												"573923864849251",
												"api_secret",
												"U7q8f_oV0proD8NDPu3evypgV6M"));

								Map params = ObjectUtils.asMap("folder", "/dc/"
										+ propertyId);
								Map uploadResult = cloudinary.uploader()
										.upload(file.getBytes(), params);
								try {
									dbphotonameandurl
											.setUrl((String) uploadResult
													.get("url"));
									mongoOperation.updateFirst(query,
											new Update().set("pgdata",
													pgDataModel.getPgdata()),
											PGDataModel.class);

									// mongoOperation.save(new
									// PhotoModel(propertyId, propertyType,
									// section, photoname, (String)
									// uploadResult.get("url")));
									return new PostForm(STATUS.Success,
											"File uploaded successfully!");
								} catch (Exception e) {
									e.printStackTrace();
									return new PostForm(STATUS.Failure,
											"Failed to upload the file "
													+ e.getMessage());
								}
							} catch (RuntimeException e) {
								return new PostForm(STATUS.Failure,
										"Failed to upload the file : "
												+ e.getMessage());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					return new PostForm(STATUS.Failure,
							"There is no such photoname on server for this propertyId and section");
				}
			}
			return new PostForm(STATUS.Failure,
					"There is no such section on server for this propertyId");
		}

		// Building
		else if (propertyType.equals("Building")) {
			BuildingDataModel buildingDataModel = mongoOperation.findOne(query,
					BuildingDataModel.class);
			if (buildingDataModel == null)
				return new PostForm(STATUS.Failure,
						"There is no such propertyId existing on server");

			for (SectionListOfPhotoNameAndURLPair sectionListOfFileNamePair : buildingDataModel
					.getBuildingData().getPicturelist()) {
				if (sectionListOfFileNamePair.getSection().equals(section)) {
					for (PhotoNameAndURLPair dbphotonameandurl : sectionListOfFileNamePair
							.getPhotonamelist()) {
						if (dbphotonameandurl.getPhotoname().equals(photoname)) {
							try {
								// TODO : Make this configurable. Separate
								// accounts for production and dev - shetty
								// 10-apr-15

								// THIS IS FOR DEVELOPEMNT
								/*
								 * Cloudinary cloudinary = new
								 * Cloudinary(ObjectUtils.asMap( "cloud_name",
								 * "grbh", "api_key", "266747318345815",
								 * "api_secret",
								 * "NID3oheFJGcg1Sisu2hTgePpiv0"));
								 */
								// PRODUCTION SETTINGS
								Cloudinary cloudinary = new Cloudinary(
										ObjectUtils.asMap("cloud_name",
												"grabhouse", "api_key",
												"573923864849251",
												"api_secret",
												"U7q8f_oV0proD8NDPu3evypgV6M"));

								Map params = ObjectUtils.asMap("folder", "/dc/"
										+ propertyId);
								Map uploadResult = cloudinary.uploader()
										.upload(file.getBytes(), params);
								try {
									dbphotonameandurl
											.setUrl((String) uploadResult
													.get("url"));
									mongoOperation
											.updateFirst(
													query,
													new Update()
															.set("buildingData",
																	buildingDataModel
																			.getBuildingData()),
													BuildingDataModel.class);

									// mongoOperation.save(new
									// PhotoModel(propertyId, propertyType,
									// section, photoname, (String)
									// uploadResult.get("url")));
									return new PostForm(STATUS.Success,
											"File uploaded successfully!");
								} catch (Exception e) {
									e.printStackTrace();
									return new PostForm(STATUS.Failure,
											"Failed to upload the file "
													+ e.getMessage());
								}
							} catch (RuntimeException e) {
								return new PostForm(STATUS.Failure,
										"Failed to upload the file : "
												+ e.getMessage());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

					return new PostForm(STATUS.Failure,
							"There is no such photoname on server for this propertyId and section");
				}
			}
			return new PostForm(STATUS.Failure,
					"There is no such section on server for this propertyId");
		} else if (propertyType.equals("Flat")) {
			if (flatnumber == null)
				return new PostForm(STATUS.Failure, "Please provide flatnumber");
			// query.addCriteria(Criteria.where("flatdatalist.flatnumber").is(
			// flatnumber));
			FlatDataModel flatDataModel = mongoOperation.findOne(query,
					FlatDataModel.class);
			if (flatDataModel == null)
				return new PostForm(STATUS.Failure,
						"There is no such propertyId existing on server");
			for (FlatData flatData : flatDataModel.getFlatdatalist()) {
				if (flatData.getFlatnumber().equals(flatnumber)) {
					for (SectionListOfPhotoNameAndURLPair sectionListOfFileNamePair : flatData
							.getPicturelist()) {
						if (sectionListOfFileNamePair.getSection().equals(
								section)) {
							for (PhotoNameAndURLPair dbphotonameandurl : sectionListOfFileNamePair
									.getPhotonamelist()) {
								if (dbphotonameandurl.getPhotoname().equals(
										photoname)) {
									try {
										// TODO : Make this configurable.
										// Separate accounts for production and
										// dev - shetty 10-apr-15

										// THIS IS FOR DEVELOPEMNT
										/*
										 * Cloudinary cloudinary = new
										 * Cloudinary(ObjectUtils.asMap(
										 * "cloud_name", "grbh", "api_key",
										 * "266747318345815", "api_secret",
										 * "NID3oheFJGcg1Sisu2hTgePpiv0"));
										 */
										// PRODUCTION SETTINGS
										Cloudinary cloudinary = new Cloudinary(
												ObjectUtils
														.asMap("cloud_name",
																"grabhouse",
																"api_key",
																"573923864849251",
																"api_secret",
																"U7q8f_oV0proD8NDPu3evypgV6M"));

										Map params = ObjectUtils.asMap(
												"folder", "/dc/" + propertyId);
										Map uploadResult = cloudinary
												.uploader()
												.upload(file.getBytes(), params);
										try {
											dbphotonameandurl
													.setUrl((String) uploadResult
															.get("url"));
											mongoOperation.updateFirst(query,
													new Update().set(
															"flatdatalist",
															flatDataModel),
													FlatDataModel.class);

											// mongoOperation.save(new
											// PhotoModel(propertyId,
											// propertyType,
											// section, photoname, (String)
											// uploadResult.get("url")));
											return new PostForm(STATUS.Success,
													"File uploaded successfully!");
										} catch (Exception e) {
											e.printStackTrace();
											return new PostForm(STATUS.Failure,
													"Failed to upload the file "
															+ e.getMessage());
										}
									} catch (RuntimeException e) {
										return new PostForm(STATUS.Failure,
												"Failed to upload the file : "
														+ e.getMessage());
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
							return new PostForm(STATUS.Failure,
									"There is no such photoname on server for this propertyId and section");
						}
					}
					return new PostForm(STATUS.Failure,
							"There is no such section on server for this propertyId and flat number");
				}
			}
			return new PostForm(STATUS.Failure,
					"There is no such flat number on server for this propertyId");

		} else
			return new PostForm(STATUS.Failure,
					"There is no such propertyType: propertyType can only be PG/Building?Flat");

	}
	
	
	class AddPhotoData{
		String username;
		String token;
		String propertyId;
		String flatnumber;
		String propertyType;
		String section;
		String photoname;
		MultipartFile file;
		
		AddPhotoData(String username,
		String token,
		String propertyId,
		String flatnumber,
		String propertyType,
		String section,
		String photoname,
		MultipartFile file){
			this.username=username;
			this.token=token;
			this.propertyId=propertyId;
			this.flatnumber=flatnumber;
			this.propertyType=propertyType;
			this.section=section;
			this.file=file;
			
		}
		
	}
}
