<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<center>
<h2>Debit Card</h2>
<h5>Debit Card Number: XXXX XXXX XXXX XX56</h5>
<button><a href="BlockDebitCard.jsp" >Block/Unblock Debit card</a></button>
<button><a href="GenerateDCPin.jsp" >Generate Debit card Pin</a></button>
<button><a href="DebitCardUpgrade.jsp">Debit Card Upgrade</a></button>
</center>
<jsp:include page="footer.jsp"/>
</body>
</html>