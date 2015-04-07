package forms;

import helperclasses.Location;

import org.springframework.data.annotation.Id;


public class LogoutData {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
    private String id;
//GET
    private String username;
    private String deviceId;
	private Location gpslocation;
	
	
    
    public LogoutData() {}

    public LogoutData(String username, String deviceId, Location gpslocation) {
        this.username = username;
        this.setGpslocation(gpslocation);
        this.setDeviceId(deviceId);
        
    }

   
	@Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', password='%s']",
                id, username);
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
