package models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import forms.FlatData;

@Document(collection = "flatdata")
public class FlatDataModel {
	
	private String propertyId;
	 private List<FlatData> flatdatalist;
	 
	 public FlatDataModel() {
		// TODO Auto-generated constructor stub
	}

	public FlatDataModel(String propertyId, List<FlatData> flatdatalist) {
		// TODO Auto-generated constructor stub
		this.setPropertyId(propertyId);
		this.setFlatdatalist(flatdatalist);
	}



	public String getPropertyId() {
		return propertyId;
	}



	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}



	public List<FlatData> getFlatdatalist() {
		return flatdatalist;
	}



	public void setFlatdatalist(List<FlatData> flatdatalist) {
		this.flatdatalist = flatdatalist;
	}

	
}
