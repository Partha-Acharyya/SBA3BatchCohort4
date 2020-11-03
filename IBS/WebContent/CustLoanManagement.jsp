<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="Customer" class="tabcontent" style="display:block">

<a href="${pageContext.request.contextPath}/OpenLoan.jsp"> Open a Loan</a>
<br><br>
<a href="${pageContext.request.contextPath}/PayEMI.jsp" >Pay Loan EMI</a>
<br><br>
<a href="${pageContext.request.contextPath}/GenerateStatement.jsp" >Generate Statement</a>
<br><br>
<a href="${pageContext.request.contextPath}/PreClosureRequest.jsp" >Request Pre-Closure</a>

</div>

</body>
</html>