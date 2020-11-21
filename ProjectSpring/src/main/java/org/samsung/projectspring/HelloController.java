package org.samsung.projectspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	@Autowired
	HelloService helloService;

	
	public void sayHello(String name) {
	
		System.out.println(helloService.sayHello(name));
		
	}
}



