<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Insertion</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<h3>
	Existing Employee Records
</h3>



<c:forEach items="${employees}" var="emp">
<table class="table table-hover">

<tr> <strong>Employee ID: ${emp.getId()}</strong><br> </tr>
<tr> <strong>Employee Name: ${emp.name}</strong><br> </tr>
<tr> <strong>Employee Role: ${emp.designation}</strong><br> </tr>
<tr> <strong>Employee Role: ${emp.country}</strong><br> </tr>


</table>
</c:forEach>

<p> <a href="http://localhost:7070/emp-mgmt-app06/">Return to Home</a>

</body>
</html>

