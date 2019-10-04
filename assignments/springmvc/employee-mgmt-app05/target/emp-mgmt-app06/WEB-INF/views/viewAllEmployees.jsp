<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Insertion</title>
</head>
<body>
<h3>
	Employee Record Updated Successfully
</h3>

<%for(Employee emp:employee) %>
<strong>Employee ID: ${emp.getId()}</strong><br>
<strong>Employee Name: ${emp.name}</strong><br>
<strong>Employee Role: ${emp.designation}</strong><br>
<strong>Employee Role: ${emp.country}</strong><br>

<p> <a href="http://localhost:7070/emp-mgmt-app06/">Return to Home</a>

</body>
</html> --%>