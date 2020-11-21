package org.samsung.projectspring.emp.main;

import org.samsung.projectspring.emp.model.vo.IEmpService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext con = new GenericXmlApplicationContext("app.xml");
		IEmpService empService = con.getBean(IEmpService.class);
		System.out.println("사원의 수: "+empService.getEmpCount());
		System.out.println("사원목록");
		System.out.println(empService.getEmpList());
		System.out.println(empService.getAllManagerId());
		con.close();
	}
}



