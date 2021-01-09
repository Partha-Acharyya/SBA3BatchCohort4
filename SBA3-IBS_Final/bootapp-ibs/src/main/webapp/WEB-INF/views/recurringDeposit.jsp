<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recurring Deposit</title>
<head>
<script type="text/javascript">
     
    function myFunction(){
        	var t=document.getElementById("tenure").value;
        	var d = new Date(year, month, day);
        	d.setMonth(d.getMonth() + t);
        	document.getElementById("maturitydate").value=d;
        }  
    }

    </script>
</head>
</head>
<body>
	<div align="center">
		<jsp:include page="header.jsp" />
		<jsp:include page="navbar.jsp" />
		<div id="content">
		<h5>Existing Recurring Deposit</h5>
		
			<table id="table">
				<tr>
					<th>Recurring DepositID</th>
					<th>Investment Amount</th>
					<th>Account Number</th>
					<th>Tenure</th>
					<th>Monthly DebitDate</th>
					<th>Maturity Date</th>
				</tr>
		
				<c:forEach var="RdOutputDto" items="${RdOutputDto}">
							
					<tr>
						<td> ${RdOutputDto.recurringDepositID} </td>
						<td> ${RdOutputDto.investmentAmount}</td>
						<td> ${RdOutputDto.accountNumber} </td>
						<td> ${RdOutputDto.tenure} </td>
						<td> ${RdOutputDto.monthlyDebitDate} </td>
						<td> ${RdOutputDto.maturityDate} </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
		<h5>Open Recurring Deposit</h5>
		<spring:form action="rd-confirm" method="post"
			modelAttribute="rdInputDto">

			<table>
				<tr>

					<td><label>Transfer from account</label></td>
					<td><select name="AccountNumber">
							<c:forEach var="balan" items="${accountBalance}">
								<option value="${balan.accountNumber}">${balan.accountNumber}</option>
							</c:forEach>
					</select></td>

				</tr>
				<tr>
					<td><spring:label path="investmentAmount">investment Amount</spring:label></td>
					<td><spring:input path="investmentAmount" type="text"
							name="investmentAmount" /></td>
				</tr>
				<tr>
					<td><spring:label path="tenure">tenure in months</spring:label></td>
					<td><spring:input path="tenure" id="tenure" type="number"
							name="tenure" onchange="myFunction()" /></td>
				</tr>
		
				<tr>
					<td><spring:label path="monthlyDebitDate">monthly DebitDate</spring:label></td>
					<td><spring:input path="monthlyDebitDate" type="number"
							min="1" max="31" name="monthlyDebitDate" /></td>
				</tr>



				<tr>
					<td><button
							onClick="${pageContext.request.contextPath}/user/account">Back</button></td>
					<td><input type="submit" value="Apply Now" /></td>

				</tr>

			</table>

		</spring:form>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>