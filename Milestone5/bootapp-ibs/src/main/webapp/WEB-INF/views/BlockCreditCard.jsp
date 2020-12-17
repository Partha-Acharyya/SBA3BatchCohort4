<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreditCard</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="navbar">
			<a href="${pageContext.request.contextPath}/user/home">Home</a>
			<div class="dropdown">
				<button class="dropbtn">
					Cards <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath}/user/DebitCard">Debit
						Card</a> <a href="${pageContext.request.contextPath}/user/CreditCard">Credit
						Card</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					Benificiary Management <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="AddIBSBeneficiary">Add IBS Beneficiary</a> <a
						href="AddnonIBSBeneficiary">Add non IBS Beneficiary</a> <a
						href="ViewOrDeleteListOfBeneficiaries">View Or Delete List Of
						Beneficiaries</a>

				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					Deposits <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath}/user/recurringDeposit">
						Recurring Deposit</a> <a
						href="${pageContext.request.contextPath}/user/fixedDeposit">Fixed
						Deposit</a>

				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					Loans <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">

					<a href="${pageContext.request.contextPath}/user/loans"> Open a
						Loan</a> <a href="payemi">Pay Loan EMI</a> <a
						href="${pageContext.request.contextPath}/user/generateStatement">Generate
						Statement</a> <a
						href="${pageContext.request.contextPath}/user/precolosure">Request
						Pre-Closure</a>

				</div>
			</div>
			<a href="serviceprovider.jsp">Service Provider</a> <a
				href="CreatePassword.jsp">Change Password</a>
			<div align="right">
				<spring:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					<input type="submit" value="Logout">
				</spring:form>
			</div>

		</div>
	<div align="center">
		<H3>Block or Unblock Credit Card </H3>
		<spring:form action="blockUnblockCreditCardsuccess" method="post" modelAttribute="CardDto">

			<table>

				<tr>
				<td><spring:label for="cardNumber" path="cardNumber">Select Credit Number</spring:label></td>
				<td><spring:select name="cardNumber" path="cardNumber">
							<c:forEach var="CardDto" items="${CardDto1}">

								<spring:option value="${CardDto.cardNumber}">${CardDto.cardNumber}</spring:option>
							</c:forEach>
						</spring:select> <spring:errors path="cardNumber" cssClass="error" /></td>
			</tr>
			
				

				<tr>
					<td><spring:label for="blockingType" path="blockingType">Type of Blocking</spring:label></td>
					<td><spring:select name="blockingType" path="blockingType">
							<spring:option value="PermanentBlock">Permanent</spring:option>
							<spring:option value="TemporaryBlock">Temporary</spring:option>
					</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="actionType" path="actionType">Type of Action</spring:label></td>
					<td><spring:select name="actionType" path="actionType">
							<spring:option value="Unblock">Unblock</spring:option>
							<spring:option value="Block">Block</spring:option>
					</spring:select></td>
				</tr>
				<tr>
					<td><spring:label for="blockingReason" path="blockingReason">Reason for Blocking</spring:label></td>
					<td><spring:select name="blockingReason" path="blockingReason">
							<spring:option value="Stolen">Stolen</spring:option>
							<spring:option value="Stolen">Lost</spring:option>
					</spring:select></td>
				</tr>
				<tr>
				<td><button onClick="${pageContext.request.contextPath}/user/CreditCard">Back</button></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>

			</table>

		</spring:form>
		
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>