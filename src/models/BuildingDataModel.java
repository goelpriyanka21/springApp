package models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import forms.BuildingData;

@Document(collection = "buildingdata")
public class BuildingDataModel {

	private String propertyId;
	private BuildingData buildingData;
	private Boolean isLocked;
	private String createdBy_username;
	private Date createdDate;
	private String modifiedBy_username;
	private Date modifiedDate;
	
	public BuildingDataModel() {
		// TODO Auto-generated constructor stub
	}

	public BuildingDataModel(String propertyId, BuildingData buildingData,
			String createdBy_username) {
		this.propertyId = propertyId;
		this.setBuildingData(buildingData);
		this.setIsLocked(true);
		this.setCreatedBy_username(createdBy_username);
		this.setCreatedDate(new Date());
	}
	
//	public BuildingDataModel(String propertyId, BuildingData buildingData,
//			String createdBy_username, Date createdDate, String modifiedBy_username) {
//		this.propertyId = propertyId;
//		this.setBuildingData(buildingData);
//		this.isLocked = true;
//		this.setCreatedBy_username(createdBy_username);
//		this.setCreatedDate(createdDate);
//		this.setModifiedBy_username(modifiedBy_username);
//		this.setModifiedDate(new Date());
//
//	}

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

	public String getCreatedBy_username() {
		return createdBy_username;
	}

	public void setCreatedBy_username(String createdBy_username) {
		this.createdBy_username = createdBy_username;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy_username() {
		return modifiedBy_username;
	}

	public void setModifiedBy_username(String modifiedBy_username) {
		this.modifiedBy_username = modifiedBy_username;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	

}
