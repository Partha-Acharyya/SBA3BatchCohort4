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
						<td><a href="${pageContext.request.contextPath}/admin/ApproveCardRequest/${eligibilities.referenceID}">
							Approve</a></td>
						<td><a href="${pageContext.request.contextPath}/admin/DeclineCardRequest/${eligibilities.referenceID}">
							Decline</a></td>
					</tr>
				</c:forEach>
			</table>
		</spring:form>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>