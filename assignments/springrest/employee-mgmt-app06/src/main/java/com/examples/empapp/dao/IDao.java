package com.examples.empapp.dao;

import com.examples.empapp.model.Employee;

public interface IDao {
	
	public boolean addToDatabase(Employee epojo);
	public Employee viewEmployeeFromDatabase(int idtemp);
	public boolean updateEmployeeFromDatabase(Employee emp);
	public boolean deleteEmployeeFromDatabase(int id);
	public void importToDatabase(Employee epojo);
	public String exportToDatabase();
}
