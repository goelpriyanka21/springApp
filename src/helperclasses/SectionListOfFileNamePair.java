package helperclasses;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SectionListOfFileNamePair {
	public String section;
	public List<String> photoname;
//	public MultipartFile file2;

	public SectionListOfFileNamePair(String section, List<String> photoname){
		this.section=section;
		this.photoname=photoname;
		
	}
	
//	public SectionListOfFilePair(String section, MultipartFile file2){
//		this.section=section;
//		
//		this.file2=  file2;
//		
//	}
	
	}