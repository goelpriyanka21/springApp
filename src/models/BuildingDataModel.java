package models;

import forms.BuildingData;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "buildingdata")
public class BuildingDataModel {

	private String propertyId;
	private BuildingData buildingData;
	private Boolean isLocked;

	public BuildingDataModel(String propertyId, BuildingData buildingData) {
		this.propertyId = propertyId;
		this.setBuildingData(buildingData);
		this.setIsLocked(true);


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

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

}
