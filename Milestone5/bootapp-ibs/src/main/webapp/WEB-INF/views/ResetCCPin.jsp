<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreditCard</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
		<H3>Reset Credit Card Pin</H3>
		<spring:form
			action="${pageContext.request.contextPath}/user/CreditCard"
			method="post" modelAttribute="CardDto">
			<table>
				<tr>
					<td><spring:label for="CardNumber" path="CardNumber">Select Credit Number</spring:label></td>
					<td><spring:select name="CardNumber" path="CardNumber">
							<spring:options items="${CardDto.CardNumber}" />
						</spring:select> <spring:errors path="CardNumber" cssClass="error" /> </td>
				</tr>
				<tr>
					<td><spring:label path="CardCVV">Credit card CVV</spring:label></td>
					<td><spring:input type="text" path="CardCVV" maxLength="3"
							pattern="[0-9]{3}$" title="Enter only 3 digits" name="CardCVV" />
						<spring:errors path="CardCVV" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:label path="CardPin">Credit card pin</spring:label></td>
					<td><spring:input path="CardPin" type="text" maxLength="4"
							pattern="[0-9]{4}$" title="Enter only 4 digits" name="CardPin" />
						<spring:errors path="CardPin" cssClass="error" /></td>
				</tr>

				<tr>
					<td><spring:label path="CardPin">Confirm Credit card pin</spring:label></td>
					<td><spring:input path="CardPin" type="text" maxLength="4"
							pattern="[0-9]{4}$" title="Enter only 4 digits" name="CardPin" />
						<spring:errors path="CardPin" cssClass="error" /></td>
				</tr>
				<tr>
					<td><button
							onClick="${pageContext.request.contextPath}/user/CreditCard">Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

		</spring:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>