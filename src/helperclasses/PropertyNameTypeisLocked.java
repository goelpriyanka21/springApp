package helperclasses;

public class PropertyNameTypeisLocked {
	
	private String propertyId;
	private String propertyName;
	private String propertytype;
	private Boolean isLocked;
	
	
	public PropertyNameTypeisLocked(String propertyName, String propertytype, String propertyId, Boolean isLocked){
		this.propertyName= propertyName;
		this.propertytype= propertytype;
		this.propertyId= propertyId;
		this.isLocked= isLocked;
		
	}
	
	public PropertyNameTypeisLocked(String propertyName, String propertytype, String propertyId){
		this.propertyName= propertyName;
		this.propertytype= propertytype;
		this.propertyId= propertyId;
	//	this.isLocked= false; at backend we will intialise this to 
		
	}
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	
}
