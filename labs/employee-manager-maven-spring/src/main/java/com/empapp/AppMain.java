package com.empapp;
import com.configuration.*;
import com.employee.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

	public AppMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		
		Employee emp = (Employee) context.getBean("employee");
		
		System.out.println("EmpID:"+emp.getId());
		System.out.println("Name:"+emp.getName());
		System.out.print("Address:"+emp.getAddress().getStreet()+",");
		System.out.print(emp.getAddress().getCity()+",");
		System.out.print(emp.getAddress().getCountry()+",");
		System.out.println(emp.getAddress().getPinCode()+".");
		System.out.println("DOJ:"+emp.getDate());
		System.out.println("Skills:"+emp.getSkills());
		System.out.println("Active:"+emp.isActive());
	}

}
