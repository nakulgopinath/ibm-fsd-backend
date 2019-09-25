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

import com.examples.empapp.model.Employee;
import com.sun.rowset.JdbcRowSetImpl;


public class EmployeeDao implements IDao {
	
	static int flag;
	public Connection conn = null;
	public Statement stmt = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	

	public EmployeeDao() {
	
		
		connection();
		// TODO Auto-generated constructor stub
	}
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "training";
	static final String PASS = "training";

	public void connection()
	{
		
		
		
		if(flag==0)
		{
			try {
	
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		conn.setAutoCommit(true); // enable transaction

		System.out.println("Connection estabilished: " + conn);

		// STEP 4: Execute a query
		System.out.println("Creating RowSet...");
		
		// JDBC RowSet
		rs = new JdbcRowSetImpl(conn);
	}catch(SQLException e){
		
	}
			}
		flag++;
		
	}
	@Override
	public void addToDatabase(Employee epojo)
	
	{
		
		
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
//		pstmt.close();
		

	}
		catch(SQLException e)
		{
			
		}
		
		

		System.out.println("Goodbye!");
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
	
	public void updateEmployeeFromDatabase(int id)
	{
		
		try
		{
			Scanner sc=new Scanner(System.in);
			String sql = "UPDATE employeenew SET id = ?,name= ?,designation= ?,country= ? WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			
			
			System.out.println("Employee ID: ");
			pstmt.setInt(1,sc.nextInt());
			System.out.println("Employee Name:");
			pstmt.setString(2,sc.next());
			System.out.println("EMployee Designation:");
			pstmt.setString(3,sc.next());
			System.out.println("Employee Country:");
			pstmt.setString(4,sc.next());
			
			pstmt.setInt(5,id);
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount+" Record Updated");
			
			
			


		}
		catch (SQLException se2){
			
		}
		
	}
	
	public void deleteEmployeeFromDatabase(int id)
	{
		try {
			String sql = "DELETE FROM employeenew WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			int deleteCount = pstmt.executeUpdate();
			System.out.println(deleteCount+" Record Deleted");
		}
		catch(SQLException se2){
			
		}
	}
	
	public ArrayList<Employee> viewAllEmployeeFromDatabase()
	{ 
		
		
		ArrayList<Employee> eArr = new ArrayList<Employee>();
		try {
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
		
		
		 