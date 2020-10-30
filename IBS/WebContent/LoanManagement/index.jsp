<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Management Module</title>
</head>
<jsp:body>
<h2> Customer Level Operations:</h2>

<a href="${pageContext.request.contextPath}/OpenLoan.jsp"> Open a Loan</a>
<br><br>
<a href="${pageContext.request.contextPath}/PayEMI.jsp" >Pay Loan EMI</a>
<br><br>
<a href="${pageContext.request.contextPath}/GenerateStatement.jsp" >Generate Statement</a>
<br><br>
<a href="${pageContext.request.contextPath}/PreClosureRequest.jsp" >Request Pre-Closure</a>

<br><br>

<h2> Bank Representative Level Operations:</h2>
<br><br>
<a href="${pageContext.request.contextPath}/AddLoanTypes.jsp" >Add Loan Types</a>
<br><br>
<a href="${pageContext.request.contextPath}/LoanApproval.jsp" >Approve or Decline a loan</a>
<br><br>
<a href="${pageContext.request.contextPath}/PreClosureApproval.jsp" >Approve or Decline Pre-closure request</a>


</jsp:body>
</html>