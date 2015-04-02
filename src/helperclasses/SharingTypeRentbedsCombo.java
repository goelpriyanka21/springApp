package helperclasses;

import javax.validation.constraints.Max;

public class SharingTypeRentbedsCombo {
	public SharingTypeRentbedsCombo(String string, int i, int j) {
		this.sharingtype= string;
		this.rent=i;
		this.bedsavailable=j;
		// TODO Auto-generated constructor stub
	}
	String sharingtype;
	int rent;
	@Max(100)
	int bedsavailable;
}
