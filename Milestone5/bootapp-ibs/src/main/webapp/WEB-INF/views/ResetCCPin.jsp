<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreditCard</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">
		<H3>Reset Credit Card Pin</H3>
		<spring:form
			action="ResetPinSuccess" method="post" modelAttribute="CardDto">
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
					<td><spring:label path="cardCvv">Credit card CVV</spring:label></td>
					<td><spring:input type="text" path="cardCvv"  name="cardCvv" />
						<spring:errors path="cardCvv" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:label path="cardPin">Credit card pin</spring:label></td>
					<td><spring:input path="cardPin" type="password"  name="cardPin" />
						<spring:errors path="cardPin" cssClass="error" /></td>
				</tr>

				 <tr>
					<td><spring:label path="cardPin">Confirm Credit card pin</spring:label></td>
					<td><spring:input path="cardPin"  type="password" name="cardPin" />
						<spring:errors path="cardPin" cssClass="error" /></td>
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