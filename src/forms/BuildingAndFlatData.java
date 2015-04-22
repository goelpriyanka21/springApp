package forms;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import helperclasses.Location;

public class BuildingAndFlatData {

	private String username;
	private Location gpslocation;
	private String deviceId;
	private String token;
	private String propertyId;

	private BuildingData buildingData;

	private List<FlatData> flatData;

	public BuildingAndFlatData(String username, String deviceId,
			Location gpslocation, String token, String propertyId,
			BuildingData buildingData, List<FlatData> flatData) {
		this.username = username;
		this.gpslocation = gpslocation;
		this.deviceId = deviceId;
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

	private JsonObject defineError(String name, String val) {
		JsonObject o = new JsonObject();
		o.addProperty(name, val);
		return o;
	}

	public List<JsonObject> validate() {
		// TODO Auto-generated method stub
		List<JsonObject> errors = new ArrayList<>();

		if (gpslocation == null) {
			errors.add(defineError("gpslocation",
					BuildingAndFlatDataErrMsgs.GPS_ERR));
		}

		if (deviceId == null) {
			errors.add(defineError("deviceId",
					BuildingAndFlatDataErrMsgs.DEVICE_ID_ERR));
		}
		
		if ((propertyId == null) || (propertyId.length() != 16)){
			errors.add(defineError("propertyId", BuildingAndFlatDataErrMsgs.PROPERTY_ID_ERR));
		}
		
		
		
		List<JsonObject> buildingDataErrors = buildingData.validate();
		if (buildingDataErrors != null){
			errors.addAll(buildingDataErrors);
		}
		
		List<JsonObject> locationErrors = gpslocation.validate(buildingData.getSelectedLocation());
		if (locationErrors != null){
			errors.addAll(locationErrors);
		}
		
		for (FlatData flat : flatData) {
			List<JsonObject> flatErrors = flat.validate();
			if (flatErrors != null){
				errors.addAll(flatErrors);
			}
		}

		return errors.size()>0?errors:null;
	}

}

class BuildingAndFlatDataErrMsgs {

	static final String GPS_ERR = "Please provide gps location";
	static final String DEVICE_ID_ERR = "Please provide deviceId";
	static final String PROPERTY_ID_ERR = "PropertyId can't be blank & should be exactly 16 digits ";
}