<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="navbar">
		<a href="home">Home</a>
		<div class="dropdown">
			<button class="dropbtn">
				Cards <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="DebitCard">Debit Card</a> <a href="CreditCard">Credit
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
				<a href="${pageContext.request.contextPath}/RecurringDeposit.jsp">
					Recurring Deposit</a> <a
					href="${pageContext.request.contextPath}/FixedDeposit.jsp">Fixed
					Deposit</a>

			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Loans <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">

				<a href="${pageContext.request.contextPath}/loans"> Open a Loan</a>
				<a href="${pageContext.request.contextPath}/payemi">Pay Loan EMI</a>
				<a href="${pageContext.request.contextPath}/generateStatement">Generate
					Statement</a> <a href="${pageContext.request.contextPath}/precolosure">Request
					Pre-Closure</a>

			</div>
		</div>
		<a href="serviceprovider.jsp">Service Provider</a> <a
			href="CreatePassword.jsp">Change Password</a> <a href="index.html">Sign
			Out</a>

	</div>

	<h3>Account summary</h3>
	<h5>Account Balance is INR: /-</h5>
	<jsp:include page="footer.jsp" />
</body>
</html>
