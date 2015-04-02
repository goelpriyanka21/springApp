package models;

import forms.PGData;
import helperclasses.*;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pgdata")
public class PGDataModel {
	
	private String propertyId;
	private PGData pgdata;
	
	public PGDataModel(String propertyId, PGData pgdata){
		this.propertyId= propertyId;
		this.pgdata= pgdata;
		
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public PGData getPgdata() {
		return pgdata;
	}
	public void setPgdata(PGData pgdata) {
		this.pgdata = pgdata;
	}

}
