<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<head>
 <link href="<c:url value="/css/index.css" />" rel="stylesheet">  

</head>
<div align="center">
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
</div>