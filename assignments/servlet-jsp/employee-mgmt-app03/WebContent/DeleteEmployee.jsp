<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="DeleteEmployeeByIdController" method="post">

<label for="empid">Employee ID</label>
<input name="empid" type="number" >

 <input type="submit" value="Delete Employee">
 <input type="reset" value="Reset">

</body>
</html>