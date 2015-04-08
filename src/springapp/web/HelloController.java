package springapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {


	
    @RequestMapping(value="/test", method=RequestMethod.POST)

    public @ResponseBody String testGet(@RequestParam String yourid, @RequestParam String name, @RequestParam String thanks) {
    	
    	return( "Hey "+name+" YourId is " +yourid+ " And It worked! Thanks "+thanks+" ");
    }

    
}