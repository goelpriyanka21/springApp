package validators;

import helperclasses.ErrorFieldAndMessage;

import helperclasses.SharingTypeRentbedsCombo;

import java.util.ArrayList;
import java.util.List;

import forms.PGAndTenantData;
import forms.TenantData;

public class PGandTenantDataValidator {

	public static List<ErrorFieldAndMessage> validate(
			PGAndTenantData pgAndTenantData) {
		// TODO Auto-generated method stub
		List<ErrorFieldAndMessage> errorfieldandstringlist = new ArrayList<>();

		if (pgAndTenantData.getUsername() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("username",
					"username can't be left blank"));
//		if (pgAndTenantData.getGpslocation() == null)
//			errorfieldandstringlist.add(new ErrorFieldAndMessage("gpslocation",
//					"Please provide gps location"));
		if (pgAndTenantData.getDeviceId() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("DeviceId",
					"Please provide DeviceId"));
		if (pgAndTenantData.getToken() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("token",
					"Please provide token provided to you"));
		if (pgAndTenantData.getPropertyId() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("propertyId",
					"Please provide PropertyId"));
		if (pgAndTenantData.getPgdata().getPicturelist().size() == 0)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("picturelist",
					"Please provide Picture list"));
//		else {
//			int photocount = 0;
//			for (SectionListOfFileNamePair sectionListOfFileNamePair : pgAndTenantData
//					.getPgdata().getPicturelist()) {
//				photocount += sectionListOfFileNamePair.photonamelist.size();
//
//				if (photocount < 5)
//					errorfieldandstringlist
//							.add(new ErrorFieldAndMessage("picturelist",
//									"picture list should contain at least 5 photo names"));
//			}
//		}

		if (pgAndTenantData.getPgdata().getPgName() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("pgName",
					"Please provide PgName"));
		if (pgAndTenantData.getPgdata().getPgName().length() < 2
				|| pgAndTenantData.getPgdata().getPgName().length() > 50)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("pgName",
					"PG name cant be less than 2 or more than 50 characters"));
		if (pgAndTenantData.getPgdata().getBuildingname().length() > 50)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingname",
					"buildingname name cant be more than 50 characters"));
		if (pgAndTenantData.getPgdata().getAddressl1() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("addressl1",
					"Address Line 1 can't be left blank"));
		if (pgAndTenantData.getPgdata().getAddressl1().length() > 100)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("addressl1",
					"addressl1 name cant be more than 100 characters"));
		if (pgAndTenantData.getPgdata().getAddressl2() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("addressl2",
					"Address Line 2 can't be left blank"));
		if (pgAndTenantData.getPgdata().getAddressl2().length() > 100)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("addressl2",
					"addressl2 name cant be more than 100 characters"));
		if (pgAndTenantData.getPgdata().getPincode() == 0)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("pincode",
					"Pincode can't be left blank"));
		if (pgAndTenantData.getPgdata().getPincode() > 999999)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("pincode",
					"Pincode can't be more than 6 digits"));
		if (pgAndTenantData.getPgdata().getLandmark().length() > 100)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("landmark",
					"landmark cant be more than 100 characters"));
		// TODO null check for below list
		if (pgAndTenantData.getPgdata().getAvailableFor().size() == 0)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"availableFor", "availableFor can't be left blank"));

		if (pgAndTenantData.getPgdata().getStdprofper().getstudper()
				+ pgAndTenantData.getPgdata().getStdprofper().getprofper() != 100) {
			errorfieldandstringlist.add(new ErrorFieldAndMessage("stdprofper",
					"student and professional percentage sum not making 100"));
		}
		if (pgAndTenantData.getPgdata().getTypeofprofessional().length() > 200)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"typeofprofessional",
					"typeofprofessional cant be more than 100 characters"));

//		if (pgAndTenantData.getPgdata().getAgeband().getminlimit() > pgAndTenantData
//				.getPgdata().getAgeband().getmaxlimit())
//			errorfieldandstringlist.add(new ErrorFieldAndMessage("ageBand",
//					"min age limit should be less than age max limit"));
		if (pgAndTenantData.getPgdata().getTypesandavailability()
				.getAlldetails().size() > 7)
			errorfieldandstringlist
					.add(new ErrorFieldAndMessage("typesandavailability",
							"typesandavailability should not contain more than 7 items"));
		int bedcount = 0;
		for (SharingTypeRentbedsCombo sharingTypeRentbedsCombo : pgAndTenantData
				.getPgdata().getTypesandavailability().getAlldetails())
			bedcount += sharingTypeRentbedsCombo.getBedsavailable();
		if (bedcount > 100)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"typesandavailability",
					"bed count should not be more than 100"));
		if (pgAndTenantData.getPgdata().getSelectedlocation() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"selectedlocation", "Please select a location fro pg"));
		// if ((Math.abs(pgAndTenantData.getgpslocation().getLat()
		// - pgAndTenantData.getPgdata().getselectedlocation().getLat()) > 0.01)
		// || (Math.abs(pgAndTenantData.getgpslocation().getLongi()
		// - pgAndTenantData.getPgdata().getselectedlocation()
		// .getLongi()) > 0.01))
		// errorfieldandstringlist.add(new ErrorFieldAndMessage("gpsLocation",
		// "please select correct location of yours"));

		for (TenantData tenantdata : pgAndTenantData.getpgtenantlist()) {
			if (tenantdata.getTenantname() == null)
				errorfieldandstringlist.add(new ErrorFieldAndMessage(
						"pgtenantlist", "tenant name can't be left blank"));
			if (tenantdata.getContact() == null)
				errorfieldandstringlist.add(new ErrorFieldAndMessage("contact",
						"tenant cntact can't be left blank"));
			if (tenantdata.getEmailId() == null)
				errorfieldandstringlist.add(new ErrorFieldAndMessage("emailId",
						"tenant emailId can't be left blank"));
			if (tenantdata.getAge() == 0 || tenantdata.getAge() < 10
					|| tenantdata.getAge() > 99)
				errorfieldandstringlist
						.add(new ErrorFieldAndMessage("age",
								"tenant age can't be left blank and should be a two digit number"));
		}

		return errorfieldandstringlist;
	}

}
