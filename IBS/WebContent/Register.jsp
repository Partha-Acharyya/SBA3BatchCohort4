<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h2>Please provide below Details</h2>
<form action="registrationServ" method="post">
	<br/>
	<table style="width: 80% , height:80%">
	
	<tr>
		<td><label>Name: </label></td>
		<td><input type="text" name="name" required/></td>
	</tr>
	
	<tr>
		<td><label>Email: </label></td>
		<td><input type="email" name="email" required/></td>
	</tr>
	
	<tr>
		<td><label>Contact Number: </label></td>
		<td><input type="number" name="ContactNum" required/></td>
	</tr>
	
	<tr>
		<td><label>Address: </label></td>
		<td><input type="text" name="Address" required/></td>
	</tr>
	
	<tr>
		<td><label>Date of Birth: </label></td>
		<td><input type="date" name="DOB" placeholder="dd-mm-yyyy" required/></td>
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
		<td><input type="submit" value="Register"/></td>
	</tr>
	</table>
</form>
</body>
</html>