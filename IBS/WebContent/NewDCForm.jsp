<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Debit Card Form</title>
</head>
<Center>
<H2>Enter Existing Debit card details</H2>
<form action="DCAuthentication" method="post">
<body>
	<table style="width: 80%, height:80%">
		<tr>
			<td><label>Debit Card Number</label></td>
			<td><input type="text" maxLength="16" pattern="[0-9]{16}$" title="Enter only digits" name="DebitCardNumber"  required /></td>
		</tr>
		<tr>
			<td><label>Debit Card Pin</label></td>
			<td><input type="password" maxLength="4" pattern="[0-9]{4}$" title="Enter only digits" name="DebitCardPin" required /></td>
		</tr>
<tr>
				<td><input type="submit" value="Authenticate" /></td>
			</tr>
	</table>

</body>
</form>
</Center>
</html>