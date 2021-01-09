<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
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
					or Deactivate Card</a>
					<a
					href="${pageContext.request.contextPath}/admin/AdminRequestDCStatement">Request Debit Card
					Statements</a>
						<a
					href="${pageContext.request.contextPath}/admin/AdminRequestCCStatement">Request Credit Card
					Statements</a>
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
</body>
</html>