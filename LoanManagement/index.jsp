<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Management Module</title>

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
  <button class="tablinks" onclick="showOperations(event, 'Customer')">Customer Operations</button>
  <button class="tablinks" onclick="showOperations(event, 'BankRep')">Bank Representative Operations</button>
</div>

<!-- Tab content -->
<div id="Customer" class="tabcontent" style="display:block">

<a href="${pageContext.request.contextPath}/OpenLoan.jsp"> Open a Loan</a>
<br><br>
<a href="${pageContext.request.contextPath}/PayEMI.jsp" >Pay Loan EMI</a>
<br><br>
<a href="${pageContext.request.contextPath}/GenerateStatement.jsp" >Generate Statement</a>
<br><br>
<a href="${pageContext.request.contextPath}/PreClosureRequest.jsp" >Request Pre-Closure</a>

</div>

<div id="BankRep" class="tabcontent">

<a href="${pageContext.request.contextPath}/AddLoanTypes.jsp" >Add Loan Types</a>
<br><br>
<a href="${pageContext.request.contextPath}/LoanApproval.jsp" >Approve or Decline a loan</a>
<br><br>
<a href="${pageContext.request.contextPath}/PreClosureApproval.jsp" >Approve or Decline Pre-closure request</a>

</div>


</body>
</html>