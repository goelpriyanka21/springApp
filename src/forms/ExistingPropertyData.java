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


	// POST
	private String status;
	private PGDataModel pgDataModel;
	private BuildingDataModel buildingDataModel;
	private String message;
	// POST: on the basis of location
	private List<PropertyNameTypeisLocked> propertyNameTypeisLocked;

	public ExistingPropertyData(String username, String token, String propertyId) {
		this.username = username;
		this.token = token;
		this.propertyId = propertyId;
	}
	
	
	public ExistingPropertyData(String status, String message) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
	}
	
	public ExistingPropertyData(String status, String message, PGDataModel pgDataModel) {
		this.status = status;
		this.message = message;
		this.pgDataModel = pgDataModel;
	}

	public ExistingPropertyData(String status, String message, BuildingDataModel buildingDataModel) {
		this.status = status;
		this.message = message;
		this.buildingDataModel = buildingDataModel;
	}
	

	public ExistingPropertyData(String status, String message,
			List<PropertyNameTypeisLocked> propertyNameTypeisLocked) {
		this.status = status;
		this.message = message;
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
