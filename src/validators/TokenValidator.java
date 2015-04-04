package validators;

public class TokenValidator {

	public static Boolean validate(String actualtoken, String receivedtoken) {
		
		// TODO Auto-generated method stub
		if (actualtoken.equals(receivedtoken)) return true;
		return false;
	}

}
