<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beneficiary Management</title>

 <link href="<core:url value="/resources/css/index.css" />" rel="stylesheet">
 
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="navbar.jsp" />
<H1>Add a Non IBS Beneficiary</H1>
<spring:form action="NonIBSBeneficiaryAddedSuccessfully" method="post" modelAttribute="AddBeneficiaryInputDto">

		<table style="width: 80% , height:80%">
			
			<tr> 
				<td><H5>Add a Non IBS Beneficiary</H5></td>
			</tr>
			<tr>
			   <td><spring:label path="beneficiaryAccountNo">Beneficiary Account No / Credit Card No:</spring:label></td>
			   <td><spring:input path="beneficiaryAccountNo" type="number" maxlength="40" name="beneficiaryAccountNo" /></td>
			</tr>
			<tr>
			   <td><spring:label path="beneficiaryAccountNo">Re-Enter Beneficiary Account No / Credit Card No:</spring:label></td>
			   <td><spring:input path="beneficiaryAccountNo" type="number" maxlength="40" name="beneficiaryAccountNo" /></td>
			</tr>
			<tr>
				<td><spring:label path="beneficiaryAccountType">Beneficiary Account Type:</spring:label></td>
				<td><spring:select width="80%"  path="beneficiaryAccountType" name="beneficiaryAccountType">
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
				<td><spring:input path="ifscCode" type="id"
							name="ifscCode" /></td>
			</tr>
			<tr>
				<td class="DataLeftAligned"/><td>
					<a href="ViewOrDeleteListOfBeneficiaries">Back</a>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
				</tr>
			
		</table>
		
</spring:form>

<H1>Modify a Non-IBS Beneficiary</H1>
<spring:form action="AddNonIBSBeneficiary" method="post" modelAttribute="AddBeneficiaryInputDto">

		<table style="width: 80% , height:80%">			
			
			<tr>
			    <td><spring:label path="beneficiaryAccountNo">Beneficiary Account No / Credit Card No:</spring:label></td>
			    <td><spring:input path="beneficiaryAccountNo" type="number" maxlength="40" name="beneficiaryAccountNo" /></td>
			</tr>
			<tr>
				<td><spring:label path="beneficiaryAccountType">beneficiary Account Type</spring:label></td>
				<td><spring:select path="beneficiaryAccountType" name="beneficiaryAccountType">
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
				<td><spring:input path="ifscCode" type="id"
							name="ifscCode" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Modify" /></td>
			</tr>
			
		</table>
		
</spring:form>

<jsp:include page="footer.jsp"/>
</body>
</html>