<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<center>
<body>
<H1>Apply for Credit Card</H1>
<form action="CCEligibility.jsp" method="post">

		<table style="width: 80% , height:80%">
			
			<tr>
				<td><label for="CCType">Select credit card type</label></td>
				<td><select name="CCType">
						<option value="Classic">Classic</option>
						<option value="Gold">Gold</option>
						<option value="Platinum">Platinum</option>
				</select></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Apply Now" /></td>
			</tr>
			
		</table>
		
</form>
<H1>Credit card Application Status</H1>
<form action="CCStatus.jsp" method="post">

		<table style="width: 80% , height:80%">
			
			<tr>
				<td><label>Mobile Number</label></td>
				<td><input type="number" name="MobileNumber" required/></td>
			</tr>
			<tr>
				<td><label>Email Id</label></td>
				<td><input type="email" name="Email" required/></td>
			</tr>
			<tr>
				<td><label>Reference ID</label></td>
				<td><input type="text" name="ReferenceId" required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			
		</table>
		</form>
</body>
</center>
</html>