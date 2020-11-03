
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Open a loan</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
<script type="text/javascript">

function showOperations(evt, role) {
	  // Declare all variables
	  var i, tabcontent, tablinks;

	  // Get all elements with class="tabcontent" and hide them
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }

	  // Get all elements with class="tablinks" and remove the class "active"
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }

	  // Show the current tab, and add an "active" class to the button that opened the tab
	  document.getElementById(role).style.display = "block";
	  evt.currentTarget.className += " active";
	}
</script>
</head>
<body>

<div class="tab">
  <button class="tablinks" onclick="showOperations(event, 'HomeLoan')">Home Loan</button>
  <button class="tablinks" onclick="showOperations(event, 'EducationLoan')">Education Loan</button>
  <button class="tablinks" onclick="showOperations(event, 'PersonalLoan')">Personal Loan</button>
  <button class="tablinks" onclick="showOperations(event, 'VehicleLoan')">Vehicle Loan</button>
</div>

<!-- Tab content -->
<div id="HomeLoan" class="tabcontent" style="display:block">

<h2> Please fill below fields to open a Home loan:</h2>

First Name: <input type="text"><br>
Last Name: <input type="text"><br>
Date of Birth: <input type="text"><br>
Address: <input type="text"><br>
Income: <input type="text">

<br><br>
<input type="submit" value="Submit">
<input type="reset" value="Clear">

<br><br>
<a href="${pageContext.request.contextPath}/index.jsp" >Back</a>

</div>

<div id="EducationLoan" class="tabcontent">

<h2> Please fill below fields to open an Education loan:</h2>

First Name: <input type="text"><br>
Last Name: <input type="text"><br>
Date of Birth: <input type="text"><br>
Address: <input type="text"><br>
Income: <input type="text">

<br><br>
<input type="submit" value="Submit">
<input type="reset" value="Clear">

<br><br>
<a href="${pageContext.request.contextPath}/index.jsp" >Back</a>

</div>

<!-- Tab content -->
<div id="PersonalLoan" class="tabcontent">
<h2> Please fill below fields to open a Personal loan:</h2>

First Name: <input type="text"><br>
Last Name: <input type="text"><br>
Date of Birth: <input type="text"><br>
Address: <input type="text"><br>
Income: <input type="text">

<br><br>
<input type="submit" value="Submit">
<input type="reset" value="Clear">

<br><br>
<a href="${pageContext.request.contextPath}/index.jsp" >Back</a>

</div>

<div id="VehicleLoan" class="tabcontent">

<h2> Please fill below fields to open a Vehicle loan:</h2>

First Name: <input type="text"><br>
Last Name: <input type="text"><br>
Date of Birth: <input type="text"><br>
Address: <input type="text"><br>
Income: <input type="text">

<br><br>
<input type="submit" value="Submit">
<input type="reset" value="Clear">

<br><br>
<a href="${pageContext.request.contextPath}/index.jsp" >Back</a>

</div>
</body>
</html>