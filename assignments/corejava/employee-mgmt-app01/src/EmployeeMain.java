
import java.util.Scanner;
import java.util.*;


public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		EmployeeInterfaceImpl eimpl = new EmployeeInterfaceImpl();
		
		
		
		
		int ch;
		do
		{
			System.out.println("1.Add Employee");
			System.out.println("2.View Employee");
			System.out.println("3.Update Employee");
			System.out.println("4.Delete Employee");
			System.out.println("5.View All Employee");
			System.out.println("6.Exit");
			System.out.println("Enter a choice");
			ch=sc.nextInt();
			
			switch(ch)
			{
			
			case 1:
			eimpl.addEmployee();
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
			
			case 6:
			System.out.println("Program Terminated");
			break;
			

			}
			
			
			
			
		}while(ch!=6);
		

	}

}
