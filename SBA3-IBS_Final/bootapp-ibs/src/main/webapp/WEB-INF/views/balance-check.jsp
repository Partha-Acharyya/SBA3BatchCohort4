<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Balance Summary</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<jsp:include page="header.jsp" />
<jsp:include page="navbar.jsp" />
	<div id="wrapper">
		<div id="header">
			
		</div>
	</div>
	
	<div id="container" align="center">
		<h5>Balance Summary of Account- ${Id}</h5>
	
		<div id="content">

			<!--  add our html table here -->
		
			<table id="table">
			<thead>
				<tr>
					<th>Account Type</th>
					<th>Balance</th>
				</tr>
				</thead>
				<!-- loop over and print our customers -->
				<c:forEach var="balan" items="${accountBalance}">
					<tr>
						<td> <c:out value="${balan.accountType eq 'C' ? 'Current': 'Savings'}"/> </td>
						<td> INR ${balan.balance} </td>
					</tr>
					
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	<jsp:include page="footer.jsp" />

</body>

</html>
