package helperclasses;

public class PropertyNameTypeisLocked {
	private String propertyName;
	private String propertytype;
	private String propertyId;
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
}
