<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form"%>
	
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>



<form:form method="POST" modelAttribute="employee" action="deleteEmployee.do">
		<table class="table table-hover">
			<tr>
				<td>Employee ID:</td>
				<td><form:input path="id" /></td>
				<td><form:errors path="id" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td colspan="3"><input type="submit" value="delete"></td>
			</tr>
			</table>

	</form:form>





</form> --%>

</body>
</html>