package service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import model.Employee;

public class EmployeeService implements IEmployee {

	
	Scanner sc = new Scanner(System.in);
	HashMap<Integer,Employee> eMap=new HashMap<Integer,Employee>();
//	EmployeePojo epojo=new EmployeePojo();
	
	
	@Override
	public void addEmployee(Employee epojo) {
		eMap.put(epojo.getId(),epojo);
	}
	
	@Override
	public void viewEmployee(int id){
		
		if(eMap.containsKey(id))
		{
			Employee e=new Employee();
			e=eMap.get(id);
			System.out.println("Employee ID: "+e.getId());
			System.out.println("Employee Name:"+e.getName());
			System.out.println("EMployee Designation:"+e.getDesignation());
			System.out.println("Employee Country:"+e.getCountry());
			
	}
		else
			System.out.println("Employee Doesnt Exist");
	}
	@Override
	public void updateEmployee(int id){
		
		if(eMap.containsKey(id))
		{
			Employee e=new Employee();
			e=eMap.get(id);
			System.out.println("Employee ID: ");
			e.setId(sc.nextInt());
			
			System.out.println("Employee Name:");
			e.setName(sc.next());
			
			System.out.println("EMployee Designation:");
			e.setDesignation(sc.next());
			
			System.out.println("Employee Country:");
			e.setCountry(sc.next());
			
	}
		else
			System.out.println("Employee Doesnt Exist");
		
	}
	
	@Override
	public void deleteEmployee(int id){
	if(eMap.containsKey(id))
		eMap.remove(id);
	else
		System.out.println("Employee Doesnt Exist");
	}	
			
	
	
	@Override
	public void viewAllEmployee(){
		
		
		for(Employee e:eMap.values())
		{
	
			
				System.out.println("Employee ID: "+e.getId());
				System.out.println("Employee Name:"+e.getName());
				System.out.println("EMployee Designation:"+e.getDesignation());
				System.out.println("Employee Country:"+e.getCountry());
			
		}
	}
	
	
	@Override
	
	public void importEmpl() 
	{
		
		
         
		try {
            sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\NakulGNair\\Desktop\\FSD\\Trainer-4\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\src\\Employee.txt"))));
			
            while (sc.hasNextLine()) {
            	
            	String [] arr= sc.nextLine().split(",");
            	Employee epojo=new Employee();
            	
//            	System.out.println(arr[0]);
//            	System.out.println(arr[1]);
//            	System.out.println(arr[2]);
//            	System.out.println(arr[3]);
            	
            	
                epojo.setId(Integer.parseInt(arr[0]));
                epojo.setName(arr[1]);
                epojo.setDesignation((arr[2]));
                epojo.setCountry((arr[3]));
                
                eMap.put(epojo.getId(),epojo);
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
//		Thread1 writer = new Thread1("writer");
//		writer.start();
		
		

		try {
			
			File fout = new File("C:\\Users\\NakulGNair\\Desktop\\FSD\\Trainer-4\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\src\\EmployeeExport.txt");
			FileOutputStream fos = new FileOutputStream(fout);
		 
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
		
		for(Employee e:eMap.values())
			{
//			System.out.println("Hi");
			String line = "";
			line=String.format("%s,%s,%s,%s", e.getId(),e.getName(),e.getDesignation(),e.getCountry());
			System.out.println(line);
			fos.write(line.getBytes());
			fos.write("\n".getBytes());
			}
		}
		
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}


