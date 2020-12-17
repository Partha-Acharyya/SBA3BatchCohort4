<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Beneficiary success</title>
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
				Beneficiary Management <i class="fa fa-caret-down"></i>
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
	<!-- 	<h3>Hi ${creditCardEligibilityOutputDto.firstName}
			${creditCardEligibilityOutputDto.lastName} ,</h3>
		<h3>A representative will be contacting you on
			${creditCardEligibilityOutputDto.mobileNumber}</h3> -->
		<h5>Beneficiary Account number deleted successfully :
			${addBeneficiaryOutputDto.beneficiaryAccountNo}</h5>
		<h5>Beneficiary status is :
			${addBeneficiaryOutputDto.status}</h5>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>