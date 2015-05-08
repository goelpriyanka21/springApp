package forms;

import helperclasses.Location;
import helperclasses.MyAnnotation;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

public class PGAndTenantData {

	private String username;

	@MyAnnotation(name = "gpsLocation", value = "Please provide gps location")
	private Location gpsLocation;

	@MyAnnotation(name = "DeviceId", value = "Please provide deviceId")
	private String DeviceId;

	@MyAnnotation(name = "propertyId", value = "PropertyId can't be blank & should be exactly 16 digits ")
	private String propertyId;

	private String token;

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

	private JsonObject defineError(String name) {
		MyAnnotation ann = getAnnotation(name);
		JsonObject o = new JsonObject();
		o.addProperty(ann.name(), ann.value());
		return o;
	}

	private MyAnnotation getAnnotation(String name) {
		MyAnnotation ann = null;
		try {
			ann = PGAndTenantData.class.getDeclaredField(name).getAnnotation(
					MyAnnotation.class);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ann;
	}

	public List<JsonObject> validate() {
		List<JsonObject> errors = new ArrayList<>();

		if (gpsLocation == null) {
			errors.add(defineError("gpsLocation"));
		}

		if (DeviceId == null) {
			errors.add(defineError("DeviceId"));
		}

		if ((propertyId == null) || (propertyId.length() != 16)) {
			errors.add(defineError("propertyId"));
		}

		if (pgdata != null) {
			List<JsonObject> pgDataErrors = pgdata.validate();
			if (pgDataErrors != null) {
				errors.addAll(pgDataErrors);
			}

//			List<JsonObject> locationErrors = gpsLocation.validate(pgdata
//					.getSelectedLocation());
//			if (locationErrors != null) {
//				errors.addAll(locationErrors);
//			}
		}

		if (pgtenantlist != null) {
			for (TenantData tenantdata : pgtenantlist) {
				List<JsonObject> tenantErrors = tenantdata.validate();
				if (tenantErrors != null) {
					errors.addAll(tenantErrors);
				}
			}
		}

		return errors.size() > 0 ? errors : null;

	}
}