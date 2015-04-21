package validators;

import helperclasses.ErrorFieldAndMessage;
import helperclasses.SectionListOfPhotoNameAndURLPair;

import java.util.ArrayList;
import java.util.List;

import forms.BuildingAndFlatData;
import forms.FlatData;

public class BuildingAndFlatDataValidator {

	public static List<ErrorFieldAndMessage> validate(
			BuildingAndFlatData buildingAndFlatData) {
		// TODO Auto-generated method stub
		List<ErrorFieldAndMessage> errorfieldandstringlist = new ArrayList<>();

		if (buildingAndFlatData.getGpslocation() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("gpslocation",
					"Please provide gps location"));

		if (buildingAndFlatData.getDeviceId() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("deviceId",
					"Please provide deviceId"));

		if (buildingAndFlatData.getPropertyId() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("propertyId",
					"Please provide PropertyId"));
		else if (buildingAndFlatData.getPropertyId().length() != 16)
			errorfieldandstringlist.add(new ErrorFieldAndMessage("propertyId",
					"PropertyId should be exactly 16 digits"));

		if (buildingAndFlatData.getBuildingData().getSocietyname() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.societyname", "Please provide societyname"));
		else if (buildingAndFlatData.getBuildingData().getSocietyname()
				.length() < 2
				|| buildingAndFlatData.getBuildingData().getSocietyname()
						.length() > 50)
			errorfieldandstringlist
					.add(new ErrorFieldAndMessage("buildingData.societyname",
							"societyname name cant be less than 2 or more than 50 characters"));

		if (buildingAndFlatData.getBuildingData().getPicturelist() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.picturelist",
					"Picture list can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getPicturelist().size() == 0)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.picturelist", "Picture list size can't be zero"));
		else {
			int photocount = 0;
			for (SectionListOfPhotoNameAndURLPair sectionListOfPhotoNameAndURLPair : buildingAndFlatData
					.getBuildingData().getPicturelist()) {
				photocount += sectionListOfPhotoNameAndURLPair
						.getPhotonamelist().size();
			}
			if (photocount < 5)
				errorfieldandstringlist.add(new ErrorFieldAndMessage(
						"buildingData.picturelist",
						"picture list should contain at least 5 photo names"));
		}
		

		if (buildingAndFlatData.getBuildingData().getBuildingname() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.buildingname",
					"buildingname name cant be left blank"));
		else if (buildingAndFlatData.getBuildingData().getBuildingname()
				.length() > 50)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.buildingname",
					"buildingname name cant be more than 50 characters"));

		if (buildingAndFlatData.getBuildingData().getAddressl1() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.addressl1",
					"First Line Address can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getAddressl1().length() > 200)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.addressl1",
					"First Line Address cant be more than 200 characters"));

		if (buildingAndFlatData.getBuildingData().getAddressl2() != null) {
			if (buildingAndFlatData.getBuildingData().getAddressl2().length() > 200)
				errorfieldandstringlist.add(new ErrorFieldAndMessage(
						"buildingData.addressl2",
						"Second Line Address cant be more than 200 characters"));
		}

		if (buildingAndFlatData.getBuildingData().getPincode() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.pincode", "Pincode can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getPincode() > 999999)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.pincode",
					"Pincode can't be more than 6 characters"));

		if (buildingAndFlatData.getBuildingData().getLandmark() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.landmark", "landmark cant be left blank"));
		else if (buildingAndFlatData.getBuildingData().getLandmark().length() > 200)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.landmark",
					"landmark cant be more than 200 characters"));

		if (buildingAndFlatData.getBuildingData().getRent() == null) {
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.rent", "rent can't be left blank"));
		} else if (buildingAndFlatData.getBuildingData().getRent()
				.getminlimit() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.rent", "rent minlimit can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getRent().getmaxlimit() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.rent", "rent maxlimit can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getRent().getminlimit() > buildingAndFlatData
				.getBuildingData().getRent().getmaxlimit())
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.rent",
					"rent minlimit can't be greater than maxlimit"));

		if (buildingAndFlatData.getBuildingData().getMaintainancecharge() == null) {
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.maintainancecharge",
					"maintainancecharge can't be left blank"));
		} else if (buildingAndFlatData.getBuildingData()
				.getMaintainancecharge().getminlimit() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.maintainancecharge",
					"maintainancecharge minlimit can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getMaintainancecharge()
				.getmaxlimit() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.maintainancecharge",
					"maintainancecharge maxlimit can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getMaintainancecharge()
				.getminlimit() > buildingAndFlatData.getBuildingData()
				.getMaintainancecharge().getmaxlimit())
			errorfieldandstringlist
					.add(new ErrorFieldAndMessage(
							"buildingData.maintainancecharge",
							"maintainancecharge minlimit can't be greater than maxlimit"));

		if (buildingAndFlatData.getBuildingData().getDepositamount() == null) {
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.depositamount",
					"depositamount can't be left blank"));
		} else if (buildingAndFlatData.getBuildingData().getDepositamount()
				.getminlimit() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.depositamount",
					"depositamount minlimit can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getDepositamount()
				.getmaxlimit() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.depositamount",
					"depositamount maxlimit can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getDepositamount()
				.getminlimit() > buildingAndFlatData.getBuildingData()
				.getDepositamount().getmaxlimit())
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.depositamount",
					"depositamount minlimit can't be greater than maxlimit"));

		if (buildingAndFlatData.getBuildingData().getAvailableFor() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.availableFor",
					"availableFor can't be left blank"));
		else if (buildingAndFlatData.getBuildingData().getAvailableFor().size() == 0)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.availableFor",
					"availableFor size can't be zero"));

		if (buildingAndFlatData.getBuildingData().getTypesandavailability() != null) {
			if (buildingAndFlatData.getBuildingData().getTypesandavailability()
					.getAlldetails().size() > 7)
				errorfieldandstringlist
						.add(new ErrorFieldAndMessage(
								"buildingData.typesandavailability",
								"typesandavailability should not contain more than 7 items"));
		}

		if (buildingAndFlatData.getBuildingData().getSelectedlocation() == null)
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.selectedlocation",
					"Please select a location for pg"));
		else if ((Math.abs(buildingAndFlatData.getGpslocation().getLat()
				- buildingAndFlatData.getBuildingData().getSelectedlocation()
						.getLat()) > 0.01)
				|| (Math.abs(buildingAndFlatData.getGpslocation().getLongi()
						- buildingAndFlatData.getBuildingData()
								.getSelectedlocation().getLongi()) > 0.01))
			errorfieldandstringlist.add(new ErrorFieldAndMessage(
					"buildingData.selectedlocation",
					"please select correct location of yours"));

		if (buildingAndFlatData.getFlatData() != null) {
			for (FlatData flatdata : buildingAndFlatData.getFlatData()) {

				if (flatdata.getFlatnumber() == null)
					errorfieldandstringlist.add(new ErrorFieldAndMessage(
							"flatData.flatnumber",
							"flatnumber can't be left blank"));

			}
		}

		return errorfieldandstringlist;
	}

}
