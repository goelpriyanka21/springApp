package forms;

import helperclasses.PropertyNameTypeisLocked;

import java.util.List;

import models.BuildingDataModel;
import models.PGDataModel;

public class ExistingPropertyData {

	// GET
	private String username;
	private String token;
	private String propertyId;

	// POST: on the basis of location
	private List<PropertyNameTypeisLocked> propertyNameTypeisLocked;

	// POST
	private PGDataModel pgDataModel;
	private BuildingDataModel buildingDataModel;
	private String status;
	private String message;

	public ExistingPropertyData(String username, String token, String propertyId) {
		this.username = username;
		this.token = token;
		this.propertyId = propertyId;
	}
	
	public ExistingPropertyData(String propertyId) {
		// TODO Auto-generated constructor stub
		this.propertyId = propertyId;
	}
	
	public ExistingPropertyData(String status, String message) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
	}
	
	public ExistingPropertyData(PGDataModel pgDataModel) {
		this.pgDataModel = pgDataModel;
	}

	public ExistingPropertyData(BuildingDataModel buildingDataModel) {
		this.buildingDataModel = buildingDataModel;
	}
	

	public ExistingPropertyData(
			List<PropertyNameTypeisLocked> propertyNameTypeisLocked) {
		this.propertyNameTypeisLocked = propertyNameTypeisLocked;

	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public PGDataModel getPgDataModel() {
		return pgDataModel;
	}

	public void setPgDataModel(PGDataModel pgDataModel) {
		this.pgDataModel = pgDataModel;
	}

	public BuildingDataModel getBuildingDataModel() {
		return buildingDataModel;
	}

	public void setBuildingDataModel(BuildingDataModel buildingDataModel) {
		this.buildingDataModel = buildingDataModel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<PropertyNameTypeisLocked> getPropertyNameTypeisLocked() {
		return propertyNameTypeisLocked;
	}

	public void setPropertyNameTypeisLocked(
			List<PropertyNameTypeisLocked> propertyNameTypeisLocked) {
		this.propertyNameTypeisLocked = propertyNameTypeisLocked;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
