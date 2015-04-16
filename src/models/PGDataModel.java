package models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import forms.PGData;

@Document(collection = "pgdata")
public class PGDataModel {

	private String propertyId;
	private PGData pgdata;
	private Boolean isLocked;
	private String createdBy_username;
	private Date createdDate;
	private String modifiedBy_username;
	private Date modifiedDate;
	
	
	public PGDataModel() {
		// TODO Auto-generated constructor stub
	}

	public PGDataModel(String propertyId, PGData pgdata,
			String createdBy_username) {
		this.propertyId = propertyId;
		this.pgdata = pgdata;
		this.isLocked = true;
		this.createdBy_username = createdBy_username;
		this.createdDate = new Date();
	}
	
	public PGDataModel(String propertyId, PGData pgdata,
			String createdBy_username, Date createdDate, String modifiedBy_username) {
		this.propertyId = propertyId;
		this.pgdata = pgdata;
		this.isLocked = true;
		this.createdBy_username = createdBy_username;
		this.createdDate = createdDate;
		this.modifiedBy_username= modifiedBy_username;
		this.modifiedDate = new Date();

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

	public Date getModeifiedDate() {
		return modifiedDate;
	}

	public void setModeifiedDate(Date modeifiedDate) {
		this.modifiedDate = modeifiedDate;
	}

	public String getModifiedBy_username() {
		return modifiedBy_username;
	}

	public void setModifiedBy_username(String modifiedBy_username) {
		this.modifiedBy_username = modifiedBy_username;
	}

	

}
