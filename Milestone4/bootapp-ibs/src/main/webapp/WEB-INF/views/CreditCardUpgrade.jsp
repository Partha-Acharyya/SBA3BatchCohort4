<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreditCardUpgrade</title>
<head>

<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp" />

	<div align="center">
		<H3>Credit Card Upgrade</H3>
		<spring:form action="CreditCard" method="post"
			modelAttribute="CreditCard">

			<table>
				<tr>
					<td><spring:label for="CCNumber" path="CCNumber">Select Credit Number</spring:label></td>
					<td><spring:select name="CCNumber" path="CCNumber">
							<spring:option value="CreditCardNum">4152</spring:option>
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="CCType" path="CCType">Select the type of Credit card to Upgrade</spring:label></td>
					<td><spring:select name="CCType" path="CCType">
							<spring:option value="Gold">Gold</spring:option>
							<spring:option value="Platinum">Platinum</spring:option>
						</spring:select></td>
				</tr>

				<tr>
					<td><button onClick="CreditCard">Back</button></td>
					<td><input type="submit" value="Apply Now" /></td>

				</tr>

			</table>

		</spring:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>