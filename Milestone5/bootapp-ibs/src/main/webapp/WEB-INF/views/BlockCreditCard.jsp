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
		<H3>Block or Unblock Credit Card </H3>
		<spring:form action="blockUnblockCreditCardsuccess" method="post" modelAttribute="CardDto">

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
					<td><spring:label for="blockingType" path="blockingType">Type of Blocking</spring:label></td>
					<td><spring:select name="blockingType" path="blockingType">
							<spring:option value="PermanentBlock">Permanent</spring:option>
							<spring:option value="TemporaryBlock">Temporary</spring:option>
					</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="actionType" path="actionType">Type of Action</spring:label></td>
					<td><spring:select name="actionType" path="actionType">
							<spring:option value="Unblock">Unblock</spring:option>
							<spring:option value="Block">Block</spring:option>
					</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="blockingReason" path="blockingReason">Reason for Blocking</spring:label></td>
					<td><spring:select name="blockingReason" path="blockingReason">
							<spring:option value="Stolen">Stolen</spring:option>
							<spring:option value="Stolen">Lost</spring:option>
					</spring:select></td>
				</tr>
				<tr>
				<td><button onClick="${pageContext.request.contextPath}/user/CreditCard">Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

		</spring:form>
		
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>