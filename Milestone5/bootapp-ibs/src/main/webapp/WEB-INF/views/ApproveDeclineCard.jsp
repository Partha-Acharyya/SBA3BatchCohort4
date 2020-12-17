<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CCEligibilities</title>
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
						<th>ReferenceID</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>TypeOfEmployment</th>
						<th>TotalIncome</th>
						<th>Status</th>
						<th colspan="2">Approve/Decline</th>
					</tr>
				</thead>
				<c:forEach var="eligibilities" items="${ccEligibilities}">
					<tr>
						<td>${eligibilities.referenceID}</td>
						<td>${eligibilities.firstName}</td>
						<td>${eligibilities.lastName}</td>
						<td>${eligibilities.typeOfEmployment}</td>
						<td>${eligibilities.totalIncome}</td>
						<td>${eligibilities.status}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/ApproveCardRequest/${eligibilities.referenceID}/${eligibilities.customerId}">
								Approve</a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/DeclineCardRequest/${eligibilities.referenceID}">
								Decline</a></td>
					</tr>
				</c:forEach>
			</table>
		</spring:form>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>