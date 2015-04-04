package forms;

import java.util.List;

import helperclasses.ErrorFieldAndMessage;
import helperclasses.Location;

public class BuildingAndFlatData {
	
	private String username;
	private Location gpslocation;
	private String deviceId;
	private String token;
	private String propertyId;

	private BuildingData buildingData;

	private List<FlatData> flatData;

	public BuildingAndFlatData(String username, String DeviceId,
			Location gpslocation, String token, String propertyId,
			BuildingData buildingData, List<FlatData> flatData) {
		this.username = username;
		this.gpslocation = gpslocation;
		this.deviceId = DeviceId;
		this.token = token;
		this.propertyId = propertyId;
		this.buildingData = buildingData;
		this.flatData = flatData;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Location getGpslocation() {
		return gpslocation;
	}

	public void setGpslocation(Location gpslocation) {
		this.gpslocation = gpslocation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public BuildingData getBuildingData() {
		return buildingData;
	}

	public void setBuildingData(BuildingData buildingData) {
		this.buildingData = buildingData;
	}

	public List<FlatData> getFlatData() {
		return flatData;
	}

	public void setFlatData(List<FlatData> flatData) {
		this.flatData = flatData;
	}

}
