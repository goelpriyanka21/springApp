package helperclasses;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SectionListOfFileNamePair {
	public String section;
	public List<String> photonamelist;
//	public MultipartFile file2;

	public SectionListOfFileNamePair(String section, List<String> photoname){
		this.section=section;
		this.photonamelist=photoname;
		
	}
	
//	public SectionListOfFilePair(String section, MultipartFile file2){
//		this.section=section;
//		
//		this.file2=  file2;
//		
//	}
	
	}