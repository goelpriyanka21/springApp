package springapp.web;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import forms.User;

//import org.springframework.context.support.GenericXmlApplicationContext;

@Controller
public class Application {

//	public static void main(String[] args) {
@RequestMapping(value="/db", method=RequestMethod.GET)

public @ResponseBody String testdb() throws Exception {

		// For XML
//		ApplicationContext ctx = new GenericXmlApplicationContext(
//				"/Users/priyanka/Documents/eclipse/springapp/war/WEB-INF/springapp-servlet.xml");
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"springapp-servlet.xml");
		

		// For Annotation
		// ApplicationContext ctx =
		// new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		User user = new User("priyanka", "password123");

		// save
		mongoOperation.save(user);

		// now user object got the created id.
		System.out.println("1. user : " + user);

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("username").is(
				"priyanka"));

		// find the saved user again.
		User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
		System.out.println("2. find - savedUser : " + savedUser);

		// update password
		mongoOperation.updateFirst(searchUserQuery,
				Update.update("password", "password456"), User.class);

		// find the updated user object
		User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);

		System.out.println("3. updatedUser : " + updatedUser);

		// delete
//		mongoOperation.remove(searchUserQuery, User.class);

		// List, it should be empty now.
		List<User> listUser = mongoOperation.findAll(User.class);
		System.out.println("4. Number of user = " + listUser.size());
		
		return("db experiment worked");

	}

}