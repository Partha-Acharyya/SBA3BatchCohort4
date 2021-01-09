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
					<a href="${pageContext.request.contextPath}/user/AddBeneficiary">Add
						IBS Beneficiary</a> <a
						href="${pageContext.request.contextPath}/user/AddNonIBSBeneficiary">Add
						non IBS Beneficiary</a> <a
						href="${pageContext.request.contextPath}/user/ViewOrDeleteListOfBeneficiaries">View,
						modify Or Delete List Of Beneficiaries</a>

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
						Loan</a> <a href="${pageContext.request.contextPath}/user/payemi">Pay
						Loan EMI</a> <a
						href="${pageContext.request.contextPath}/user/generateStatement">Generate
						Statement</a> <a
						href="${pageContext.request.contextPath}/user/precolosure">Request
						Pre-Closure</a>

				</div>
			</div>
			<a href="${pageContext.request.contextPath}/user/serviceProvider">Service
				Provider</a>
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
						href="${pageContext.request.contextPath}/user/requestPeriodicStatement">Request
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

		</h3>
		<div class="navbar">
			<a href="${pageContext.request.contextPath}/admin/home">Home</a>
			<a href="${pageContext.request.contextPath}/admin/ApproveDeclineNewuser">Approve/Decline New Users</a>
			<div class="dropdown">
				<button class="dropbtn">
					Cards <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a
						href="${pageContext.request.contextPath}/admin/ApproveDeclineCard">Approve
						or Decline Card Request</a> <a
						href="${pageContext.request.contextPath}/admin/ActivateDeactivateCard">Activate
						or Deactivate Card</a> <a
						href="${pageContext.request.contextPath}/admin/AdminRequestDCStatement">Request
						Debit Card Statements</a> <a
						href="${pageContext.request.contextPath}/admin/AdminRequestCCStatement">Request
						Credit Card Statements</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					Account <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a
						href="${pageContext.request.contextPath}/admin/requestPeriodicStatement">Request
						Statements</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					Loans <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath}/admin/LoanApproval">Approve
						or Decline a loan</a> <a
						href="${pageContext.request.contextPath}/admin/PreClosureApproval">Approve
						or Decline Pre-closure request</a>
				</div>
			</div>
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
		</div>
	</security:authorize>

	<jsp:include page="footer.jsp" />
</body>
</html>
