<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">
		<H3>Reset Debit Card Pin</H3>
		<spring:form
			action="${pageContext.request.contextPath}/user/ResetDcPinSuccess" method="post" modelAttribute="CardDto">
			<table>
				<tr>
					<td><spring:label for="cardNumber" path="cardNumber">Select Debit Card Number</spring:label></td>
					<td><spring:select name="cardNumber" path="cardNumber">
							<c:forEach var="CardDto" items="${CardDto1}">

								<spring:option value="${CardDto.cardNumber}">${CardDto.cardNumber}</spring:option>
							</c:forEach>
						</spring:select> <spring:errors path="cardNumber" cssClass="error" /></td>

				</tr>
				<tr>
					<td><spring:label path="cardCvv">Debit card CVV</spring:label></td>
					<td><spring:input type="text" path="cardCvv"  name="cardCvv" maxLength="3" pattern="[0-9]{3}$" title="Enter only 3 digits"  />
						<spring:errors path="cardCvv" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:label path="cardPin">Debit card pin</spring:label></td>
					<td><spring:input path="cardPin" type="password"  name="cardPin" maxLength="4" pattern="[0-9]{4}$" title="Enter only 4 digits" />
						<spring:errors path="cardPin" cssClass="error" /></td>
				</tr>

				 <tr>
					<td><spring:label path="cardPin">Confirm Debit card pin</spring:label></td>
					<td><spring:input path="cardPin"  type="password" name="cardPin" maxLength="4" pattern="[0-9]{4}$" title="Enter only 4 digits" />
						<spring:errors path="cardPin" cssClass="error" /></td>
				</tr> 
				<tr>
					<td><button
							onClick="${pageContext.request.contextPath}/user/DebitCard">Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

		</spring:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>