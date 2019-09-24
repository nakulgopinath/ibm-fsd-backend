<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ViewEmployeeByIdController" method="post">

<label for="empid">Employee ID</label>
<input name="empid" type="number" >

 <input type="submit" value="View Employee">
 <input type="reset" value="Reset">

</form>

</body>
</html>