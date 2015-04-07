package validators;

public class AuthenticationDetailsValidator {

	public static boolean validatedeviceId(String actualdeviceId, String receiveddeviceId) {
		// TODO Auto-generated method stub
		if (actualdeviceId.equals(receiveddeviceId)) return true;
		return false;
	}
	
	public static boolean validatepassword(String actualpassword, String receivedpassword) {
		// TODO Auto-generated method stub
		if (actualpassword.equals(receivedpassword)) return true;
		return false;
	}


}
