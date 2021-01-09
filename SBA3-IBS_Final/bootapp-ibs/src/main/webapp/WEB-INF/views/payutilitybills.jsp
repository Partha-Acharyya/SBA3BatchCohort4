<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>utility bills</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">
		<h3>Pay Utility Bills</h3>
		<table>
		<tr align="justify">
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/mobileRecharge">Mobile Recharge</a></td>
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/electricity">Electricity</a></td>
				</tr>
</table>
</div>
		<jsp:include page="footer.jsp" />

</body>
</html>