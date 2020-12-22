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
<jsp:include page="navbar.jsp" />
	<div align="center">
		<H3>Credit Card Upgrade</H3>
		<spring:form action="CreditCardUpgrade_success" method="post"
			modelAttribute="CardDto">

			<table>
				<tr>
					<td><spring:label for="cardNumber" path="cardNumber">Select Credit Number</spring:label></td>
					<td><spring:select name="cardNumber" path="cardNumber">
							<c:forEach var="CardDto" items="${CardDto1}">

								<spring:option value="${CardDto.cardNumber}">${CardDto.cardNumber}</spring:option>
							</c:forEach>
						</spring:select> <spring:errors path="cardNumber" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:label for="cardType" path="cardType">Select the type of Credit card to Upgrade</spring:label></td>
					<td><spring:select name="cardType" path="cardType">
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