package models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import forms.FlatData;
import forms.PGData;
import forms.TenantData;
import helperclasses.Commute;
import helperclasses.FoodOptions;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
//import helperclasses.RatingAndListOfStrings;
import helperclasses.RatingAndListOfEsAndString;
@Document(collection = "tenantdata")
public class FlatDataModel {
	
	private String propertyId;
	 private List<FlatData> flatdatalist;
	 


	public FlatDataModel(String propertyId, List<FlatData> flatdatalist) {
		// TODO Auto-generated constructor stub
		this.propertyId= propertyId;
		this.flatdatalist= flatdatalist;
	}

	
}
