
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Complete</title>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: aliceblue;
}

.homeredirect {
	color: red;
	text-align: center;
}
</style>
</head>
<body>
	<%
		
	%>
	<jsp:include page="header.jsp" />
	<div align="center">
		<h1 class="registrationMsg">Your registration is completed with
			Reference ID: ${newuseroutputdto.id}. A bank representative will
			contact you with details</h1>
		<br>
		<div class="homeredirect">
			<a href="login-form">Go to login Page</a>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>