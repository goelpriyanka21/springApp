package helperclasses;


public class SharingTypeRentbedsCombo {
	
	String sharingtype;
	int rent;
	int bedsavailable;
	
	public SharingTypeRentbedsCombo(String sharingtype, int rent, int bedsavailable) {
		this.sharingtype= sharingtype;
		this.rent=rent;
		this.bedsavailable=bedsavailable;
		// TODO Auto-generated constructor stub
	}
	
	public String getSharingtype() {
		return sharingtype;
	}

	public void setSharingtype(String sharingtype) {
		this.sharingtype = sharingtype;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getBedsavailable() {
		return bedsavailable;
	}

	public void setBedsavailable(int bedsavailable) {
		this.bedsavailable = bedsavailable;
	}
	
}
