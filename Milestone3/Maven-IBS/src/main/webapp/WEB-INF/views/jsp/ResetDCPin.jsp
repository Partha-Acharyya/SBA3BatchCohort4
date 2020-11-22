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
<jsp:include page="header.jsp"/>
<div align="center">
<H3>Reset Debit Card Pin</H3>
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
				<td><spring:label path="DebitCardCVV">Debit card CVV</spring:label></td>
				<td><spring:input type="text" path="DebitCardCVV" maxLength="3" pattern="[0-9]{3}$" title="Enter only 3 digits" name="DebitCardCVV" /></td>
			</tr>
			<tr>
				<td><spring:label path="DebitCardPin">Debit card pin</spring:label></td>
				<td><spring:input path="DebitCardPin" type="text" maxLength="4" pattern="[0-9]{4}$" title="Enter only 4 digits" name="DebitCardPin" /></td>
			</tr>
			
			<tr>
				<td><spring:label path="DebitCardPin">Confirm Debit card pin</spring:label></td>
				<td><spring:input path="DebitCardPin" type="text" maxLength="4" pattern="[0-9]{4}$" title="Enter only 4 digits" name="ConfirmDebitCardPin" /></td>
			</tr>
			<tr>
			<td><button onClick="DebitCard" >Back</button></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			
		</table>
		
</spring:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>