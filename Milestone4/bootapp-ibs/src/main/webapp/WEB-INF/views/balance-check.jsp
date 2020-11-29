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
	<div id="wrapper">
		<div id="header">
			
		</div>
	</div>
	
	<div id="container" align="center">
		<h3>Balance Summary of ${Id}</h3>
	
		<div id="content">

			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Account Type</th>
					<th>Balance</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="balan" items="${accountBalance}">
					<tr>
						<td> ${balan.accountType} </td>
						<td> ${balan.balance} </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	<jsp:include page="footer.jsp" />

</body>

</html>
