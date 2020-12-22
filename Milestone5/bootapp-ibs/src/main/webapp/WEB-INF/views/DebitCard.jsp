<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">
		<h2>Debit Card</h2>
		<h5>
			Debit Card Number:
			<c:forEach var="CardDto" items="${CardDto1}">
				${CardDto.cardNumber}
							</c:forEach>
		</h5>

		<b style="color: blue;">Service Request</b>

		<table style="width: 897px;" class="table">
			<tr align="justify">
				<td width="299" valign="top" class="td"><a class="adc"
					href="${pageContext.request.contextPath}/user/blockUnblockDebitCard">Block/Unblock
						card</a></td>
				<td width="299" valign="top" class="td"><a class="adc"
					href="${pageContext.request.contextPath}/user/ResetDcPin">Reset
						Pin</a></td>
			</tr>
			<tr>
				<td width="299" valign="top" class="td"><a class="adc"
					href="${pageContext.request.contextPath}/user/requestDcStatement">Request
						card statement</a></td>
				<td width="299" valign="top" class="td"><a class="adc"
					href="${pageContext.request.contextPath}/user/dcStatementMismatch">Report
						statement mismatch</a></td>
			</tr>
		</table>


		<div align="center">
			<p class="DCupgrade">
				<a href="${pageContext.request.contextPath}/user/DebitCardUpgrade">Click
					Here</a> to upgrade your existing card
			</p>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>