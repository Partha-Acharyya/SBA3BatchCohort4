<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
<head>

<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp" />

	<div align="center">
		<H3>Debit Card Upgrade</H3>
		<spring:form action="DebitCard" method="post"
			modelAttribute="DebitCard">

			<table>

				<tr>
					<td><spring:label for="DCType" path="DCType">Select the type of Debit card to Upgrade</spring:label></td>
					<td><spring:select name="DCType" path="DCType">
							<spring:option value="Gold">Gold</spring:option>
							<spring:option value="Platinum">Platinum</spring:option>
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label path="DCNumber">Debit Card Number</spring:label></td>
					<td><spring:input type="number" path="DCNumber" maxLength="16" pattern="[0-9]{16}$"
						title="Enter only digits" name="DebitCardNumber"  /></td>
				</tr>
				<tr>
					<td><spring:label path="DebitCardPin">Debit Card Pin</spring:label></td>
					<td><spring:input path="DebitCardPin" type="password" maxLength="4" pattern="[0-9]{4}$"
						title="Enter only digits" name="DebitCardPin"  /></td>
				</tr>
				<tr>
					<td><button onClick="DebitCard">Back</button></td>
					<td><input type="submit" value="Apply Now" /></td>

				</tr>

			</table>

		</spring:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>