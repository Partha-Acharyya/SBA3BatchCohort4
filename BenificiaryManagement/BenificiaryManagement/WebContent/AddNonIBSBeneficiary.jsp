<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Beneficiary</title>
</head>
<body>
<H1>Add a Non IBS Beneficiary</H1>
<form action="AddNonIBSBeneficiary.jsp" method="post">

		<table style="width: 80% , height:80%">
			
			<tr>
<!-- 			    <td><input type="radio" name="Add Non IBS Beneficiary" value="Add a Non IBS Beneficiary" checked>
					    Add a Non IBS Beneficiary</td> -->
				<td><label for="Accounts">Add a Non IBS Beneficiary</label></td> 
				<td><select name="Accounts">
						<option value="Savings">Savings</option>
						<option value="Credit Card">Credit Card</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Beneficiary Account No</label></td>
				<td><input type="number" name="Beneficiary Account No" required/></td>
			</tr>
			<tr>
				<td><label>Re-Enter Beneficiary Account No</label></td>
				<td><input type="number" name="Re-Enter Beneficiary Account No" required/></td>
			</tr>
			<tr>
				<td><label>Beneficiary Name</label></td>
				<td><input type="name" name="Beneficiary Name" required/></td>
			</tr>
			<tr>
				<td><label>Email ID</label></td>
				<td><input type="id" name="Email ID" required/></td>
			</tr>
			<tr>
				<td><label>Bank Name</label></td>
				<td><input type="bank" name="Bank Name" required/></td>
			</tr>
			<tr>
				<td><label>IFSC code</label></td>
				<td><input type="code" name="IFSC code" required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
			
			</table>
			
</form>

<H1>Modify a Non-IBS Beneficiary</H1>
<form action="AddNonIBSBeneficiary.jsp" method="post">

		<table style="width: 80% , height:80%">			
			
			<tr>
<!-- 			    <td><input type="radio" name="Add Non IBS Beneficiary" value="Add Non IBS Beneficiary" checked>
					    Add Non IBS Beneficiary</td> -->
				<td><label for="Accounts">Modify a Non IBS Beneficiary</label></td> 
	 			<td><select name="Accounts">
						<option value="Savings">Savings</option>
						<option value="Credit Card">Credit Card</option>
				</select></td> 
			</tr>
			<tr>
				<td><label>Limit</label></td>
				<td><input type="number" name="Limit" required/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Modify" /></td>
			</tr>
			
		</table>
		
</form>

<H1>Delete IBS Beneficiary</H1>
<form action="AddIBSBeneficiary.jsp" method="post">

		<table style="width: 80% , height:80%">
			
			<tr>
<!-- 			    <td><input type="radio" name="Modify IBS Beneficiary" value="Modify IBS Beneficiary" checked>
					    Modify IBS Beneficiary</td> -->
				<td><label for="Accounts">Delete a Beneficiary</label></td>
				<td><select name="Accounts">
						<option value="Savings">Savings</option>
						<option value="Credit Card">Credit Card</option>
				</select></td> 
			</tr>
			
			<tr>
				<td><input type="submit" value="Delete" /></td>
			</tr>
			
		</table>
		
</form>  
</body>
</html>