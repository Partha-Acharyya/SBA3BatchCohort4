<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Approval Form</title>
<style type="text/css">
	body {
	  font-family: Arial, Helvetica, sans-serif;
	  background-color: aliceblue;
	  text-align: center;
	}
</style>
</head>
<body>

<spring:form action="CustApproval" method="post">
<%

%>
	<table style="width: 80% , height:80%">
	<tr>
		<td><spring:label path="ReferenceID">Reference ID: ${newuser.ReferenceID} </spring:label></td>
	</tr>
	<tr>
		<td><spring:label path="Name">Name: ${newuser.Name}</spring:label></td>
	</tr>
	
	<tr>
		<td><spring:label path="Email">Email: ${newuser.Email}</spring:label></td>
		
	</tr>
	
	<tr>
		<td><spring:label path="ContactNumber">Contact Number: ${newuser.ContactNumber}</spring:label></td>
		
	</tr>
	
	<tr>
		<td><spring:label path="Address">Address: ${newuser.Address}</spring:label></td>
		
	</tr>
	
	<tr>
		<td><spring:label path="DOB">Date of Birth: ${newuser.DOB}</spring:label></td>
		
	</tr>
		
	<tr></tr>
	
	<tr>
		<td><input type="submit" value="Approve"/></td>
		<td><input type="submit" value="Reject"/></td>
	</tr>
	
	</table>
</spring:form>
</body>
</html>