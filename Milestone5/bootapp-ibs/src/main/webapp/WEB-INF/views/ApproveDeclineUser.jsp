<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewUser</title>
</head>
<body>
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
	<div align="center">
		<jsp:include page="header.jsp" />
		<spring:form>
			<br>
			<br>
			<table id="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>City</th>
						<th>Mobile</th>
						<th>Location</th>
						<th>Email</th>
						<th>Birthday</th>
						<th colspan="2">Approve/Decline</th>
					</tr>
				</thead>
				<c:forEach var="newuser" items="${newuser}">
					<tr>
						<td>${newuser.id}</td>
						<td>${newuser.firstName}</td>
						<td>${newuser.lastName}</td>
						<td>${newuser.city}</td>
						<td>${newuser.mobileNumber}</td>
						<td>${newuser.location}</td>
						<td>${newuser.email}</td>
						<td>${newuser.birthday}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/ApproveUser/${newuser.referenceID}/${newuser.customerId}">
								Approve</a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/DeclineUser/${newuser.id}">
								Decline</a></td>
					</tr>
				</c:forEach>
			</table>
		</spring:form>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>