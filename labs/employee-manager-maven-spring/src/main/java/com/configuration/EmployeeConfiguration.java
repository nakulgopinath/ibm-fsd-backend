package com.configuration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employee.Address;
import com.employee.Employee;

@Configuration
public class EmployeeConfiguration 
{
	@Bean
    public Employee employee() {
		List<String> skills=new ArrayList<String>();
		skills.add("C");
		skills.add("Python");
		skills.add("Java");
		
		LocalDate date = LocalDate.now();		
        return new Employee(100,"Piyush",address(),date,skills,true);
    }
    
    @Bean
    public Address address() {
        return new Address("Gandhi Street","Bengaluru","India",560102);
    }
}