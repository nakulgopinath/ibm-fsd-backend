package threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import model.Employee;
import service.EmployeeService;

public class Thread1 extends Thread {
    //To create producer and consumer as threads
        //Shared variable
        public static int x = 0;//checks if all lines are read                                      
        public static String line; //holds lines from file
        public static int j = 0;//variable to switch between threads based upon its value

        public Thread1(String threadName) {     //Constuctor
            super(threadName);      //Call to constructor of Thread class
        }
        
		public void run() {

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
