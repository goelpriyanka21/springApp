package forms;

import helperclasses.Location;



public class LogoutData {
	
    private String username;
    private String deviceId;
	private Location gpslocation;
	

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
    
    public LogoutData() {}

    public LogoutData(String username, String deviceId, Location gpslocation) {
        this.username = username;
        this.setGpslocation(gpslocation);
        this.setDeviceId(deviceId);
        
    }

   
	@Override
    public String toString() {
        return String.format(
                "User[ username='%s', password='%s']",
                username);
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

}
