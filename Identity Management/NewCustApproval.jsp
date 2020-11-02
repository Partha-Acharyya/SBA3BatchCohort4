<%@ page import="Entities.NewCustomerCheck"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Approval Form</title>
</head>
<body>

<form action="CustApproval" method="post">
<%
NewCustomerCheck cust1= (NewCustomerCheck)request.getAttribute("Customer");
%>
	<table style="width: 80% , height:80%">
	<tr>
		<td><label>Reference ID: <%=cust1.getReferenceID() %></label></td>
	</tr>
	<tr>
		<td><label>Name: <%=cust1.getName() %></label></td>
	</tr>
	
	<tr>
		<td><label>Email: <%=cust1.getEmail() %></label></td>
		
	</tr>
	
	<tr>
		<td><label>Contact Number: <%=cust1.getContact() %></label></td>
		
	</tr>
	
	<tr>
		<td><label>Address: <%=cust1.getAddress() %></label></td>
		
	</tr>
	
	<tr>
		<td><label>Date of Birth: <%=cust1.getDate() %></label></td>
		
	</tr>
		
	<tr></tr>
	
	<tr>
		<td><input type="submit" value="Approve"/></td>
		<td><input type="submit" value="Reject"/></td>
	</tr>
	
	</table>
</form>
</body>
</html>