<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
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
				<a href="${pageContext.request.contextPath}/OpenLoan.jsp"> Open
					a Loan</a> <a href="${pageContext.request.contextPath}/PayEMI.jsp">Pay
					Loan EMI</a> <a
					href="${pageContext.request.contextPath}/GenerateStatement.jsp">Generate
					Statement</a> <a
					href="${pageContext.request.contextPath}/PreClosureRequest.jsp">Request
					Pre-Closure</a>
			</div>
		</div>
		<a href="serviceprovider.jsp">Service Provider</a> <a
			href="CreatePassword.jsp">Change Password</a> <a href="index.html">Sign
			Out</a>

	</div>
	<div align="center">
		<h2>Debit Card</h2>
		<h5>
			Debit Card Number:
			<c:forEach var="CardDto" items="${CardDto1}">
				${CardDto.cardNumber}
							</c:forEach>
		</h5>

		<b style="color: blue;">Service Request</b>

		<table style="width: 897px;" class="table">
			<tr align="justify">
				<td width="299" valign="top" class="td"><a class="adc"
					href="${pageContext.request.contextPath}/user/blockUnblockDebitCard">Block/Unblock
						card</a></td>
				<td width="299" valign="top" class="td"><a class="adc"
					href="${pageContext.request.contextPath}/user/ResetDcPin">Reset
						Pin</a></td>
			</tr>
			<tr>
				<td width="299" valign="top" class="td"><a class="adc"
					href="${pageContext.request.contextPath}/user/requestDcStatement">Request
						card statement</a></td>
				<td width="299" valign="top" class="td"><a class="adc"
					href="${pageContext.request.contextPath}/user/dcStatementMismatch">Report
						statement mismatch</a></td>
			</tr>
		</table>


		<div align="center">
			<p class="DCupgrade">
				<a href="${pageContext.request.contextPath}/user/DebitCardUpgrade">Click
					Here</a> to upgrade your existing card
			</p>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>