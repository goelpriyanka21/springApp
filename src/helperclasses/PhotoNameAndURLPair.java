package helperclasses;

public class PhotoNameAndURLPair {
	private String photoname;
	private String url;

	public PhotoNameAndURLPair(String photoname) {
		// TODO Auto-generated constructor stub
		this.photoname = photoname;
		this.url = null;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}