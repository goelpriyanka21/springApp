package forms;

import helperclasses.*;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PGAndTenantData {
	// GET must
	@NotNull
	private String username;
	@NotNull
	@Size(min = 2, max = 30)
	private String DeviceId;
	@NotNull
	private Location gpslocation;
	@NotNull
	private String token;
	@NotNull
	private String propertyId;
	
	@Valid
	private PGData pgdata;

	private List<TenantData> pgtenantlist;

	// POST
	private String status;
	private String message;
	private List<String> errorfieldandstring;
	
	
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
		this.gpslocation = gpslocation;
		this.DeviceId = DeviceId;
		this.token = token;
		this.propertyId = propertyId;
		this.setPgdata(pgdata);
		this.pgtenantlist = pgtenantlist;

	}

	public PGAndTenantData(String username) {
		this.username = username;
	}

	public PGAndTenantData(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.setStatus(string);
		this.setMessage(string2);
	}
	
	public PGAndTenantData(String string, String string2,
			List<String> errorfieldandstring) {
		// TODO Auto-generated constructor stub
		this.setStatus(string);
		this.setMessage(string2);
		this.errorfieldandstring= errorfieldandstring;
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
		return gpslocation;
	}

	public void setgpslocation(Location gpslocation) {
		this.gpslocation = gpslocation;
	}

	public void setusername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PGData getPgdata() {
		return pgdata;
	}

	public void setPgdata(PGData pgdata) {
		this.pgdata = pgdata;
	}

	// public List<RatingAndListOfEs> getTypesandavailability() {
	// return typesandavailability;
	// }
	//
	// public void setTypesandavailability(List<RatingAndListOfEs>
	// typesandavailability) {
	// this.typesandavailability = typesandavailability;
	// }

	// public ServiceAvailable getServiceavailable() {
	// return serviceavailable;
	// }
	//
	// public void setServiceavailable(ServiceAvailable serviceavailable) {
	// this.serviceavailable = serviceavailable;
	// }
	//
	// public FoodDetails getFooddetails() {
	// return fooddetails;
	// }
	//
	// public void setFooddetails(FoodDetails fooddetails) {
	// this.fooddetails = fooddetails;
	// }

	// public List<String> getRestrictions() {
	// return restrictions;
	// }
	//
	// public void setRestrictions(List<String> restrictions) {
	// this.restrictions = restrictions;
	// }

	// public ChargedAmenities getChargedamenities() {
	// return chargedamenities;
	// }
	//
	// public void setChargedamenities(ChargedAmenities chargedamenities) {
	// this.chargedamenities = chargedamenities;
	// }

	// public List<SectionFilePair> getPicture() {
	// return picturelist;
	// }
	//
	// public void setPicturelist(List<SectionFilePair> picture) {
	// this.picturelist = picture;
	// }

}
