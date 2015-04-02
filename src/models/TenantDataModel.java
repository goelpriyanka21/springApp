package models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import forms.PGData;
import forms.TenantData;
import helperclasses.Commute;
import helperclasses.FoodOptions;
import helperclasses.Location;
import helperclasses.RatingAndListOfEs;
//import helperclasses.RatingAndListOfStrings;
import helperclasses.RatingAndListOfEsAndString;
@Document(collection = "tenantdata")
public class TenantDataModel {
	
	private String propertyId;
	 private List<TenantData> pgtenantlist;
	 
	 public TenantDataModel(String propertyId,  List<TenantData> pgtenantlist){
			this.propertyId= propertyId;
			this.pgtenantlist= pgtenantlist;
			
		}

	
}
