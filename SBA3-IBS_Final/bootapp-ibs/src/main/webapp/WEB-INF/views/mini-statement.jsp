<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Mini Statement</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
<jsp:include page="header.jsp" />
	
	<jsp:include page="navbar.jsp" />
	<div align="center" id="container">
		<h3>Mini Statement </h3>
		<div id="content">
		<h6>Last Five Transactions </h6>
			<!--  add our html table here -->
		
			<table id="table">
				<tr>
					<th>Transaction ID</th>
					<th>Customer ID</th>
					<th>Create Date</th>
					<th>From Account</th>
					<th>Transaction Type</th>
					<th>Amount</th>
				</tr>
		
				<c:forEach begin="0" end="4"  var="trans" items="${miniStatement}">
							
					<tr>
						<td> ${trans.id} </td>
						<td> ${trans.customerId}</td>
						<td> ${trans.createDate} </td>
						<td> ${trans.accountNumber} </td>
						<td> <c:out value="${trans.transactionType eq 'C' ? 'Credit': 'Debit'}"/>  </td>
						<td> ${trans.amount} </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	</div>
	
	
<jsp:include page="footer.jsp" />
</body>

</html>









