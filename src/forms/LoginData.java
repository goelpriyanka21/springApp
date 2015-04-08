package forms;

import helperclasses.Location;


public class LoginData {
	

	
//GET
    private String username;
    private String password;
    private Location gpslocation;
    private String deviceId;
	
	
    
    public LoginData() {}

    public LoginData(String username, String password,  String deviceId, Location gpslocation) {
        this.username = username;
        this.password = password;
        this.gpslocation = gpslocation;
        this.deviceId = deviceId;
        
    }
    
  

	@Override
    public String toString() {
        return String.format(
                "User[, username='%s', password='%s']",
                 username, password);
    }

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Location getGpslocation() {
		return gpslocation;
	}

	public void setGpslocation(Location gpslocation) {
		this.gpslocation = gpslocation;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


}
