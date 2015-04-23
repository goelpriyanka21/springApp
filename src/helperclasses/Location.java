package helperclasses;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

public class Location {

	private double longi;
	private double lat;
	
	
	public Location(double longi, double lat) {
		// TODO Auto-generated constructor stub
		this.setLongi(longi);
		this.setLat(lat);
	}
	public double getLongi() {
		return longi;
	}
	public void setLongi(double longi) {
		this.longi = longi;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	private JsonObject defineError(String name, String val){
		JsonObject o = new JsonObject();
		o.addProperty(name, val);
		return o;
	}
	
	public List<JsonObject> validate(Location other){
		List<JsonObject> errors = new ArrayList<>();
		
		if ((other == null) || Math.abs(lat - other.lat) > 0.01 || Math.abs(longi - other.longi) > 0.01){
			errors.add(defineError("selectedlocation", "selected location left blank or is not correct"));
		}
		
		return errors.size()>0?errors:null;
	}
}
