<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Transaction Creation</title>

</head>

<body>
	<jsp:include page="header.jsp" />

	<div id="container" align="center">
		<h3>Transaction Creation</h3>

		<div id="content">
			<spring:form
				action="${pageContext.request.contextPath}/user/TransferFunds_Success"
				modelAttribute="AccountStatementDto" method="POST">
				<table>
					<tbody>

						<tr>
							<td><label>Customer Id</label></td>
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
							<td><spring:select name="accountNumber" path='accountNumber'>
									<c:forEach var="balan" items="${accountBalance}">
										<option value="${balan.accountNumber}">${balan.accountNumber}-
											balance ${balan.balance}</option>
									</c:forEach>
								</spring:select></td>
						<tr>
						<tr>
							<td><spring:label path="beneficiaryAccountNumber">Beneficiary Account No / Credit Card No</spring:label></td>
							<td><spring:select name="beneficiaryAccountNumber"
									path="beneficiaryAccountNumber">
									<c:forEach var="beneficiaries" items="${ibsBeneficiaries}">

										<spring:option value="${beneficiaries.beneficiaryAccountNo}">${beneficiaries.beneficiaryAccountNo}</spring:option>
									</c:forEach>
								</spring:select> <spring:errors path="beneficiaryAccountNumber" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Amount</label></td>
							<td><spring:input name='amount' path='amount' type='number' step='.01'/>
								<spring:errors path="amount" cssClass="error"/></td>

						</tr>
						<tr>
							<td><label>message</label></td>
							<td><spring:input name='message' path='message' type='text' />
								<spring:errors path="message" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Transaction password</label></td>
							<td><spring:input name='transactionPassword'
									path='transactionPassword' type='password' /> <spring:errors
									path="transactionPassword" cssClass="error" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>


					</tbody>
				</table>
			</spring:form>
		</div>

	</div>

	<jsp:include page="footer.jsp" />
</body>

</html>
