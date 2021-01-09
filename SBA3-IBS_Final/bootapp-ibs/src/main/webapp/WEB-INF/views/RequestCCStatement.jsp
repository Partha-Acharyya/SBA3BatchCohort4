<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit Card Statement</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">
		<H3>Request CreditCard Statement</H3>
		<table>
			<spring:form action="${pageContext.request.contextPath}/user/displayCcStatement" method="post" modelAttribute="CardStatementDto">
				<tr>
					<td><spring:label for="cardNumber" path="cardNumber">Select CreditCard Number</spring:label></td>
					<td><spring:select name="cardNumber" path="cardNumber">
							<c:forEach var="CardDto" items="${CardDto1}">

								<spring:option value="${CardDto.cardNumber}">${CardDto.cardNumber}</spring:option>
							</c:forEach>
						</spring:select> </td>
				<tr>
					<td><spring:label path="startDate">Start Date</spring:label></td>
					<td> <spring:input path="startDate" type="date" /></td>
				</tr>
				<tr>
					<td><spring:label path="endDate">End Date</spring:label></td>
					<td> <spring:input path="endDate" type="date" /></td>
				</tr>
				<tr>
					<td><button onClick="CreditCard">Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>


			</spring:form>
		</table>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>