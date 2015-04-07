package forms;

import helperclasses.PropertyNameTypeisLocked;

import java.util.List;

import models.BuildingDataModel;
import models.PGDataModel;

public class ExistingPropertyData {
	
	// GET
		private String propertyId;
		
		// POST: on the basis of location
			private List<PropertyNameTypeisLocked> propertyNameTypeisLocked;
		
			// POST
		private PGDataModel pgDataModel;
		private BuildingDataModel buildingDataModel;
		private String status;
		private String message;

		
		
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

	
	public ExistingPropertyData(PGDataModel pgDataModel) {
		// TODO Auto-generated constructor stub

		this.pgDataModel = pgDataModel;

	}

	public ExistingPropertyData(BuildingDataModel buildingDataModel) {
		// TODO Auto-generated constructor stub

		this.buildingDataModel = buildingDataModel;

	}

	public ExistingPropertyData(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.status= string;
		this.message= string2;
	}

	public ExistingPropertyData(String propertyId) {
		// TODO Auto-generated constructor stub
		this.propertyId= propertyId;
	}
	
	public ExistingPropertyData(List<PropertyNameTypeisLocked> propertyNameTypeisLocked) {
		this.propertyNameTypeisLocked = propertyNameTypeisLocked;

	}
	
	public List<PropertyNameTypeisLocked> getPropertyNameTypeisLocked() {
		return propertyNameTypeisLocked;
	}

	public void setPropertyNameTypeisLocked(
			List<PropertyNameTypeisLocked> propertyNameTypeisLocked) {
		this.propertyNameTypeisLocked = propertyNameTypeisLocked;
	}

}
