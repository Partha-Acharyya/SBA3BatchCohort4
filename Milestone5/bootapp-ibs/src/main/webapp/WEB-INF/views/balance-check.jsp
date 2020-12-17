<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Balance Summary</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
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
<jsp:include page="header.jsp" />
	<div id="wrapper">
		<div id="header">
			
		</div>
	</div>
	
	<div id="container" align="center">
		<h5>Balance Summary of Account- ${Id}</h5>
	
		<div id="content">

			<!--  add our html table here -->
		
			<table id="table">
			<thead>
				<tr>
					<th>Account Type</th>
					<th>Balance</th>
				</tr>
				</thead>
				<!-- loop over and print our customers -->
				<c:forEach var="balan" items="${accountBalance}">
					<tr>
						<td> <c:out value="${balan.accountType eq 'C' ? 'Current': 'Savings'}"/> </td>
						<td> INR ${balan.balance} </td>
					</tr>
					
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	<jsp:include page="footer.jsp" />

</body>

</html>
