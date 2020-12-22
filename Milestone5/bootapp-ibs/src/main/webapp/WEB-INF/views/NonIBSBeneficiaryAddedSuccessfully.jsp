<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Non-IBS Beneficiary success</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	
	<div align="center">
	
		<h5>Non-IBS Beneficiary Account number added successfully :
			${addBeneficiaryOutputDto.beneficiaryAccountNo}</h5>
		<h5>Beneficiary status is :
			${addBeneficiaryOutputDto.status}</h5>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>