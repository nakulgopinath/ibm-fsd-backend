package empapp;

import java.util.Scanner;

import model.Employee;
import service.EmployeeService;

import java.util.*;


public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		EmployeeService eimpl = new EmployeeService();
		
		
		
		
		int ch;
		do
		{
			System.out.println("1.Add Employee");
			System.out.println("2.View Employee");
			System.out.println("3.Update Employee");
			System.out.println("4.Delete Employee");
			System.out.println("5.View All Employee");
			System.out.println("6.Import");
			System.out.println("7.Export");

			System.out.println("8.Exit");
			System.out.println("Enter a choice");
			ch=sc.nextInt();
			
			switch(ch)
			{
			
			case 1:
				Employee epojo=new Employee();
				
				System.out.println("Enter Employee Id:");
				epojo.setId(sc.nextInt());
				
				System.out.println("Enter Employee Name:");
				epojo.setName(sc.next());
				
				System.out.println("Enter Employee Designation:");
				epojo.setDesignation(sc.next());
				
				System.out.println("Enter Employee Country:");
				epojo.setCountry(sc.next());	
				
			eimpl.addEmployee(epojo);
			break;
			
			case 2:
			System.out.println("Enter Employee ID:");	
			eimpl.viewEmployee(sc.nextInt());
			break;
			
			
			
			case 3:
			System.out.println("Enter Employee ID:");	
			eimpl.updateEmployee(sc.nextInt());
			break;
			
			case 4:
			System.out.println("Enter Employee ID:");	
			eimpl.deleteEmployee(sc.nextInt());
			break;
			
			case 5:	
			eimpl.viewAllEmployee();
			break;
			
			case 8:
			System.out.println("Program Terminated");
			break;
			
			case 6:
			eimpl.importEmpl();
			break;
			
			case 7:
			eimpl.exportEmpl();
			break;
			

			}
			
			
			
			
		}while(ch!=8);
		

	}

}
