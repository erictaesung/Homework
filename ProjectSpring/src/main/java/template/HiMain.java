package template;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HiMain {

		public static void main(String[] args) {
			AbstractApplicationContext con = new GenericXmlApplicationContext("app.xml");
			HiController hiController = con.getBean(HiController.class);
			hiController.sayHi("Eric");
		}
}

