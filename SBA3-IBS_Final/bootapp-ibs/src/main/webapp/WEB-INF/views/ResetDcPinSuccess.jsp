<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ResetPin success</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	
	<div align="center">
		<h5>Pin Reseted successfully for ${CardOutputDto.cardNumber}</h5>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>