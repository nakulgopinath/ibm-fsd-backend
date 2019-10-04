package com.examples.empapp.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@Autowired
	Employee employee;
	
	
	
//	@RequestMapping(method = RequestMethod.GET) this can be done using @GetMapping
	@GetMapping
	public ArrayList<Employee> getEmployees(){
		
		return empService.viewAllEmployee();
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE} )
	
	public String addEmployee(@RequestBody Employee employee)
	{
		
		
		boolean status= empService.addEmployee(employee);
		return status ? "Employee creted Succesfully":"Employee creation failed";
	}
	
	@GetMapping("/{id}" ) 
	public Employee getEmployeeById(@PathVariable int id)
	{
		return empService.viewEmployee(id);
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable int id,@RequestBody Employee updatedEmp) {
		updatedEmp.setId(id);
		
		boolean status=empService.updateEmployee(updatedEmp);
		return status ? "Employee deleted Succesfully":"Employee deletion failed";
	}
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		boolean status=empService.deleteEmployee(id);
		return status ? "Employee deleted Succesfully":"Employee deletion failed";
	}
	
}
