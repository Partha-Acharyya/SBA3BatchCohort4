<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Debit Card Statement Mismatch</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
		<spring:form action="DebitCard" method="post"
			modelAttribute="DebitCard">
			<h3>Report Debit Card Statement Mismatch</h3>

			<table>

				<tr>
					<td><spring:label for="AccNumber" path="AccNumber">Select Account Number</spring:label></td>
					<td><spring:select name="AccNumber" path="AccNumber">
							<spring:option value="AccNumber">635623</spring:option>
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="DCNumber" path="DCNumber">Select Debit Number</spring:label></td>
					<td><spring:select name="DCNumber" path="DCNumber">
							<spring:option value="DebitcardNum">4152</spring:option>
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label path="MismatchFile">Upload Statement Mismatch</spring:label></td>
					<td><spring:input type="file" path="MismatchFile" /></td>
				</tr>

				<tr>
					<td><button onClick="DebitCard">Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

		</spring:form>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>