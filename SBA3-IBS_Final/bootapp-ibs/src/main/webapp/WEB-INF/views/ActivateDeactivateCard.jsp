<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<jsp:include page="header.jsp" />
		<jsp:include page="AdminNavBar.jsp" />
		<spring:form>
			<br>
			<br>
			<table id="table">
				<caption>Credit Card List</caption>
				<thead>
					<tr>
						<th>Card Number</th>
						<th>CustomerId</th>
						<th>Card Status</th>
						<th colspan="2">Activate/Deactivate</th>
					</tr>
				</thead>
				<c:forEach var="creditCard" items="${CreditCardList}">
					<tr>
						<td>${creditCard.cardNumber}</td>
						<td>${creditCard.customerID}</td>
						<td>${creditCard.cardStatus}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/ActivateCreditCard/${creditCard.cardNumber}/${creditCard.customerID}">
								Activate</a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/DeactivateCreditCard/${creditCard.cardNumber}/${creditCard.customerID}">
								Deactivate</a></td>
					</tr>
				</c:forEach>
			</table>
		</spring:form>
		<spring:form>
			<br>
			<br>
			<table id="table">
				<caption>Debit Card List</caption>
				<thead>
					<tr>
						<th>Card Number</th>
						<th>CustomerId</th>
						<th>Card Status</th>
						<th colspan="2">Activate/Deactivate</th>
					</tr>
				</thead>
				<c:forEach var="DebitCardList" items="${DebitCardList}">
					<tr>
						<td>${DebitCardList.cardNumber}</td>
						<td>${DebitCardList.customerID}</td>
						<td>${DebitCardList.cardStatus}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/ActivateDebitCard/${DebitCardList.cardNumber}/${DebitCardList.customerID}">
								Activate</a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/DeactivateDebitCard/${DebitCardList.cardNumber}/${DebitCardList.customerID}">
								Deactivate</a></td>
					</tr>
				</c:forEach>
			</table>
		</spring:form>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>