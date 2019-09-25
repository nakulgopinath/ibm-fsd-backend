package com.examples.empapp.dao;

import com.examples.empapp.model.Employee;

public interface IDao {
	
	public void addToDatabase(Employee epojo);
	public Employee viewEmployeeFromDatabase(int idtemp);
	public void updateEmployeeFromDatabase(int id);
	public void deleteEmployeeFromDatabase(int id);
	public void importToDatabase(Employee epojo);
	public String exportToDatabase();
}
