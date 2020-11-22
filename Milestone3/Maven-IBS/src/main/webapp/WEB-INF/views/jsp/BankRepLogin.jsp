<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Rep Login</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<div align="center">
<form action="home" method="post">
	<br/>
	<table>
	<tr>
		<td><label>Enter Bank Login ID</label></td>
		<td><input type="text" name="UID"/></td>
	</tr>
	<tr>
		<td><label>Enter Password</label></td>
		<td><input type="password" name="Pwd"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"/></td>
		
	</tr>
</div>
	</table>
</form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>