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
<jsp:include page="header.jsp" />
<div align="center">
<h2>Please provide below Details</h2>
<spring:form action="${pageContext.request.contextPath}/UnregisteredCust" method="post" modelAttribute="Newuser">
	<br/>
	<table>
	
	<tr>
		<td><spring:label path="firstName">FirstName: </spring:label></td>
		<td><spring:input path="firstName" type="text" name="firstName" /></td>
	</tr>
	
	<tr>
		<td><spring:label path="lastName">LastName: </spring:label></td>
		<td><spring:input path="lastName" type="text" name="lastName" /></td>
	</tr>
	
	<tr>
		<td><spring:label path="email">Email: </spring:label></td>
		<td><spring:input path="email" type="text" name="email" /></td>
	</tr>
	
	<tr>
		<td><spring:label path="mobileNumber">Contact Number: </spring:label></td>
		<td><spring:input path="mobileNumber" type="number" name="mobileNumber" /></td>
	</tr>
	
	<tr>
		<td><spring:label path="city">City: </spring:label></td>
		<td><spring:input path="city" type="text" name="city" /></td>
	</tr>
	
	<tr>
		<td><spring:label path="location">State: </spring:label></td>
		<td><spring:input path="location" type="text" name="location" /></td>
	</tr>
	
	<tr>
		<td><spring:label path="birthday">Date of Birth: </spring:label></td>
		<td><spring:input path="birthday" type="date" name="birthday" /></td>
	</tr>
	<!-- 
	<tr>
		<td><label>Upload Proof of Address: </label></td>
		<td><input type="file" name="AddressProof" /></td>
	</tr>
	
	<tr>
		<td><label>Upload Birth Certificate: </label></td>
		<td><input type="file" name="BirthCert" /></td>
	</tr> -->

	<tr>
		<td><input type="submit" value="Register"/></td>
	</tr>
	</table>
</spring:form>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>