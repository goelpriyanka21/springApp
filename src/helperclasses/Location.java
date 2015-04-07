package helperclasses;

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
	

}
