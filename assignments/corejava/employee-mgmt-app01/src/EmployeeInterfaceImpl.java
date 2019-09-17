
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeInterfaceImpl implements EmployeeInterface {

	
	Scanner sc = new Scanner(System.in);
	List<EmployeePojo> eList=new ArrayList<EmployeePojo>();
//	EmployeePojo epojo=new EmployeePojo();
	
	
	@Override
	public void addEmployee() {
		EmployeePojo epojo=new EmployeePojo();
		
		System.out.println("Enter Employee Id:");
		epojo.setId(sc.nextInt());
		
		System.out.println("Enter Employee Name:");
		epojo.setName(sc.next());
		
		System.out.println("Enter Employee Designation:");
		epojo.setDesignation(sc.next());
		
		System.out.println("Enter Employee Country:");
		epojo.setCountry(sc.next());
		
		
		
		eList.add(epojo);
	}
	
	@Override
	public void viewEmployee(int id){
		
		for(EmployeePojo e:eList)
		{
			if(id==e.getId())
			{
				System.out.println("Employee ID: "+e.getId());
				System.out.println("Employee Name:"+e.getName());
				System.out.println("EMployee Designation:"+e.getDesignation());
				System.out.println("Employee Country:"+e.getCountry());
			}
		}
	}
	
	@Override
	public void updateEmployee(int id){
		
		for(EmployeePojo e:eList)
		{
			if(id==e.getId())
			{
				System.out.println("Enter Employee Id:");
				e.setId(sc.nextInt());
				
				System.out.println("Enter Employee Name:");
				e.setName(sc.next());
				
				System.out.println("Enter Employee Designation:");
				e.setDesignation(sc.next());
				
				System.out.println("Enter Employee Country:");
				e.setCountry(sc.next());
			}
		}
		
	}
	
	@Override
	public void deleteEmployee(int id){
		
		for(EmployeePojo e:eList)
		{
			if(id==e.getId())
				eList.remove(e)	;	}
		}
	
	
	@Override
	public void viewAllEmployee(){
		
		
		for(EmployeePojo e:eList)
		{
	
			
				System.out.println("Employee ID: "+e.getId());
				System.out.println("Employee Name:"+e.getName());
				System.out.println("EMployee Designation:"+e.getDesignation());
				System.out.println("Employee Country:"+e.getCountry());
			
		}
	}

}
