package helperclasses;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SectionListOfFilePair {
	public String section;
	public List<File> file;
	public MultipartFile file2;

	public SectionListOfFilePair(String section, List<File> file){
		this.section=section;
		this.file=file;
		
	}
	
	public SectionListOfFilePair(String section, MultipartFile file2){
		this.section=section;
		
		this.file2=  file2;
		
	}
	
	}