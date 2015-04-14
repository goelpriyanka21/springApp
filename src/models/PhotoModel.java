//package models;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "photos")
//public class PhotoModel {
//	
//	private String propertyId;  // pg name or society name or flat number
//	private String propertyType;  // pg or building or flat
//	private String section;
//	private String photoname;  
//	private String photopath;
//	
//	public PhotoModel(String propertyId,  // pg name or society name or flat number
//			String propertyType,
//	 String section,
//	 String photoname, 
//	 String photopath){
//		this.propertyId= propertyId;
//		this.propertyType= propertyType;
//		this.section= section;
//		this.photoname= photoname;
//		this.setPhotopath(photopath);
//		
//	}
//	
//	public String getPropertyId() {
//		return propertyId;
//	}
//	public void setPropertyId(String propertyId) {
//		this.propertyId = propertyId;
//	}
//	public String getSection() {
//		return section;
//	}
//	public void setSection(String section) {
//		this.section = section;
//	}
//	public String getPhotoname() {
//		return photoname;
//	}
//	public void setPhotoname(String photoname) {
//		this.photoname = photoname;
//	}
//	
//
//	public String getPropertyType() {
//		return propertyType;
//	}
//
//	public void setPropertyType(String propertyType) {
//		this.propertyType = propertyType;
//	}
//
//	public String getPhotopath() {
//		return photopath;
//	}
//
//	public void setPhotopath(String photopath) {
//		this.photopath = photopath;
//	}
//	
//	
//	
//
//}
