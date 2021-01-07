<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

	<jsp:include page="header.jsp" />
	<div align="center">
		<div class="navbar">
			<a href="${pageContext.request.contextPath}/admin/home">Home</a>
			<a href="${pageContext.request.contextPath}/admin/ApproveNewuser">Approve/Decline New Users</a>
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
					<a href="${pageContext.request.contextPath}/admin/AddLoanTypes">Add
						Loan Types</a> <a href="LoanApproval">Approve or Decline a loan</a> <a
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

		<h3>Home</h3>
		<h5></h5>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
