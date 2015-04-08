package helperclasses;

import java.util.List;


public class SectionListOfFileNamePair {
	private String section;
	private List<String> photonamelist;
//	public MultipartFile file2;

	public SectionListOfFileNamePair(String section, List<String> photonamelist){
		this.setSection(section);
		this.setPhotonamelist(photonamelist);
		
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<String> getPhotonamelist() {
		return photonamelist;
	}

	public void setPhotonamelist(List<String> photonamelist) {
		this.photonamelist = photonamelist;
	}
	
//	public SectionListOfFilePair(String section, MultipartFile file2){
//		this.section=section;
//		
//		this.file2=  file2;
//		
//	}
	
	}