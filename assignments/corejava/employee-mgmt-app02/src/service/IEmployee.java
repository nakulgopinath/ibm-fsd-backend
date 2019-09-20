package service;

import java.util.ArrayList;

import model.Employee;

public interface IEmployee {

	public void addEmployee(Employee epojo);
	public Employee viewEmployee(int id);
	public void updateEmployee(int id);
	public void deleteEmployee(int id);
	public ArrayList<Employee> viewAllEmployee();
	public void importEmpl();
	public void exportEmpl();
	
	
}
