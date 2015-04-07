package forms;

import helperclasses.*;

import java.util.List;

//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

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

	public List<TenantData> getpgtenantlist() {
		return pgtenantlist;
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

}
