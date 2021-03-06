package forms;

import helperclasses.PropertyNameTypeisLocked;
import helperclasses.STATUS;

import java.util.List;

import models.BuildingDataModel;
import models.PGDataModel;

@SuppressWarnings("unused")
public class ExistingPropertyData {

	// GET
	private String username;
	
	private String token;
	private String propertyId;

	// POST
	private STATUS status;
	private String message;
	private PGData pgData;
	private BuildingData buildingData;
	// POST: on the basis of location
	private List<PropertyNameTypeisLocked> propertyNameTypeisLocked;

	public ExistingPropertyData(String username, String token, String propertyId) {
		this.username = username;
		this.token = token;
		this.propertyId = propertyId;
	}

	public ExistingPropertyData(STATUS status, String message) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
	}

	public ExistingPropertyData(STATUS status, String message,
			PGData pgData) {
		this.status = status;
		this.message = message;
		this.pgData = pgData;
	}

	public ExistingPropertyData(STATUS status, String message,
			BuildingData buildingData) {
		this.status = status;
		this.message = message;
		this.buildingData = buildingData;
	}

	public ExistingPropertyData(STATUS status, String message,
			List<PropertyNameTypeisLocked> propertyNameTypeisLocked) {
		this.status = status;
		this.message = message;
		this.propertyNameTypeisLocked = propertyNameTypeisLocked;

	}

	public Object getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	public String getToken() {
		// TODO Auto-generated method stub
		return this.token;
	}

	public Object getPropertyId() {
		// TODO Auto-generated method stub
		return this.propertyId;
	}

}
