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
	<jsp:include page="navbar.jsp" />
	<div align="center">


		<H4>Beneficiaries List</H4>
		<table id="table">
			<thead>
				<tr>
					<th>BeneficiaryAccountNo</th>
					<th>AccountType</th>
				</tr>
			</thead>
			<c:forEach var="beneficiaries" items="${ibsBeneficiaries}">
				<tr>
					<td>${beneficiaries.beneficiaryAccountNo}</td>
					<td>${beneficiaries.beneficiaryAccountType}</td>
				</tr>
			</c:forEach>

		</table>
		<H4>Delete Beneficiary</H4>
		<spring:form action="${pageContext.request.contextPath}/user/BeneficiaryDeletedSuccessfully" method="post"
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
					<td><input type="submit" value="Delete" /></td>
				</tr>
			</table>
		</spring:form>
		<H3>Modify Beneficiary</H3>
		<spring:form
			action="${pageContext.request.contextPath}/user/BeneficiaryModifiedSuccessfully"
			method="post" modelAttribute="AddBeneficiaryInputDto">

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
					<td><spring:label path="beneficiaryAccountType">beneficiary Account Type</spring:label></td>
					<td><spring:select path="beneficiaryAccountType"
							name="beneficiaryAccountType">
							<spring:option value="Savings" label="Savings" />
							<spring:option value="Credit Card" label="Credit Card" />
						</spring:select></td>
				</tr>
				<tr>
					<td><spring:label path="beneficiaryName">Beneficiary Name:</spring:label></td>
					<td><spring:input path="beneficiaryName" type="text"
							name="beneficiaryName" /></td>
				</tr>
				<tr>
					<td><spring:label path="ifscCode">IFSCCode:</spring:label></td>
					<td><spring:input path="ifscCode" type="id" name="ifscCode" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Modify" /></td>

				</tr>

			</table>

		</spring:form>

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>