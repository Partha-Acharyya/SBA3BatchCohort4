<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Management Module</title>
</head>
<body>
<form>
<h2> Please Enter loan no to pay EMI:</h2>

Loan Number: <input type="text">
EMI amount: <input type = "text">

<br><br>
<input type="submit" value="Submit">
<input type="reset" value="Clear">

</form>
<br><br>
<a href="${pageContext.request.contextPath}/index.jsp" >Back</a>

</body>
</html>