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
<H1>Add a Non IBS Beneficiary</H1>
<spring:form action="AddnonIBSBeneficiary" method="post" modelAttribute="Beneficiary">

		<table style="width: 80% , height:80%">
			
			<tr> 
				<td><H5>Add a Non IBS Beneficiary</H5></td>
			</tr>
			<tr>
			   <td><spring:label path="BeneficiaryAccount">Beneficiary Account No / Credit Card No:</spring:label></td>
			   <td><spring:input path="BeneficiaryAccount" type="number" maxlength="40" name="Beneficiary Account No / Credit Card No:" /></td>
			</tr>
			<tr>
			   <td><spring:label path="BeneficiaryAccount">Re-Enter Beneficiary Account No / Credit Card No:</spring:label></td>
			   <td><spring:input path="BeneficiaryAccount" type="number" maxlength="40" name="Re-Enter Beneficiary Account No / Credit Card No:" /></td>
			</tr>
			<tr>
				<td><spring:label path="BeneficiaryAccountType">Beneficiary Account Type:</spring:label></td>
				<td><spring:select width="80%"  path="BeneficiaryAccountType" name="Account Type">
						<spring:option value="Savings" label="Savings" />
						<spring:option value="Credit" label="Credit" />
						<spring:option value="Current" label="Current" />
				</spring:select></td>
			</tr>
			<tr>
				<td><spring:label path="BeneficiaryName">Beneficiary Name:</spring:label></td>
				<td><spring:input path="BeneficiaryName" type="text"
							name="Beneficiary Name" /></td>
			</tr>
			<tr>
				<td><spring:label path="IFSCCode">IFSCCode:</spring:label></td>
				<td><spring:input path="IFSCCode" type="id"
							name="IFSCCode" /></td>
			</tr>
			<tr>
				<td><spring:label path="UCI">UCI:</spring:label></td>
				<td><spring:input path="UCI" type="id"
							name="UCI" /></td>
			</tr>
			<tr>
				<td class="DataLeftAligned"/>
					<a href="ViewOrDeleteListOfBeneficiaries">Back</a>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
				</tr>
			
		</table>
		
</spring:form>

<H1>Modify a Non-IBS Beneficiary</H1>
<spring:form action="AddnonIBSBeneficiary" method="post" modelAttribute="Beneficiary">

		<table style="width: 80% , height:80%">			
			
			<tr>
				<td><spring:label path="BeneficiaryAccountType">Modify a Non IBS Beneficiary</spring:label></td>
				<td><spring:select path="BeneficiaryAccountType" name="Accounts">
						<spring:option value="Savings" label="Savings" />
						<spring:option value="Credit Card" label="Credit Card" />
				</spring:select></td> 
			</tr>
			<tr>
				<td><spring:label path="Limit">Limit</spring:label></td>
				<td><spring:input path="Limit" type="number"
							name="Limit" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Modify" /></td>
			</tr>
			
		</table>
		
</spring:form>

<H1>Delete Beneficiary</H1>
<spring:form action="AddnonIBSBeneficiary" method="post" modelAttribute="Beneficiary">

		<table style="width: 80% , height:80%">
			
			<tr>
				<td><spring:label path="BeneficiaryAccountType">Delete Non IBS Beneficiary</spring:label></td>
				<td><spring:select path="BeneficiaryAccountType" name="Accounts">
						<spring:option value="Savings" label="Savings" />
						<spring:option value="Credit Card" label="Credit Card" />
				</spring:select></td> 
			</tr>
			
			<tr>
				<td><input type="submit" value="Delete" /></td>
			</tr>
			
		</table>
		
</spring:form>
<jsp:include page="footer.jsp"/>
</body>
</html>