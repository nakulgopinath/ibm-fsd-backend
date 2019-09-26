package com.examples.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Greetings greetings =new Greetings();
//		System.out.println(greetings.getMessage());
		
		//Step 1 : Create Spring IOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
		
		System.out.println(context);
		System.out.println(context.getBeanDefinitionCount());
		
		//Step 2 : Access Greetings bean from container
		Greetings greetings = (Greetings)context.getBean("greetings1"); //Any name can be given for getBeans but it must be same as the id in cofig file
		
		//Step 3 : Print Greeting Message
		System.out.println(greetings.getMessage());
		
		greetings =(Greetings)context.getBean("greetings2");
		System.out.println(greetings.getMessage());
	}

}
