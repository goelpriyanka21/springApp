package helperclasses;

import java.util.List;


public class SectionListOfPhotoNameAndURLPair {
	private String section;
	private List<PhotoNameAndURLPair> photonamelist;

	// public MultipartFile file2;

	public SectionListOfPhotoNameAndURLPair(String section,
			List<PhotoNameAndURLPair> photonamelist) {
		this.setSection(section);
		this.setPhotonamelist(photonamelist);

	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<PhotoNameAndURLPair> getPhotonamelist() {
		return photonamelist;
	}

	public void setPhotonamelist(List<PhotoNameAndURLPair> photonamelist) {
		this.photonamelist = photonamelist;
	}

	// public SectionListOfFilePair(String section, MultipartFile file2){
	// this.section=section;
	//
	// this.file2= file2;
	//
	// }

}