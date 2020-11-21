package template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HiService {
	
	@Autowired
	@Qualifier("byeReposit")
	IHiReposit hiReposit;
	
	
	public String sayHi(String name) {
		return hiReposit.sayHi(name);
	}
	
}

