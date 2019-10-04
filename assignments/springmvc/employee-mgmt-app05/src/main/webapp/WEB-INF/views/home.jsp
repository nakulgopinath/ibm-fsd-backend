<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<style>
div{
font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}


</style>
<body>

<div>
<h1>Welcome to employee Management app</h1>

<a href = "addEmployee">Add Employee</a><br>
<a href = "viewEmployee">View Employee</a><br>
<a href = "updateEmployee">Update Employee</a><br>
<a href = "deleteEmployee">Delete Employee</a><br>
<form method="POST" action=" listAllEmployees.do"><input type="submit" value="View All Employees"></form>
</div>
</body>
</html>
