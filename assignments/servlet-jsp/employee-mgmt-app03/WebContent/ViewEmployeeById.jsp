<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%Employee emp =(Employee) request.getAttribute("employee");%>
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
			
			<tr>
				<td><%= emp.getId() %> </td>
				<td><%= emp.getName() %> </td>
				<td><%= emp.getDesignation()%></td>
				<td><%= emp.getCountry() %> </td>
				
				
			</tr>
			
		</tbody>
		</tbody>
	</table>
	<br>
	
	<a href="index.jsp">Go Back</a>
</body>
</html>