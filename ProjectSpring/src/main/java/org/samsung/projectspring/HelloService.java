package org.samsung.projectspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	@Autowired
	@Qualifier("byeRepository")
	IHelloRepository helloRepository;
	
	
	public String sayHello(String name) {
		return helloRepository.sayHello(name);
	}
	
}

