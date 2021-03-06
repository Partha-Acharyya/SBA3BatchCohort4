<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mobile Recharge</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">
		<h3>Mobile Recharge</h3>
		<spring:form action="mobileRecharge_success" method="post"
			modelAttribute="UtilityDto">
			<table>
			<tr>
							<td><label>transfer from account</label></td>
							<td><spring:select name="accountNumber" path='accountNumber'>
									<c:forEach var="balan" items="${accountBalance}">
										<option value="${balan.accountNumber}">${balan.accountNumber}-
											balance ${balan.balance}</option>
									</c:forEach>
								</spring:select></td>
						<tr>
				<tr>
					<td><spring:label path="mobileNumber">Mobile Number</spring:label></td>
					<td><spring:input path="mobileNumber" type="text"
							name="mobileNumber" /> <spring:errors path="mobileNumber"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:label path="operator">Operator</spring:label></td>
					<td><spring:input path="operator" type="text" name="operator" />
						<spring:errors path="operator" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Recharge Amount</label></td>
					<td><spring:input name='amount' path='amount' type='number' />
						<spring:errors path="amount" cssClass="error" /></td>
				</tr>
				<tr>
							<td><label>Transaction password</label></td>
							<td><spring:input name='transactionPassword'
									path='transactionPassword' type='password' /> <spring:errors
									path="transactionPassword" cssClass="error" /></td>
						</tr>
				<tr>
					<td><button
							onClick="${pageContext.request.contextPath}/user/home">Back</button></td>
					<td><input type="submit" value="Pay" /></td>
				</tr>
				
			</table>
		</spring:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>