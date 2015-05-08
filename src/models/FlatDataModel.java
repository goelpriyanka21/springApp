package models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import forms.FlatData;

@Document(collection = "flatdata")
public class FlatDataModel {

	@SuppressWarnings("unused")
	private String propertyId;
	private List<FlatData> flatdatalist;

	public FlatDataModel(String propertyId, List<FlatData> flatdatalist) {
		this.propertyId = propertyId;
		this.flatdatalist = flatdatalist;
	}

	public List<FlatData> getFlatdatalist() {
		return flatdatalist;
	}

}
