package com.smn.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.smn.dto.EmployeeDTO;
import com.smn.service.EmpService;

@SpringBootApplication
@ComponentScan(basePackages={"com.smn.service","com.smn.dao"})
public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(App.class, args);
		EmpService empService = ctx.getBean("empService",EmpService.class);
		System.out.println("Employees Count = "+empService.getEmpCount());
		List<EmployeeDTO> list = empService.getEmployeeDetailsbyDesig("LEAD");
		if(list !=null && !list.isEmpty()){
			for (EmployeeDTO employeeBO : list) {
				System.out.println(employeeBO.toString());
			}
		}
		((ConfigurableApplicationContext) ctx).close();
	}
}
