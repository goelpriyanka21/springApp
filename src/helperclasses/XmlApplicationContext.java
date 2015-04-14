package helperclasses;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public enum XmlApplicationContext {
	CONTEXT(new GenericXmlApplicationContext("springapp-servlet.xml"));

	private MongoOperations mongoOperation;

	private XmlApplicationContext(ApplicationContext context) {
		mongoOperation = (MongoOperations) context.getBean("mongoTemplate");
	}
	
	public MongoOperations getDB(){
		return mongoOperation;
	}

}
