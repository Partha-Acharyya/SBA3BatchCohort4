<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Beneficiary</title>
</head>
<body>
<H1>IBS Beneficiary</H1>
<form action="AddIBSBeneficiary.jsp" method="post">

		<table style="width: 80% , height:80%">
			
			<tr>
<!--                 <td><input type="radio" name="Add IBS Beneficiary" value="Add a Beneficiary" checked>
					    Add Beneficiary</td> -->  
				<td><label for="Accounts">Add a Beneficiary</label></td> 
			</tr>
			<tr>
				<td><label>Beneficiary Account No / Credit Card No:</label></td>
				<td><input type="number" maxlength="40" name="Beneficiary Account No / Credit Card No:" required/></td>
			</tr>
			<tr>
				<td><label>Re-Enter Beneficiary Account No / Credit Card No:</label></td>
				<td><input type="number" maxlength="40" name="Re-Enter Beneficiary Account No / Credit Card No:" required/></td>
			</tr>
			<tr>
				<td><label>Beneficiary Account Type:</label></td>
				<td><select width="80%" name="Account Type" required>
						<option value="Savings">Savings</option>
						<option value="Credit">Credit</option>
						<option value="Current">Current</option>
				</select></td>
				</tr>
			<tr>
				<td><label>Beneficiary Name:</label></td>
				<td><input type="text" name="Beneficiary Name" required/></td>
			</tr>
			<tr>
				<td><label>Email ID:</label></td>
				<td><input type="id" name="Email ID" required/></td>
			</tr>
			<tr>
				<td class="DataLeftAligned"/>
					<a href="View Or Delete List Of Beneficiaries.jsp">Back</a>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
				</tr>
			
		</table>
		
</form>

<H1>Modify IBS Beneficiary</H1>
<form action="AddIBSBeneficiary.jsp" method="post">

		<table style="width: 80% , height:80%">
			
			<tr>
<!-- 			    <td><input type="radio" name="Modify IBS Beneficiary" value="Modify IBS Beneficiary" checked>
					    Modify IBS Beneficiary</td> -->
				<td><label for="Accounts">Modify a Beneficiary</label></td>
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

<H1>Delete Beneficiary</H1>
<form action="AddIBSBeneficiary.jsp" method="post">

		<table style="width: 80% , height:80%">
			
			<tr>
<!-- 			    <td><input type="radio" name="Modify IBS Beneficiary" value="Modify IBS Beneficiary" checked>
					    Modify IBS Beneficiary</td> -->
				<td><label for="Accounts">Delete a IBS Beneficiary</label></td>
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