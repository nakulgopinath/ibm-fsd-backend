package empapp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Employee;
import service.EmployeeService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;





public class EmployeeMain  {
	
	
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		EmployeeService eimpl = new EmployeeService();
		
		
		
		
		int ch=0;
		
		do
		{
			try {
			Scanner sc = new Scanner(System.in);
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
				
					
					try {
						eimpl.read(epojo);
						eimpl.addEmployee(epojo);
					}
					catch(InputMismatchException iME)
					{
						System.out.println("Please Enter a numeric Value");
					}
					
				break;
			
				case 2:
			
					try {
						System.out.println("Enter Employee ID:");	
		
						Employee e= eimpl.viewEmployee(sc.nextInt());
						eimpl.print(e);
						}
					catch(InputMismatchException iME1)
					{
						System.out.println("Please Enter a numeric Value");
					}
			
				break;
			
			
			
				case 3:
				
					try {
						System.out.println("Enter Employee ID:");	
						eimpl.updateEmployee(sc.nextInt());
						}
					catch(InputMismatchException iME1)
					{
						System.out.println("Please Enter a numeric Value");
					}
				
				break;
			
				case 4:
				
					try {
						System.out.println("Enter Employee ID:");	
						eimpl.deleteEmployee(sc.nextInt());
						}
					catch(InputMismatchException iME1)
					{
						System.out.println("Please Enter a numeric Value");
					}
				System.out.println("Enter Employee ID:");	
				
				break;
			
				case 5:	
				eimpl.viewAllEmployee();
				ArrayList<Employee> eList=new ArrayList<Employee>();
				eList= eimpl.viewAllEmployee();
				
				for(Employee e:eList)
					eimpl.print(e);
//				eimpl.print(e);
				break;
				
				case 8:
				System.out.println("Program Terminated");
				break;
			
			
				case 6:
				{

				class Sample implements Callable<String>
				{
					
					public String call() throws Exception 
					{
						
						
						eimpl.importEmpl();
				
						return "Import Completed";
					
					
					
					}
				}
				
				
				Callable<String> c1 = new Sample();
				
				ExecutorService es = Executors.newFixedThreadPool(1);
				
				Future f =  es.submit(c1);
				
				while(!f.isDone())
				{
					String s =null;
					try {
						s=(String) f.get();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ExecutionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(s);
					
					es.shutdown();

				

				}
			
				break;
				}
			
			case 7:
				class Sample implements Callable<String>{
					
					public String call() throws Exception {
						
						
						eimpl.exportEmpl();
				
						return "Export Completed";
					
					
					
					}
				}
				
				
				Callable<String> c1 = new Sample();
				
				ExecutorService es = Executors.newFixedThreadPool(1);
				
				Future f =  es.submit(c1);
				
				while(!f.isDone())
				{
					String s =null;
					try {
						s=(String) f.get();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ExecutionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(s);
				
					es.shutdown();

				

				}

			
			break;
			

			}
			
			
			}
			catch(InputMismatchException iME)
			{
				System.out.println("Please Enter a numeric Value");
			}
			
		}while(ch!=8);
		
		
		
		
		

	}
	
	
}
	




