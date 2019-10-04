package com.examples.empapp.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.examples.empapp.model.Employee;
import com.sun.rowset.JdbcRowSetImpl;


public class EmployeeDao implements IDao {
	

	
	@Autowired
	Connection conn;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	
	@Override
	public boolean addToDatabase(Employee epojo)
	
	{
		boolean status;
		
		try {
	
		
 System.out.print("Inside try");
		
	
		
		String insertQueryForPrepareStmt = "INSERT INTO employeenew (id, name, designation, country) VALUES (?, ?, ?, ?)";
		pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
		pstmt.setInt(1, epojo.getId());
	
		pstmt.setString(2, epojo.getName());
		pstmt.setString(3,epojo.getDesignation());
		pstmt.setString(4,epojo.getCountry());
		
		
		int insertCount = pstmt.executeUpdate();
		System.out.println(insertCount+" Record Inserted");
		
		status=true;
//		pstmt.close();
		

	}
		catch(SQLException e)
		{
			status=false;
		}
		
		

		System.out.println("Goodbye!");
		return status;
}

	
	public Employee viewEmployeeFromDatabase(int idtemp)
	{
		System.out.println("Hi");
		
		Employee e = new Employee();
		

		
		try {
		String sql = "SELECT * FROM employeenew WHERE id=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,idtemp);
		
		
		rs = pstmt.executeQuery();

		
		while(rs.next())
		{
			
		
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		e.setDesignation( rs.getString("designation"));
		e.setCountry(rs.getString("country"));
		
		}
		

		// Display values
	
		
		
		
		}
		

		
		catch(SQLException se2)
		{
			System.out.println(se2.getMessage());
		}
		return e;
	
	}
	
	public boolean updateEmployeeFromDatabase(Employee emp)
	{
		boolean status;
		try
		{
			Scanner sc=new Scanner(System.in);
			String sql = "UPDATE employeenew SET id = ?,name= ?,designation= ?,country= ? WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			
			
			System.out.println("Employee ID: ");
			pstmt.setInt(1,emp.getId());
			System.out.println("Employee Name:");
			pstmt.setString(2,emp.getName());
			System.out.println("EMployee Designation:");
			pstmt.setString(3,emp.getDesignation());
			System.out.println("Employee Country:");
			pstmt.setString(4,emp.getCountry());
			
			pstmt.setInt(5,emp.getId());
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount+" Record Updated");
			
			if(updateCount==0)
				status=false;
				else
				status=true;	
			
			
			


		}
		catch (SQLException se2){
			status=true;
		}
		
		return status;
		
	}
	
	public boolean deleteEmployeeFromDatabase(int id)
	{
		boolean status;
		try {
			String sql = "DELETE FROM employeenew WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			int deleteCount = pstmt.executeUpdate();
			System.out.println(deleteCount+" Record Deleted");
			
			if(deleteCount==0)
			status=false;
			else
			status=true;	
		}
		catch(SQLException se2){
			status=false;
		}
		
		return status;
	}
	
	public ArrayList<Employee> viewAllEmployeeFromDatabase()
	{ 
		
		
		ArrayList<Employee> eArr = new ArrayList<Employee>();
		try {
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			conn.setAutoCommit(true);
			
			

			System.out.println("Connection estabilished: " + conn);
			
			String sql = "SELECT * FROM employeenew";
			pstmt = conn.prepareStatement(sql);
			
		
			
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				Employee e = new Employee();
				
				
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setDesignation( rs.getString("designation"));
				e.setCountry(rs.getString("country"));
				
				eArr.add(e);
				
				



		}
		}
		catch(SQLException e1)
		{ 
			
		}
		return eArr;
	}
	
	public void importToDatabase(Employee epojo)
	{
		
		
		
     addToDatabase(epojo);       
			
		
	} 

	
	public String exportToDatabase()
	{ 
		String result="";
		try {
			String sql = "SELECT * FROM employeenew";
			pstmt = conn.prepareStatement(sql);
			
		
			
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
			
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String country = rs.getString("country");

			
				result+=String.format("\t%d  \t%s  \t%s \t\t%s\n", id1, name, designation,  country );

		}
		
		}
		catch(SQLException e)
		{ 
			
		}
		return result;
		
		
	}
	
	
	
		}	
		
		
		 