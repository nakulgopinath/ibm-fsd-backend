<%@page import="model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Employees</title>
</head>
<body>
	<% ArrayList<Employee> employees = (ArrayList) request.getAttribute("empList");
	   out.print("No of employees: " + employees.size());
	 %>
	<h3>List Employees</h3>
	<table>
		<thead> 
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Designation</td>
				<td>Country</td>
			</tr> 
		</thead>
		<tbody>
			<% for(Employee emp: employees) { %>
			<tr>
				<td><%= emp.getId() %> </td>
				<td><%= emp.getName() %> </td>
				<td><%= emp.getDesignation()%></td>
				<td><%= emp.getCountry() %> </td>
				
				
			</tr>
			<%} %>
		</tbody>
		</tbody>
	</table>
	<br>
	<a href="addEmployee.jsp">Add Employee</a>
	<a href="index.jsp">Go Back</a>
	
</body>
</html>