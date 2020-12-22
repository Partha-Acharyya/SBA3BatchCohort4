<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>

<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp" />

	<security:authorize access="hasRole('USER')">
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
					<a href="${pageContext.request.contextPath}/user/AddBeneficiary">Add IBS Beneficiary</a> <a
						href="${pageContext.request.contextPath}/user/AddNonIBSBeneficiary">Add non IBS Beneficiary</a> <a
						href="${pageContext.request.contextPath}/user/ViewOrDeleteListOfBeneficiaries">View Or Delete List Of
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
						Loan</a> <a href="${pageContext.request.contextPath}/user/payemi">Pay Loan EMI</a> <a
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

			<h3>
				Welcome
				<security:authentication property="principal.username" />
			</h3>

			<table style="width: 897px;" class="table">
				<tr align="justify">
					<td colspan="2" width="299" valign="top" class="td"><a
						class="adc"
						href="${pageContext.request.contextPath}/user/balance-check">Balance
							Check</a></td>

				</tr>
				<tr align="justify">
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/mini-statement">Request
							Mini Statement</a></td>
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/periodicstatement">Request
							for Periodic Statement</a></td>
				</tr>
				<tr>
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/trans-form">Transfer
							funds</a></td>
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/payutilitybills">Pay
							Utility bills</a></td>
				</tr>
			</table>

		</div>
	</security:authorize>


	<security:authorize access="hasRole('ADMIN')">

		<div class="navbar">
			<a href="Account.jsp">Home</a>
			<div class="dropdown">
				<button class="dropbtn">
					Cards <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a
						href="${pageContext.request.contextPath}/admin/ApproveDeclineCard">Approve
						or Decline Card Request</a> <a
						href="${pageContext.request.contextPath}/admin/ActivateDeactivateCard">Activate
						or Deactivate Card</a>
				</div>
			</div>

			<div class="dropdown">
				<button class="dropbtn">
					Loans <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="AddLoanTypes">Add Loan Types</a> <a href="LoanApproval">Approve
						or Decline a loan</a> <a href="PreClosureApproval">Approve or
						Decline Pre-closure request</a>
				</div>
			</div>
			<a href="CreatePassword.jsp">Change Password</a>
		</div>
		<div align="right">
			<spring:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<input type="submit" value="Logout">
			</spring:form>
		</div>
	</security:authorize>

	<jsp:include page="footer.jsp" />
</body>
</html>
