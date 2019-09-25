package com.examples.empapp.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;


/**
 * Servlet implementation class ListEmpolyeeController
 */
@WebServlet("/listEmployees.do")
public class ListEmpolyeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmpolyeeController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		EmployeeService eSer=new EmployeeService();
		
		ArrayList<Employee> employees = eSer.viewAllEmployee();
		
		System.out.println(employees);
		
		request.setAttribute("empList", employees);
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewAllEmployees.jsp");
		rd.forward(request, response);
	}

}
