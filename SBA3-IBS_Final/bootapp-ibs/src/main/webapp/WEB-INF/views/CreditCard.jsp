<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit-Card</title>
<head>
<link href="<core:url value="/resources/css/index.css" />"
	rel="stylesheet">
</head>
<body>
		<jsp:include page="header.jsp" />
		<jsp:include page="navbar.jsp" />

		<div align="center">
			<h2>Credit Card</h2>
			<b style="color: blue;">Service Requests</b>

			<table style="width: 897px;" class="table">
				<tr align="justify">
					<td colspan="2" width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/CCApply">Apply Now</a></td>

				</tr>
				<tr align="justify">
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/blockUnblockCreditCard">Block/Unblock card</a></td>
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/ResetCCPin">Reset Pin</a></td>
				</tr>
				<tr>
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/requestCcStatement">Request card statement</a></td>
					<td width="299" valign="top" class="td"><a class="adc"
						href="${pageContext.request.contextPath}/user/CCStatementMismatch">Report statement mismatch</a></td>
				</tr>
			</table>


			<div align="center">
				<p class="DCupgrade">
					<a href="CreditCardUpgrade">Click Here</a> to upgrade your existing
					card
				</p>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
</body>

</html>