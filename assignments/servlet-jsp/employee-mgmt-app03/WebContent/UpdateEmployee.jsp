<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UpdateEmployeeByIdController" method="post">

<label for="empid">Employee ID</label>
<input name="empid" type="number" >
<br>
<br>
<label for="empname">Employee Name</label>
<input name="empname" type="text" >
<br>
<br>
<label for="empdesig">Employee Designation</label>
<input name="empdesig" type="text" >
<br>
<br>
<label for="empcountry">Employee Country</label>
<input name="empcountry" type="text" >
<br>
<br>
 <input type="submit" value="Add Employee">
 <input type="reset" value="Reset">
 <a href="index.jsp">Back</a>
 
</form>

</body>
</html>