package service;

import model.Employee;

public interface IEmployee {

	public void addEmployee(Employee epojo);
	public void viewEmployee(int id);
	public void updateEmployee(int id);
	public void deleteEmployee(int id);
	public void viewAllEmployee();
	public void importEmpl();
	public void exportEmpl();
	
	
}
