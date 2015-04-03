package validators;

import java.util.ArrayList;
import java.util.List;

import forms.PGAndTenantData;

public class PGandTenantDataValidator {

	public static List<String> validate(PGAndTenantData pgAndTenantData) {
		// TODO Auto-generated method stub
		List<String> errorfieldandstring= new ArrayList<>();
		
		if(pgAndTenantData.getUsername()==null) errorfieldandstring.add("Please provide username");
		if(pgAndTenantData.getDeviceId()==null || pgAndTenantData.getDeviceId().length()<2 || pgAndTenantData.getDeviceId().length()>30) errorfieldandstring.add("Either DeviceId is not filled or its length is not acceptable");
		if(pgAndTenantData.getPgdata().getStdprofper().getstudper()+ pgAndTenantData.getPgdata().getStdprofper().getprofper()!= 100) {
	          errorfieldandstring.add("student and professional percentage sum not making 100");
	      }
		
		if(pgAndTenantData.getPgdata().getAgeband().getminlimit()>pgAndTenantData.getPgdata().getAgeband().getmaxlimit())
			errorfieldandstring.add("min age limit should be less than age max limit");
		if(Math.abs(pgAndTenantData.getgpslocation().getLat()-pgAndTenantData.getPgdata().getselectedlocation().getLat())>0.01)
			errorfieldandstring.add("please select correct location of yours");
		if(Math.abs(pgAndTenantData.getgpslocation().getLongi()-pgAndTenantData.getPgdata().getselectedlocation().getLongi())>0.01)
			errorfieldandstring.add("please select correct location of yours");
		return errorfieldandstring;
	}

}
