package validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import forms.PGAndTenantData;

public class AddNewPGDataValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return PGAndTenantData.class.equals(clazz);
	}


	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		PGAndTenantData addNewPGData = (PGAndTenantData) target;
		
		if(addNewPGData.getPgdata().getStdprofper().getstudper()+ addNewPGData.getPgdata().getStdprofper().getprofper()!= 100) {
	          errors.rejectValue("pgdata", "student and professional percentage sum not making 100");
	      }
		
		if(addNewPGData.getPgdata().getAgeband().getminlimit()>addNewPGData.getPgdata().getAgeband().getmaxlimit())
			errors.rejectValue("ageband", "min age limit should be less than age max limit");
		if(Math.abs(addNewPGData.getgpslocation().getLat()-addNewPGData.getPgdata().getselectedlocation().getLat())>0.01)
			errors.rejectValue("selectedlocation", "please select correct location of yours");
		if(Math.abs(addNewPGData.getgpslocation().getLongi()-addNewPGData.getPgdata().getselectedlocation().getLongi())>0.01)
			errors.rejectValue("selectedlocation", "please select correct location of yours");

	}

	// do "complex" validation here

}
