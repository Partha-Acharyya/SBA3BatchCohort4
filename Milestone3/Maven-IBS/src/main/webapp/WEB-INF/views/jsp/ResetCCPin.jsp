<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreditCard</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="center">
<H3>Reset Credit Card Pin</H3>
<spring:form action="CreditCard" method="post" modelAttribute="CreditCard">
		<table>
			
			<tr>
				<td><spring:label for="AccNumber" path="AccNumber">Select Account Number</spring:label></td>
				<td><spring:select name="AccNumber" path="AccNumber">
						<spring:option value="AccNumber">635623</spring:option>
												</spring:select></td>
			</tr>
				<tr>
				<td><spring:label for="CCNumber" path="CCNumber">Select Credit Number</spring:label></td>
				<td><spring:select name="CCNumber" path="CCNumber">
						<spring:option value="DebitcardNum">4152</spring:option>
												</spring:select></td>
			</tr>
			<tr>
				<td><spring:label path="CreditCardCVV">Credit card CVV</spring:label></td>
				<td><spring:input type="text" path="CreditCardCVV" maxLength="3" pattern="[0-9]{3}$" title="Enter only 3 digits" name="CreditCardCVV" /></td>
			</tr>
			<tr>
				<td><spring:label path="CreditCardPin">Credit card pin</spring:label></td>
				<td><spring:input path="CreditCardPin" type="text" maxLength="4" pattern="[0-9]{4}$" title="Enter only 4 digits" name="CreditCardPin" /></td>
			</tr>
			
			<tr>
				<td><spring:label path="CreditCardPin">Confirm Credit card pin</spring:label></td>
				<td><spring:input path="CreditCardPin" type="text" maxLength="4" pattern="[0-9]{4}$" title="Enter only 4 digits" name="ConfirmCreditCardPin" /></td>
			</tr>
			<tr>
			<td><button onClick="CreditCard" >Back</button></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			
		</table>
		
</spring:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>