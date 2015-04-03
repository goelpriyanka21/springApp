package models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


import forms.TenantData;

@Document(collection = "tenantdata")
public class TenantDataModel {
	
	private String propertyId;
	 private List<TenantData> pgtenantlist;
	 
	 public TenantDataModel(String propertyId,  List<TenantData> pgtenantlist){
			this.setPropertyId(propertyId);
			this.setPgtenantlist(pgtenantlist);
			
		}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public List<TenantData> getPgtenantlist() {
		return pgtenantlist;
	}

	public void setPgtenantlist(List<TenantData> pgtenantlist) {
		this.pgtenantlist = pgtenantlist;
	}

	
}
