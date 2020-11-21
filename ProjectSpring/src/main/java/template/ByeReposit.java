package template;

import org.springframework.stereotype.Repository;

@Repository
public class ByeReposit implements IHiReposit{
	
	@Override
	public String sayHi(String name) {
		return name+"님 안녕하세요!(MSQL)";
	}

}

