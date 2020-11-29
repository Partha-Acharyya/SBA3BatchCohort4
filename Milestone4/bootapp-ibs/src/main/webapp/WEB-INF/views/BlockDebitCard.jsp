<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div align="center">
		<H3>Block or Unblock Debit Card</H3>
		<spring:form action="DebitCard" method="post" modelAttribute="DebitCard">

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
					<td><spring:label for="BlockingType" path="BlockingType">Type of Blocking</spring:label></td>
					<td><spring:select name="BlockingType" path="BlockingType">
							<spring:option value="PermanentBlock">Permanent</spring:option>
							<spring:option value="TemporaryBlock">Temporary</spring:option>
					</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="ActionType" path="ActionType">Type of Action</spring:label></td>
					<td><spring:select name="ActionType" path="ActionType">
							<spring:option value="Unblock">Unblock</spring:option>
							<spring:option value="Block">Block</spring:option>
					</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="BlockingReason" path="BlockingReason">Reason for Blocking</spring:label></td>
					<td><spring:select name="BlockingReason" path="BlockingReason">
							<spring:option value="Unblock">Stolen</spring:option>
							<spring:option value="Block">Lost</spring:option>
					</spring:select></td>
				</tr>
				<tr>
				<td><button  onClick="DebitCard" >Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

		</spring:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>