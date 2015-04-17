package springapp.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.GsonBuilder;


class TestData{
	public TestData(Integer i) {
		// TODO Auto-generated constructor stub
		this.a=i;
	}

	Integer a;
}

@Controller
public class TestDataJson {

	@RequestMapping(value = "/testingdatatype", method = RequestMethod.POST)
	public @ResponseBody int addEntry(@RequestBody TestData testdata)
			throws Exception {
		
		return testdata.a;
	}
}

//public class TestDataJson{
//	public static void main(String[] args){
//		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(new TestData(1)));
//	}
//}