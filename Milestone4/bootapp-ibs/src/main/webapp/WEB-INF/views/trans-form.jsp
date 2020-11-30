<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Transaction Creation</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
<jsp:include page="header.jsp" />
	
	<div id="container" align="center">
		<h3>Transaction Creation</h3>

		<div id="content">

			<!--  add our html table here -->
			<form:form action="createTrans" modelAttribute="transaction"
				method="POST">
				<table>
					<tbody>

						<tr>
							<td><label>Customer Id:</label></td>
							<td>${Id}</td>
						</tr>

						<!-- <tr>

							<td><label>Transaction Type:</label></td>
							<td><select name="transType">
									<option value="Credit">Credit</option>
									<option value="Debit">Debit</option>
									<option value="Deposit">Deposit</option>
							</select></td>
						</tr>  -->
						<tr>
							<td><label>transfer from account</label></td>
							<td><select name="AccountNumber">
									<c:forEach var="balan" items="${accountBalance}">
										<option value="${balan.accountNumber}">${balan.accountNumber}-
											balance ${balan.balance}</option>
									</c:forEach>
							</select></td>
						<tr>
							<td><label>Amount:</label></td>
							<td><input name='amount' type='number'></td>
						</tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>


					</tbody>
				</table>
			</form:form>
		</div>

	</div>

<jsp:include page="footer.jsp" />
</body>

</html>
