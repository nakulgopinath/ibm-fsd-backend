package com.examples.empapp.configuration;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.AbstractApplicationContext;

import com.examples.empapp.model.Employee;
import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.empmain.EmployeeMain;
import com.examples.empapp.service.EmployeeService;



@Configuration
public class EmployeeConfiguration 
{
	@Bean
	@Lazy
    public Employee employee() {
		
		
		return new Employee();
    }
	
//	@Bean
//	public EmployeeMain employeemain()
//	{
//		return new Employeemain();
//	}
	
	@Bean
	@Lazy
    public EmployeeService employeeservice() {
		
		
		return new EmployeeService();
    }
	
	@Bean
	@Lazy
	public EmployeeDao employeedao() {
		
		
		return new EmployeeDao();
    }
   
}