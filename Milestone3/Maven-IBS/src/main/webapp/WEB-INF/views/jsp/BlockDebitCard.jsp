<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DebitCard</title>
</head>
<body>
<H1>Block Debit Card</H1>
<form action="NewDCForm.jsp" method="post">

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
				<td><label for="BlockingType">Type of Blocking</label></td>
				<td><select name="ActionType">
						<option value="PermanentBlock">Permanent</option>
						<option value="TemporaryBlock">Temporary</option>
												</select></td>
			</tr>
			<tr>
				<td><label for="ActionType">Type of Action</label></td>
				<td><select name="ActionType">
						<option value="Unblock">Unblock</option>
						<option value="Block">Block</option>
												</select></td>
			</tr>
			<tr>
				<td><label for="BlockingReason">Reason for Blocking</label></td>
				<td><select name="BlockingReason">
						<option value="Unblock">Stolen</option>
						<option value="Block">Lost</option>
												</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			
		</table>
		
</form>
</body>
</html>