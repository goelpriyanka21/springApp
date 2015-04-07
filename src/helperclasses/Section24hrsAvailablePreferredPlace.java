package helperclasses;

public class Section24hrsAvailablePreferredPlace {

	private String section;
	private Boolean _24HrsAvailable;
	private String preferredPlace;

	public Section24hrsAvailablePreferredPlace(){
		
	}
	
	public Section24hrsAvailablePreferredPlace(String section,
			Boolean _24HrsAvailable, String preferredPlace) {
		// TODO Auto-generated constructor stub
		this.section = section;
		this._24HrsAvailable = _24HrsAvailable;
		this.preferredPlace = preferredPlace;
	}

	public Section24hrsAvailablePreferredPlace(String section,
			String preferredPlace) {
		// TODO Auto-generated constructor stub
		this.section = section;
		this.preferredPlace = preferredPlace;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Boolean get_24HrsAvaialble() {
		return _24HrsAvailable;
	}

	public void set_24HrsAvaialble(Boolean _24HrsAvaialble) {
		this._24HrsAvailable = _24HrsAvaialble;
	}

	public String getPreferredPlace() {
		return preferredPlace;
	}

	public void setPreferredPlace(String preferredPlace) {
		this.preferredPlace = preferredPlace;
	}

}
