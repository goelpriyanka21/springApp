package springapp.web;

import javax.servlet.http.HttpServletResponse;

import helperclasses.XmlApplicationContext;
import models.AdminAuthenticationDetails;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FOSAdminLogin {

//	@RequestMapping(value = "/fosadminlogin", method = RequestMethod.GET)
//	public String foslogin() throws Exception {
//		return "redirect:/foslogin.jsp";
//	}

	@RequestMapping(value = "/fosadminloggedin", method = RequestMethod.POST)
	public @ResponseBody String fosadminloggedin(
			@RequestParam String fosadmin_username,
			@RequestParam String fosadmin_password,
			HttpServletResponse response) throws Exception {
		//
		MongoOperations mongoOperation = XmlApplicationContext.CONTEXT.getDB();

		AdminAuthenticationDetails adminAuthenticationDetails = mongoOperation
				.findOne(
						new Query(Criteria.where("fosadmin_username").is(
								fosadmin_username)),
						AdminAuthenticationDetails.class);

		if (adminAuthenticationDetails == null)
			return "Unauthorized login attempt (No such admin)";
		if (!adminAuthenticationDetails.getPassword().equals(fosadmin_password))
			return "Unauthorized login attempt (Invalid credentials)";
		
//		return "Will see";
//		return "redirect:/foslogin.jsp";
		response.sendRedirect("http://localhost:8080/dcapi/pages/fosoptions.jsp");
		return "";
//		return "http://localhost:8080/dcapi/pages/foslogin.jsp";

	}

}
