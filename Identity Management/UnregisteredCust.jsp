<%@ page import="Entities.NewCustomerCheck"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Complete</title>
</head>
<body>
<%
NewCustomerCheck cust1= (NewCustomerCheck)request.getAttribute("Customer");
%>

<h1>Your registration is completed with Reference ID: <%=cust1.getReferenceID() %>.
A bank representative will contact you with details</h1>
</body>
</html>