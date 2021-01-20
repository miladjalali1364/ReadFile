package Read.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Print {

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String Page() {
		
		return "Hello";
	}
	
}
