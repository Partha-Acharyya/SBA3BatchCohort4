<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit-Card</title>
<head>
<link href="<core:url value="/resources/css/index.css" />" rel="stylesheet">

</head>

<body>
	<div align="center">
		<jsp:include page="header.jsp" />
		<H1>Apply for Credit Card</H1>
		<spring:form action="CCEligibility.jsp" method="post" modelAttribute="CreditCardEligibility">

			<table>

				<tr>
					<td><spring:label path="CCType">Select credit card type to apply</spring:label></td>
					<td><spring:select path="CCType" name="CCType">
							<spring:option value="Classic" label="Classic" />
							<spring:option value="Gold" label="Gold" />
							<spring:option value="Platinum" label="Platinum" />
						</spring:select></td>
				</tr>

				<tr>
					<td><input type="submit" value="Apply Now" /></td>
				</tr>

			</table>

		</spring:form>
		<H1>Credit card Application Status</H1>
		<form action="CheckCCStatusServlet" method="post" modelAttribute="student">

			<table>

				<tr>
					<td><spring:label path="MobileNumber">Mobile Number</spring:label></td>
					<td><spring:input path="MobileNumber" type="number"
							name="MobileNumber" /></td>
				</tr>
				<tr>
					<td><spring:label path="Email">Email Id</spring:label></td>
					<td><spring:input path="CCTEmailype" type="email" name="Email" /></td>
				</tr>
				<tr>
					<td><spring:label path="ReferenceId">Reference ID</spring:label></td>
					<td><spring:input path="ReferenceId" type="text"
							name="ReferenceId" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>
		</form>
		<jsp:include page="footer.jsp" />
	</div>
</body>

</html>