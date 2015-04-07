package helperclasses;

public class UnlockPropertyData {
	private String propertyId;
	private String propertyType;

	public UnlockPropertyData(String propertyId, String propertyType) {
		this.propertyId = propertyId;
		this.propertyType = propertyType;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

}
