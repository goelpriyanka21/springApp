package validators;

import forms.FlatData;
import helperclasses.SectionListOfFileNamePair;
import models.BuildingDataModel;
import models.FlatDataModel;
import models.PGDataModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class PhotoAPIValidator {
	public static String validate(String propertyId, String flatnumber,
			String propertyType, String section, String photoname) {
		// Validations of fields
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		Query query = new Query();
		query.addCriteria(Criteria.where("propertyId").is(propertyId));

		// PG
		if (propertyType.equals("PG")) {
			PGDataModel pgDataModel = mongoOperation.findOne(query,
					PGDataModel.class);
			if (pgDataModel == null)
				return "There is no such propertyId existing on server";

			for (SectionListOfFileNamePair sectionListOfFileNamePair : pgDataModel
					.getPgdata().getPicturelist()) {
				if (sectionListOfFileNamePair.getSection().equals(section)) {
					for (String dbphotoname : sectionListOfFileNamePair
							.getPhotonamelist()) {
						if (dbphotoname.equals(photoname)) {
							return "Successful";
						}
					}
					return "There is no such photoname on server for this propertyId and section";
				}
			}
			return "There is no such section on server for this propertyId";
		}
		// Building
		else if (propertyType.equals("Building")) {
			BuildingDataModel buildingDataModel = mongoOperation.findOne(query,
					BuildingDataModel.class);
			if (buildingDataModel == null)
				return "There is no such propertyId existing on server";

			for (SectionListOfFileNamePair sectionListOfFileNamePair : buildingDataModel
					.getBuildingData().getPicturelist()) {
				if (sectionListOfFileNamePair.getSection().equals(section)) {
					for (String dbphotoname : sectionListOfFileNamePair
							.getPhotonamelist()) {
						if (dbphotoname.equals(photoname)) {
							return "Successful";
						}
					}
					return "There is no such photoname on server for this propertyId and section";
				}
			}
			return "There is no such section on server for this propertyId";
		} else if (propertyType.equals("Flat")) {
			if (flatnumber == null)
				return "Please provide flatnumber";
			query.addCriteria(Criteria.where("flatdatalist.flatnumber").is(
					flatnumber));
			FlatDataModel flatDataModel = mongoOperation.findOne(query,
					FlatDataModel.class);
			if (flatDataModel == null)
				return "There is no such propertyId existing on server";
			for (FlatData flatData : flatDataModel.getFlatdatalist()) {
				if (flatData.getFlatnumber().equals(flatnumber)) {
					for (SectionListOfFileNamePair sectionListOfFileNamePair : flatData
							.getPicturelist()) {
						if (sectionListOfFileNamePair.getSection().equals(
								section)) {
							for (String dbphotoname : sectionListOfFileNamePair
									.getPhotonamelist()) {
								if (dbphotoname.equals(photoname)) {
									return "Successful";
								}
							}
							return "There is no such photoname on server for this propertyId and section";
						}
					}
					return "There is no such section on server for this propertyId and flat number";
				}
			}
			return "There is no such flat number on server for this propertyId";

		} else
			return "There is no such propertyType: propertyType can only be PG/Building?Flat";

	}
}
