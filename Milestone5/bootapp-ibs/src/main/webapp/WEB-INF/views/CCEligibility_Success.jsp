
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreditCardEligibility success</title>
</head>
<body>
<%-- 
CreditCardEligibility CreditCardEligibility = (CreditCardEligibility) 
request.getAttribute("CreditCardEligibility");
%>
<H1>Hi <%= CreditCardEligibility.getFirstName() %> <%= CreditCardEligibility.getLastName() %> ,</H1>
<h2> A representative will be contacting you on <%= CreditCardEligibility.getMobileNumber()%> </h2>
<h2>reference ID= <%= CreditCardEligibility.getReferenceID() %></h2>
--%>

<h5>Your reference ID : ${creditCardEligibilityOutputDto.referenceID}</h5>
</body>
</html>