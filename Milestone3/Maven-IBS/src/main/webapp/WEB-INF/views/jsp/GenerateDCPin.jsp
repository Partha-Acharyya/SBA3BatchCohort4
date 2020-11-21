<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
</head>
<body>
<H1>Generate Debit Card Pin</H1>
<form action="DCGeneratePinServlet" method="post">
<center>
		<table style="width: 80% , height:80%">
			
			<tr>
				<td><label for="AccNumber">Select Account Number</label></td>
				<td><select name="AccNumber">
						<option value="AccNumber"></option>
												</select></td>
			</tr>
				<tr>
				<td><label for="DCNumber">Select Debit Number</label></td>
				<td><select name="DCNumber">
						<option value="DebitcardNum"></option>
												</select></td>
			</tr>
			<tr>
				<td><label>Debit card CVV</label></td>
				<td><input type="text" maxLength="3" pattern="[0-9]{3}$" title="Enter only digits" name="DebitCardCVV" required/></td>
			</tr>
			<tr>
				<td><label>Debit card pin</label></td>
				<td><input type="text" maxLength="4" pattern="[0-9]{4}$" title="Enter only digits" name="DebitCardPin" required/></td>
			</tr>
			
			<tr>
				<td><label>Confirm Debit card pin</label></td>
				<td><input type="text" maxLength="4" pattern="[0-9]{4}$" title="Enter only digits" name="ConfirmDebitCardPin" required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			
		</table>
		</center>
</form>
</body>
</html>