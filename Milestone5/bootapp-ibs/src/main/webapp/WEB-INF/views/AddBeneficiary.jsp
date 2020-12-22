<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beneficiary Management</title>


</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">
	<H3>Add a Beneficiary</H3>
		<spring:form action="BeneficiaryAddedSuccessfully" method="post"
			modelAttribute="AddBeneficiaryInputDto">

			<table style="width: 80%, height:80%">

				<tr>
					
				</tr>
				<tr>
					<td><spring:label path="beneficiaryAccountNo">Beneficiary Account No / Credit Card No:</spring:label></td>
					<td><spring:input path="beneficiaryAccountNo" type="number"
							maxlength="40" name="beneficiaryAccountNo" /></td>
				</tr>

				<tr>
					<td><spring:label path="beneficiaryAccountNo">Re-Enter Beneficiary Account No / Credit Card No:</spring:label></td>
					<td><spring:input path="beneficiaryAccountNo" type="number"
							maxlength="40" name="beneficiaryAccountNo" /></td>
				</tr>

				<tr>
					<td><spring:label path="beneficiaryAccountType">Beneficiary Account Type:</spring:label></td>
					<td><spring:select width="80%" path="beneficiaryAccountType"
							name="beneficiaryAccountType">
							<spring:option value="Savings" label="Savings" />
							<spring:option value="Credit" label="Credit" />
							<spring:option value="Current" label="Current" />
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
					<td><spring:label path="customerId">customerId:</spring:label></td>
					<td><spring:input path="customerId" type="id"
							name="customerId" /></td>
				</tr>
				<tr>
					
					<td><button  onClick="${pageContext.request.contextPath}/" >Back</button></td>
					<td><input type="submit" value="Add" /></td>
				</tr>
				

			</table>

		</spring:form>
		<H3>Modify IBS Beneficiary</H3>
		<spring:form action="AddIBSBeneficiary" method="post"
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