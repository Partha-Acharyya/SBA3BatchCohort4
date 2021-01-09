<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div align="center" id="container">
		<h3>Debit Card Statement</h3>
		
		<div id="content">
			<table>
			
				<tr>
					<th>Created Date</th>
					<th>Transaction Type</th>
					<th>Amount</th>
				</tr>
				<c:forEach var="trans" items="${statements}">
					<tr>
					
						<td>${trans.createDate}</td>
						<td>${trans.transactionType}</td>
						<td>${trans.amount}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>