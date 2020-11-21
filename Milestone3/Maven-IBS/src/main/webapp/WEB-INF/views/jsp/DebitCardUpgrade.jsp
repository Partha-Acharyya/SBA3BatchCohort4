<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
</head>
<body>
<H1>Debit Card Upgrade</H1>
<form action="NewDCForm.jsp" method="post">

		<table style="width: 80% , height:80%">
			
			<tr>
				<td><label for="DCType">Select the type of Debit card to Upgrade</label></td>
				<td><select name="DCType">
						<option value="Gold">Gold</option>
						<option value="Platinum">Platinum</option>
						</select></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Apply Now" /></td>
			</tr>
			
		</table>
		
</form>
</body>
</html>