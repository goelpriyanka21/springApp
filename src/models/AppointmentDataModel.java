package models;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import forms.AppointmentData;

@Document(collection = "appointmentDetails")
public class AppointmentDataModel {

	private String username;
	private List<AppointmentData> appointmentList;

	public AppointmentDataModel(String username,
			List<AppointmentData> appointmentList) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.appointmentList = appointmentList;
	}

	public List<AppointmentData> getAppointmentList() {
		return appointmentList;
	}

	public List<AppointmentData> getSortedOrderList(){
		AppointmentData[] appData = new AppointmentData[appointmentList.size()];
		appData = appointmentList.toArray(appData);
		Arrays.sort(appData);
		return Arrays.asList(appData);
	}
	
	public void setAppointmentList(List<AppointmentData> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
