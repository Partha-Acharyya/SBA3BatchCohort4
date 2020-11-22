<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit Card Statement Mismatch</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">

		<h3>Report Credit Card Statement Mismatch</h3>
		<spring:form action="CreditCard" method="post" modelAttribute="CreditCard">
			<table>

				<tr>
					<td><spring:label for="AccNumber" path="AccNumber">Select Account Number</spring:label></td>
					<td><spring:select name="AccNumber" path="AccNumber">
							<spring:option value="AccNumber">635623</spring:option>
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="CCNumber" path="CCNumber">Select Credit Number</spring:label></td>
					<td><spring:select name="CCNumber" path="CCNumber">
							<spring:option value="CreditcardNum">4152</spring:option>
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label path="MismatchFile">Upload Statement Mismatch</spring:label></td>
					<td><spring:input type="file" path="MismatchFile" /></td>
				</tr>

				<tr>
					<td><button onClick="CreditCard">Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

		</spring:form>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>