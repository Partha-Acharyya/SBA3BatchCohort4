<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Rep Login</title>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
</head>
<body>
<spring:form action="user/adminlogin" method="post">
	<br/>
	<table>
	<tr>
		<td><spring:label path="adminuser">Enter Bank Login ID</spring:label></td>
		<td><spring:input path="adminuser" type="text" name="UID"/></td>
	</tr>
	<tr>
		<td><spring:label path="adminpassword">Enter Password</spring:label></td>
		<td><spring:input path="adminpassword" type="password" name="Pwd"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"/></td>
		
	</tr>

	</table>
</spring:form>
</body>
</html>