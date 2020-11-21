package template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HiController {
	
	@Autowired
	HiService hiService;

	
	public void sayHi(String name) {
		System.out.println(hiService.sayHi(name));
	}
}



