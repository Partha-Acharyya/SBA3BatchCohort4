<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style type="text/css">
	.banknameheader{
		background-color: grey;
		text-align: center;
		font-family: Arial, Helvetica, sans-serif;
	}
	
	body {
	  font-family: Arial, Helvetica, sans-serif;
	  background-color: aliceblue;
	  text-align: center;
	}
</style>
</head>
<body>
<h2>Please provide below Details</h2>
<spring:form action="newregistration" method="post" modelAttribute="newuser">
	<br/>
	<table style="width: 80% , height:80%">
	
	<tr>
		<td><spring:label path="firstName">FirstName: </spring:label></td>
		<td><spring:input path="firstName" type="text" name="firstName" required/></td>
	</tr>
	
	<tr>
		<td><spring:label path="lastName">LastName: </spring:label></td>
		<td><spring:input path="lastName" type="text" name="lastName" required/></td>
	</tr>
	
	<tr>
		<td><spring:label path="email">Email: </spring:label></td>
		<td><spring:input path="email" type="email" name="email" required/></td>
	</tr>
	
	<tr>
		<td><spring:label path="mobileNumber">Contact Number: </spring:label></td>
		<td><spring:input path="mobileNumber" type="number" name="ContactNum" required/></td>
	</tr>
	
	<tr>
		<td><spring:label path="city">City: </spring:label></td>
		<td><spring:input path="city" type="text" name="city" required/></td>
	</tr>
	
	<tr>
		<td><spring:label path="location">State: </spring:label></td>
		<td><spring:input path="location" type="text" name="location" required/></td>
	</tr>
	
	<tr>
		<td><spring:label path="birthday">Date of Birth: </spring:label></td>
		<td><spring:input path="birthday" type="date" name="DOB" placeholder="dd-mm-yyyy" required/></td>
	</tr>
	
	<tr>
		<td><label>Upload Proof of Address: </label></td>
		<td><input type="file" name="AddressProof" /></td>
	</tr>
	
	<tr>
		<td><label>Upload Birth Certificate: </label></td>
		<td><input type="file" name="BirthCert" /></td>
	</tr>
	
	<tr></tr>
	
	<tr>
		<td><input type="submit" value="Register" class="submit"/></td>
	</tr>
	</table>
</spring:form>
</body>
</html>