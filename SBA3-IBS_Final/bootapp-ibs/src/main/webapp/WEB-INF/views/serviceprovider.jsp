<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service Provider Registration</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">
		<h3>Service Provider Registration Form</h3>
		<form action="spm_register" method="post"
			enctype="multipart/form-data">
			<table style="with: 50%">
				<tr>
					<td>Provider Name</td>
					<td><input type="text" name="sp_provider_name" /></td>
				</tr>
				<tr>
					<td>Member1</td>
					<td><input type="text" name="sp_Member1_name" /></td>
				</tr>
				<tr>
					<td>Member2</td>
					<td><input type="text" name="sp_Member2_name" /></td>
				</tr>
				<tr>
					<td>Net Worth of the firm</td>
					<td><input type="text" name="sp_networth" /></td>
				</tr>
				<tr>
					<td>Expected Net Worth in Next 3 Years</td>
					<td><input type="text" name="sp_expectednetworth" /></td>
				</tr>
				<tr>
					<td>Company PAN</td>
					<td><input type="text" name="sp_pan" /></td>
				</tr>
				<tr>
					<td>Current Account Number of the firm</td>
					<td><input type="text" name="sp_caccctnum" /></td>
				</tr>
				<tr>
					<td>Current Account Name of the firm</td>
					<td><input type="text" name="sp_caccctname" /></td>
				</tr>
				<tr>
					<td>Current Account Number Branch of the firm</td>
					<td><input type="text" name="sp_caccctbranch" /></td>
				</tr>
				<tr>
					<td>Current Account Number IFSC of the firm</td>
					<td><input type="text" name="sp_caccctifsc" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="sp_phone" /></td>
				</tr>
			<!-- 	<tr>
					<td>Current Account Bank Statement</td>
				</tr>
				<tr>
					<td><input type="file" name="bnk_file" size="30" /></td>
					<td><input type="submit" value="Upload File" /></td>
				</tr>
				<tr>
					<td>System Flow and Code Testing Report by Authorized Software
						TGesting Center</td>
				</tr>
				<tr>
					<td><input type="file" name="crt_file" size="30" /></td>
					<td><input type="submit" value="Upload File" /></td>
				</tr> -->
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>