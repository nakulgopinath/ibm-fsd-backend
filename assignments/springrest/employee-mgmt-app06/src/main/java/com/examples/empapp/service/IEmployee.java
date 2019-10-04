package com.examples.empapp.service;

import java.util.ArrayList;

import com.examples.empapp.model.Employee;

public interface IEmployee {

	public boolean addEmployee(Employee epojo);
	public Employee viewEmployee(int id);
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(int id);
	public ArrayList<Employee> viewAllEmployee();
	public void importEmpl();
	public void exportEmpl();
	
	
}
