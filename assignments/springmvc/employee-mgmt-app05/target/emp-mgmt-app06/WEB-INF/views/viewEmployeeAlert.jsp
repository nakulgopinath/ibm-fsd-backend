<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>View Employee </title>
</head>
<body>
<h3>
	Employee Details:
</h3>

<strong>Employee ID:${emp.id}</strong><br>
<strong>Employee Name:${emp.name}</strong><br>
<strong>Employee Role:${emp.designation}</strong><br>
<strong>Employee Role:${emp.country}</strong><br>

<p> <a href="http://localhost:7070/emp-mgmt-app06/">Return to Home</a>

</body>
</html>