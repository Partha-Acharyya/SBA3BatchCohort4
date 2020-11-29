<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CCEligibility</title>
</head>
<body>
<center>
<h2>CREDIT CARD ELIGIBILITY FORM</h2>
</center>
<center>

<form action="CardManagement" method="post">

		<table style="width: 80% , height:80%">
			<tr>
				<td><label>First Name</label></td>
				<td><input type="text" name="FirstName" required/></td>
			</tr>
			<tr>
				<td><label>Last Name</label></td>
				<td><input type="text" name="LastName" required/></td>
			</tr>
			<tr>
				<td><label for="birthday">Date Of Birth</label></td>
				<td><input type="date" id="birthday" name="birthday" required></td>
			</tr>
			<tr>
				<td><label>Mobile Number</label></td>
				<td><input type="text" maxLength="10" pattern="[0-9]{10}$" title="Enter only digits"  name="MobileNumber" required/></td>
			</tr>
			<tr>
				<td><label>Email Id</label></td>
				<td><input type="email" name="Email" required/></td>
			</tr>
			<tr>
				<td><label for="TypeOfEmployment">Type Of Employment</label></td>
				<td><select name="TypeOfEmployment">
						<option value="Salaried">Salaried</option>
						<option value="Self Employed">Self Employed</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Total Income</label></td>
				<td><input type="text" name="TotalIncome" required/>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			
		</table>
		
</form>
</body>
</center>

</html>