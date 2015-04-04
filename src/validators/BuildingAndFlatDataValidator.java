package validators;

import helperclasses.ErrorFieldAndMessage;
import java.util.ArrayList;
import java.util.List;

import forms.BuildingAndFlatData;
import forms.FlatData;

public class BuildingAndFlatDataValidator {

	public static List<ErrorFieldAndMessage> validate(
			BuildingAndFlatData buildingAndFlatData) {
		// TODO Auto-generated method stub
		List<ErrorFieldAndMessage> errorfieldandstringlist = new ArrayList<>();

		if (buildingAndFlatData.getUsername() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("username",
					"username can't be left blank"));
		// if (pgAndTenantData.getGpslocation() == null)
		// errorfieldandstringlist.add(new ErrorFieldAndMessage("gpslocation",
		// "Please provide gps location"));
		if (buildingAndFlatData.getDeviceId() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("DeviceId",
					"Please provide DeviceId"));
		if (buildingAndFlatData.getToken() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("token",
					"Please provide token provided to you"));
		if (buildingAndFlatData.getPropertyId() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("propertyId",
					"Please provide PropertyId"));
		if (buildingAndFlatData.getBuildingData().getPicturelist()==null || buildingAndFlatData.getBuildingData().getPicturelist().size() == 0)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("picturelist",
					"Please provide Picture list"));
//		 else {
		// int photocount = 0;
		// for (SectionListOfFileNamePair sectionListOfFileNamePair :
		// pgAndTenantData
		// .getPgdata().getPicturelist()) {
		// photocount += sectionListOfFileNamePair.photonamelist.size();
		//
		// if (photocount < 5)
		// errorfieldandstringlist
		// .add(new ErrorFieldAndMessage("picturelist",
		// "picture list should contain at least 5 photo names"));
		// }
		// }

		if (buildingAndFlatData.getBuildingData().getSocietyname() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("societyname",
					"Please provide Societyname"));
		if (buildingAndFlatData.getBuildingData().getSocietyname().length() < 2
				|| buildingAndFlatData.getBuildingData().getSocietyname()
						.length() > 50)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("societyname",
					"societyname name cant be less than 2 or more than 50 characters"));
		if (buildingAndFlatData.getBuildingData().getBuildingname().length() > 50)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingname",
					"buildingname name cant be more than 50 characters"));
		if (buildingAndFlatData.getBuildingData().getAddressl1() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("addressl1",
					"Address Line 1 can't be left blank"));
		if (buildingAndFlatData.getBuildingData().getAddressl1().length() > 100)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("addressl1",
					"addressl1 name cant be more than 100 characters"));
		if (buildingAndFlatData.getBuildingData().getAddressl2() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("addressl2",
					"Address Line 2 can't be left blank"));
		if (buildingAndFlatData.getBuildingData().getAddressl2().length() > 100)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("addressl2",
					"addressl2 name cant be more than 100 characters"));
		if (buildingAndFlatData.getBuildingData().getPincode() == 0)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("pincode",
					"Pincode can't be left blank"));
		if (buildingAndFlatData.getBuildingData().getPincode() > 999999)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("pincode",
					"Pincode can't be more than 6 digits"));
		if (buildingAndFlatData.getBuildingData().getLandmark().length() > 100)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("landmark",
					"landmark cant be more than 100 characters"));
		if (buildingAndFlatData.getBuildingData().getAvailableFor().size() == 0)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"availableFor", "availableFor can't be left blank"));

		// if (pgAndTenantData.getPgdata().getAgeband().getminlimit() >
		// pgAndTenantData
		// .getPgdata().getAgeband().getmaxlimit())
		// errorfieldandstringlist.add(new ErrorFieldAndMessage("ageBand",
		// "min age limit should be less than age max limit"));
		if (buildingAndFlatData.getBuildingData().getTypesandavailability()
				.getAlldetails().size() > 7)
			errorfieldandstringlist
					.add(new ErrorFieldAndMessage("typesandavailability",
							"typesandavailability should not contain more than 7 items"));

		if (buildingAndFlatData.getBuildingData().getSelectedlocation() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"selectedlocation", "Please select a location fro pg"));
		// if ((Math.abs(pgAndTenantData.getgpslocation().getLat()
		// - pgAndTenantData.getPgdata().getselectedlocation().getLat()) > 0.01)
		// || (Math.abs(pgAndTenantData.getgpslocation().getLongi()
		// - pgAndTenantData.getPgdata().getselectedlocation()
		// .getLongi()) > 0.01))
		// errorfieldandstringlist.add(new ErrorFieldAndMessage("gpsLocation",
		// "please select correct location of yours"));

		for (FlatData flatdata : buildingAndFlatData.getFlatData()) {
			if (flatdata.getFlatnumber() == null)
				errorfieldandstringlist.add(new ErrorFieldAndMessage(
						"flatnumber", "flatnumber can't be left blank"));

		}

		return errorfieldandstringlist;
	}

}
