package helperclasses;


public class SharingTypeRentbedsCombo {
	public SharingTypeRentbedsCombo(String string, int i, int j) {
		this.sharingtype= string;
		this.rent=i;
		this.bedsavailable=j;
		// TODO Auto-generated constructor stub
	}
	String sharingtype;
	int rent;
	
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
	int bedsavailable;
}
