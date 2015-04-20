package models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testingdata")
public class TestingData {
	Object obj;
	Date testeddate;
	
	public TestingData(Object obj){
		this.obj= obj;
		this.testeddate = new Date();
		
	}

}
