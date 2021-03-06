<%@taglib uri="http://www.springframework.org/tags/form" prefix="lf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Management Module</title>

<div class="Header"></div>

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
			tablinks[i].className = tablinks[i].className
					.replace(" active", "");
		}

		// Show the current tab, and add an "active" class to the button that opened the tab
		document.getElementById(role).style.display = "block";
		evt.currentTarget.className += " active";
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<table>
		<div class="tab">

			<button class="tablinks" onclick="showOperations(event, 'Customer')">Customer
				Operations</button>
			<button class="tablinks" onclick="showOperations(event, 'BankRep')">Bank
				Representative Operations</button>

		</div>
	</table>



	<!-- Tab content -->
	<div id="Customer" class="tabcontent" style="display: block">
		<br>
		<br> <a href="${pageContext.request.contextPath}/loans"> Open
			a Loan</a> <br>
		<br> <a href="${pageContext.request.contextPath}/payemi">Pay
			Loan EMI</a> <br>
		<br> <a
			href="${pageContext.request.contextPath}/generateStatement">Generate
			Statement</a> <br>
		<br> <a href="${pageContext.request.contextPath}/precolosure">Request
			Pre-Closure</a>

	</div>

	<div id="BankRep" class="tabcontent">

		<br>
		<br> <a href="${pageContext.request.contextPath}/addloantype">Add
			Loan Types</a> <br>
		<br> <a href="${pageContext.request.contextPath}/loanapproval">Approve
			or Decline a loan</a> <br>
		<br> <a href="${pageContext.request.contextPath}/preClosure">Approve
			or Decline Pre-closure request</a>

	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>