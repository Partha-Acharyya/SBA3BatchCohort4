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
<!-- <script>
	function myFunction() {
		alert("Applied successfully");
	}
</script>-->

<body>
	<div align="center">
		<jsp:include page="header.jsp" />
		<h3>CREDIT CARD ELIGIBILITY FORM</h3>
		<spring:form action="CCApplysuccess" method="post"
			modelAttribute="creditCardEligibilityInputDto" >

			<table>

				<tr>
					<td><spring:label path="ccType">Select credit card type to apply</spring:label></td>
					<td><spring:select path="ccType" name="ccType">
							<spring:option value="Classic" label="Classic" />
							<spring:option value="Gold" label="Gold" />
							<spring:option value="Platinum" label="Platinum" />
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label path="firstName">First Name</spring:label></td>
					<td><spring:input path="firstName" type="text"
							name="firstName" />
							<spring:errors path="firstName" cssClass="error"/></td>
				</tr>
				<tr>
					<td><spring:label path="lastName">Last Name</spring:label></td>
					<td><spring:input path="lastName" type="text" name="lastName" />
					<spring:errors path="lastName" cssClass="error"/></td>
				</tr>
				<tr>
					<td><spring:label path="birthday">Date Of Birth</spring:label></td>
					<td><spring:input path="birthday" type="date" id="birthday"
							name="birthday" />
							<spring:errors path="birthday" cssClass="error"/></td>
				</tr>
				<tr>
					<td><spring:label path="mobileNumber">Mobile Number</spring:label></td>
					<td><spring:input path="mobileNumber" type="text"
							maxLength="10" pattern="[0-9]{10}$" title="Enter only digits"
							name="mobileNumber" />
							<spring:errors path="mobileNumber" cssClass="error"/></td>
				</tr>
				<tr>
					<td><spring:label path="email">Email Id</spring:label></td>
					<td><spring:input path="email" type="email" name="Email" />
					<spring:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td><spring:label path="typeOfEmployment"
							for="typeOfEmployment">Type Of Employment</spring:label></td>
					<td><spring:select path="typeOfEmployment"
							name="typeOfEmployment">
							<spring:option value="Salaried">Salaried</spring:option>
							<spring:option value="Self Employed">Self Employed</spring:option>
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label path="totalIncome">Total Income</spring:label></td>
					<td><spring:input path="totalIncome" type="text"
							name="totalIncome" />
							<spring:errors path="totalIncome" cssClass="error"/>
				</tr>

				<tr>
					<td><button  onClick="${pageContext.request.contextPath}/user/CreditCard" >Back</button></td>
					<td><input type="submit" value="Apply Now" /></td>
					
				</tr>

			</table>

		</spring:form>

		<jsp:include page="footer.jsp" />
	</div>
</body>

</html>