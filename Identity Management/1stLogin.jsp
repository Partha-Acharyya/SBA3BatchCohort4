<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First Login</title>
</head>
<body>
<h3>Welcome!! Please Login</h3>
<form action="FirstLoginServ" method="post">
	<br/>
	<table style="width: 80% , height:80%">
	<tr>
		<td><label>Enter UID</label></td>
		<td><input type="text" name="UID"/></td>
	</tr>
	<tr>
		<td><label>Enter Password</label></td>
		<td><input type="password" name="Pwd"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"/></td>
	</tr>
	</table>
</form>
</body>
</html>