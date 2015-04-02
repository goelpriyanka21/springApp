package springapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.data.annotation.Id;

@Controller
public class HelloController {


	
    @RequestMapping(value="/test", method=RequestMethod.POST)

    public @ResponseBody String testGet(@RequestParam String id, @RequestParam String name, @RequestParam String thanks) {
    	
    	return( "Hey "+name+" Your Id is " +id+ " And It worked! Thanks "+thanks+" ");
    }

    
}