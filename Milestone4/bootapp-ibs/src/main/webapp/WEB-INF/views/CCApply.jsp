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
<link href="<core:url value="/resources/css/index.css" />"
	rel="stylesheet">

</head>

<body>
	<div align="center">
		<jsp:include page="header.jsp" />
		<h3>CREDIT CARD ELIGIBILITY FORM</h3>
		<spring:form action="CreditCard" method="post"
			modelAttribute="CreditCard">

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
					<td><spring:label path="FirstName">First Name</spring:label></td>
					<td><spring:input path="FirstName" type="text"
							name="FirstName" /></td>
				</tr>
				<tr>
					<td><spring:label path="LastName">Last Name</spring:label></td>
					<td><spring:input path="LastName" type="text" name="LastName" /></td>
				</tr>
				<tr>
					<td><spring:label path="birthday">Date Of Birth</spring:label></td>
					<td><spring:input path="birthday" type="date" id="birthday"
							name="birthday" /></td>
				</tr>
				<tr>
					<td><spring:label path="MobileNumber">Mobile Number</spring:label></td>
					<td><spring:input path="MobileNumber" type="text"
							maxLength="10" pattern="[0-9]{10}$" title="Enter only digits"
							name="MobileNumber" /></td>
				</tr>
				<tr>
					<td><spring:label path="Email">Email Id</spring:label></td>
					<td><spring:input path="Email" type="email" name="Email" /></td>
				</tr>
				<tr>
					<td><spring:label path="TypeOfEmployment"
							for="TypeOfEmployment">Type Of Employment</spring:label></td>
					<td><spring:select path="TypeOfEmployment"
							name="TypeOfEmployment">
							<spring:option value="Salaried">Salaried</spring:option>
							<spring:option value="Self Employed">Self Employed</spring:option>
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label path="TotalIncome">Total Income</spring:label></td>
					<td><spring:input path="TotalIncome" type="text"
							name="TotalIncome" />
				</tr>

				<tr>
					<td><button  onClick="${pageContext.request.contextPath}/user/CreditCard"" >Back</button></td>
					<td><input type="submit" value="Apply Now" /></td>
					
				</tr>

			</table>

		</spring:form>

		<jsp:include page="footer.jsp" />
	</div>
</body>

</html>