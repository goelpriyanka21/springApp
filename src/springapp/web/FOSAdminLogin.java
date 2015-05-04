package springapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FOSAdminLogin {

	@RequestMapping(value = "/fosadminlogin", method = RequestMethod.GET)
	public @ResponseBody String foslogin(
			) throws Exception {
//		@RequestParam("fosadmin_username") String fosadmin_username, @RequestParam("fosadmin_password") String fosadmin_password
				return "/foslogin.html";
	}

}
