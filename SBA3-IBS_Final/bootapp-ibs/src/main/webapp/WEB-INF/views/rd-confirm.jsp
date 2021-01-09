<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RD Confirm</title>
</head>
<body>
	<jsp:include page="header.jsp" />
<jsp:include page="navbar.jsp" />
	<h5>Your RecurringDepositID ${rdOutputDto.recurringDepositID} and
		maturity date: ${rdOutputDto.maturityDate}</h5>
	<jsp:include page="footer.jsp" />
</body>
</html>