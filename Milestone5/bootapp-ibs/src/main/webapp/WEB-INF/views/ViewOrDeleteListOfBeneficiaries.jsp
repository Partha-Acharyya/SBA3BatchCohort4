<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beneficiary Management</title>

<link href="<core:url value="/resources/css/index.css" />"
	rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp" />

	<div align="center">


		<H4>Beneficiaries List</H4>
		<table id="table">
			<thead>
				<tr>
					<th>BeneficiaryAccountNo</th>
					<th>Status</th>
				</tr>
			</thead>
			<c:forEach var="beneficiaries" items="${ibsBeneficiaries}">
				<tr>
					<td>${beneficiaries.beneficiaryAccountNo}</td>
					<td>${beneficiaries.status}</td>
				</tr>
			</c:forEach>

		</table>
		<H4>Delete Beneficiary</H4>
		<spring:form action="ViewOrDeleteListOfBeneficiaries" method="post"
			modelAttribute="AddBeneficiaryInputDto">

			<table style="width: 80%, height:80%">

				<tr>
					<td><spring:label path="beneficiaryAccountNo">Beneficiary Account No / Credit Card No:</spring:label></td>
					<td><spring:select name="beneficiaryAccountNo"
							path="beneficiaryAccountNo">
							<c:forEach var="beneficiaries" items="${ibsBeneficiaries}">

								<spring:option value="${beneficiaries.beneficiaryAccountNo}">${beneficiaries.beneficiaryAccountNo}</spring:option>
							</c:forEach>
						</spring:select> <spring:errors path="beneficiaryAccountNo" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:label path="beneficiaryAccountType">Delete Beneficiary</spring:label></td>
					<td><spring:select path="beneficiaryAccountType"
							name="beneficiaryAccountType">
							<spring:option value="Savings" label="Savings" />
							<spring:option value="Credit Card" label="Credit Card" />
						</spring:select></td>
				</tr>

				<tr>
					<td><input type="submit" value="Delete" /></td>
				</tr>
			</table>
		</spring:form>


	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>