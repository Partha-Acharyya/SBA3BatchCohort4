<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style type="text/css">
	body {
	  font-family: Arial, Helvetica, sans-serif;
	  background-color: aliceblue;
	  text-align: center;
	}
	.banknameheader{
		background-color: grey;
		text-align: center;
		font-family: Arial, Helvetica, sans-serif;
	}
</style>

</head>
<body>
<center>
<h2 class="banknameheader">Welcome to IBS Portal</h2>
<form action="Account.jsp" method="post">
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
		<td><a href="Register.jsp">Please Register Here</a></td>
	</tr>

	</table>
</form>
</center>
</body>
</html>