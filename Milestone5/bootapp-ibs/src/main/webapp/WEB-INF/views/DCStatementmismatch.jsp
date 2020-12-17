<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Debit Card Statement Mismatch</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
		<spring:form action="${pageContext.request.contextPath}/user/DCStatementMismatch_Success" method="post"
			modelAttribute="CardDto">
			<h3>Report Debit Card Statement Mismatch</h3>

			<table>

				<tr>
					<td><spring:label for="cardNumber" path="cardNumber">Select DebitCard Number</spring:label></td>
					<td><spring:select name="cardNumber" path="cardNumber">
							<c:forEach var="CardDto" items="${CardDto1}">

								<spring:option value="${CardDto.cardNumber}">${CardDto.cardNumber}</spring:option>
							</c:forEach>
						</spring:select> <spring:errors path="cardNumber" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:label path="mismatchFile">Upload Statement Mismatch</spring:label></td>
					<td><spring:input type="file" path="mismatchFile" /></td>
				</tr>

				<tr>
					<td><button onClick="${pageContext.request.contextPath}/user/DebitCard">Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

		</spring:form>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>