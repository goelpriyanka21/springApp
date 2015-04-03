package models;

import forms.BuildingData;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "buildingdata")
public class BuildingDataModel {

	private String propertyId;
	private BuildingData buildingData;

	public BuildingDataModel(String propertyId, BuildingData buildingData) {
		this.propertyId = propertyId;
		this.setBuildingData(buildingData);

	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public BuildingData getBuildingData() {
		return buildingData;
	}

	public void setBuildingData(BuildingData buildingData) {
		this.buildingData = buildingData;
	}

}
