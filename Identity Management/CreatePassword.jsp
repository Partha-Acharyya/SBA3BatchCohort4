<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a New Password</title>
</head>
<body>
<h4>Create a New Password</h4>
<form action="CreatePassword" method="post">
	<br/>
	<label>Enter New Password: </label>
	<br/>
	<input type="password" name="pwd1" required/>
	<br/><br/>
	<label>Confirm New Password</label>
	<br/>
	<input type="password" name="pwd2" required/>
	<br/><br/>
	<input type="submit" value="Change Password"/>
</form>
</body>
</html>