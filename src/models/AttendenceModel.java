//package models;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "attendence")
//public class AttendenceModel {
//	
//	private String username;
//	private Integer numoftodayentries;
//	private Integer numofcurrentmonthentries;
//	private Integer targetforthemonth;
//	private Integer targetachieved;
//	
//	
//	public AttendenceModel(String username,
//	 Integer numoftodayentries,
//	 Integer numofcurrentmonthentries,
//	 Integer targetforthemonth,
//	 Integer targetachieved) {
//		this.username= username;
//		this.numoftodayentries=numoftodayentries;
//		this.numofcurrentmonthentries=numofcurrentmonthentries;
//		this.targetforthemonth=targetforthemonth;
//		this.targetachieved=targetachieved;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public Integer getNumoftodayentries() {
//		return numoftodayentries;
//	}
//	public void setNumoftodayentries(Integer numoftodayentries) {
//		this.numoftodayentries = numoftodayentries;
//	}
//	public Integer getNumofcurrentmonthentries() {
//		return numofcurrentmonthentries;
//	}
//	public void setNumofcurrentmonthentries(Integer numofcurrentmonthentries) {
//		this.numofcurrentmonthentries = numofcurrentmonthentries;
//	}
//	public Integer getTargetforthemonth() {
//		return targetforthemonth;
//	}
//	public void setTargetforthemonth(Integer targetforthemonth) {
//		this.targetforthemonth = targetforthemonth;
//	}
//	public Integer getTargetachieved() {
//		return targetachieved;
//	}
//	public void setTargetachieved(Integer targetachieved) {
//		this.targetachieved = targetachieved;
//	}
//	
//
//}
