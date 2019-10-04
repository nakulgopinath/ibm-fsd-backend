package com.examples.empapp.service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.model.Employee;

public class EmployeeService implements IEmployee {

	@Autowired
	EmployeeDao empDao;
	Scanner sc = new Scanner(System.in);
	HashMap<Integer,Employee> eMap=new HashMap<Integer,Employee>();
	
	
	@Override
	public boolean addEmployee(Employee epojo) {
//		eMap.put(epojo.getId(),epojo);
		boolean status =empDao.addToDatabase(epojo);
		return status;
	}
	
	@Override
	public Employee viewEmployee(int id){
		
		Employee e =empDao.viewEmployeeFromDatabase(id);
		
		 

		return e;
	}
	@Override
	public boolean updateEmployee(Employee emp){

		boolean status=empDao.updateEmployeeFromDatabase(emp);
		return status;

		
	}
	
	@Override
	public boolean deleteEmployee(int id){

		
		boolean status = empDao.deleteEmployeeFromDatabase(id);
		return status;
	}	
			
	
	
	@Override
	public ArrayList<Employee>viewAllEmployee(){
		
		ArrayList<Employee> eArr=empDao.viewAllEmployeeFromDatabase();

		return eArr;
	}
	
	
	@Override
	
	public void importEmpl() 
	{
		
		System.out.println("Hi");
         
		try {
            sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\NakulGNair\\Desktop\\FSD\\Trainer-4\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\src\\Employee.txt"))));
			
            while (sc.hasNextLine()) {
            	
            	String [] arr= sc.nextLine().split(",");
            	Employee epojo=new Employee();
            	

            	
            	
                epojo.setId(Integer.parseInt(arr[0]));
                epojo.setName(arr[1]);
                epojo.setDesignation((arr[2]));
                epojo.setCountry((arr[3]));
                

                empDao.importToDatabase(epojo);
            }
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		finally {
            if (sc != null) {
                sc.close();
            }
	}
	}
	
	
	
	public void exportEmpl()
	{

		
		

		try {
			
			File fout = new File("C:\\Users\\NakulGNair\\Desktop\\FSD\\Trainer-4\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app02\\src\\EmployeeExport.txt");
			FileOutputStream fos = new FileOutputStream(fout);
		 


		String result	=empDao.exportToDatabase();
		fos.write(result.getBytes());
		fos.close();
		}
		
		
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		
	}
	
	
	
}


