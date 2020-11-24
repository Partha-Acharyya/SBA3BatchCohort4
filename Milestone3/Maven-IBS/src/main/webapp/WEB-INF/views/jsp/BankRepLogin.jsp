<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Rep Login</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<div align="center">
<spring:form action="home" method="post" modelAttribute="Adminuser">
	<br/>
	<table>
	<tr>
		<td><spring:label path="adminuser">Enter Bank Login ID</spring:label></td>
		<td><spring:input path="adminuser" type="text" name="adminuser"/></td>
	</tr>
	<tr>
		<td><spring:label path="adminpassword">Enter Password</spring:label></td>
		<td><spring:input path="adminpassword" type="password" name="adminpassword"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"/></td>
		
	</tr>

	</table>
</spring:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>