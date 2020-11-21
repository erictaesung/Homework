package template;

import org.springframework.stereotype.Repository;

@Repository
public class HiReposit implements IHiReposit{

	public String sayHi(String name) {
		return name+"님 안녕하세요!(Oracle SQL)";
	}

}