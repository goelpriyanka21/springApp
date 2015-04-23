package forms;

import helperclasses.Location;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

public class PGAndTenantData {

	private String username;
	private Location gpsLocation;
	private String DeviceId;
	private String token;

	private String propertyId;

	private PGData pgdata;

	private List<TenantData> pgtenantlist;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}

	public Location getGpslocation() {
		return gpsLocation;
	}

	public void setGpslocation(Location gpslocation) {
		this.gpsLocation = gpslocation;
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

	public List<TenantData> getPgtenantlist() {
		return pgtenantlist;
	}

	public void setPgtenantlist(List<TenantData> pgtenantlist) {
		this.pgtenantlist = pgtenantlist;
	}

	/** Required for form instantiation. */
	public PGAndTenantData(String username, String DeviceId,
			Location gpslocation, String token, String propertyId,
			PGData pgdata, List<TenantData> pgtenantlist) {
		this.username = username;
		this.gpsLocation = gpslocation;
		this.DeviceId = DeviceId;
		this.token = token;
		this.propertyId = propertyId;
		this.setPgdata(pgdata);
		this.pgtenantlist = pgtenantlist;

	}

	public PGAndTenantData(String username) {
		this.username = username;
	}

	public String getpropertyId() {
		return propertyId;
	}

	public void setpropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public Location getgpslocation() {
		return gpsLocation;
	}

	public void setgpslocation(Location gpslocation) {
		this.gpsLocation = gpslocation;
	}

	public void setusername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}

	public PGData getPgdata() {
		return pgdata;
	}

	public void setPgdata(PGData pgdata) {
		this.pgdata = pgdata;
	}

	private JsonObject defineError(String name, String val) {
		JsonObject o = new JsonObject();
		o.addProperty(name, val);
		return o;
	}

	public List<JsonObject> validate() {
		List<JsonObject> errors = new ArrayList<>();

		if (gpsLocation == null) {
			errors.add(defineError("gpsLocation",
					PGAndTenantDataErrMsgs.GPS_ERR));
		}

		if (DeviceId == null) {
			errors.add(defineError("DeviceId",
					PGAndTenantDataErrMsgs.DEVICE_ID_ERR));
		}

		if ((propertyId == null) || (propertyId.length() != 16)) {
			errors.add(defineError("propertyId",
					PGAndTenantDataErrMsgs.PROPERTY_ID_ERR));
		}

		List<JsonObject> pgDataErrors = pgdata.validate();
		if (pgDataErrors != null) {
			errors.addAll(pgDataErrors);
		}

		List<JsonObject> locationErrors = gpsLocation.validate(pgdata
				.getSelectedLocation());
		if (locationErrors != null) {
			errors.addAll(locationErrors);
		}

		for (TenantData tenantdata : pgtenantlist) {
			List<JsonObject> tenantErrors = tenantdata.validate();
			if (tenantErrors != null) {
				errors.addAll(tenantErrors);
			}
		}

		return errors.size() > 0 ? errors : null;

	}
}

class PGAndTenantDataErrMsgs {

	static final String GPS_ERR = "Please provide gps location";
	static final String DEVICE_ID_ERR = "Please provide deviceId";
	static final String PROPERTY_ID_ERR = "PropertyId can't be blank & should be exactly 16 digits ";
}
