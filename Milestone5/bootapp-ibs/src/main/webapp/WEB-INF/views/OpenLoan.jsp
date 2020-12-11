<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "lf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Open a loan</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
 
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

<jsp:include page="header.jsp"/>

<div class="tab">
  <button class="tablinks" onclick="showOperations(event, 'HomeLoan')">Home Loan</button>
  <button class="tablinks" onclick="showOperations(event, 'EducationLoan')">Education Loan</button>
  <button class="tablinks" onclick="showOperations(event, 'PersonalLoan')">Personal Loan</button>
  <button class="tablinks" onclick="showOperations(event, 'VehicleLoan')">Vehicle Loan</button>
</div>
<!-- Tab content -->
<div id="HomeLoan" class="tabcontent" style="display:block">
<br/><br/>
<h2> Please fill below fields to open a Home loan:</h2>

 <lf:form method = "POST" action = "">
  <div class="form-group">
    <label for="exampleFormControlInput1">First Name:</label>
     <lf:input class="form-control" type="text" placeholder="First Name" path = "firstName" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Last Name:</label>
    <lf:input class="form-control" type="text" placeholder="Last Name" path = "lastName" />
  </div>
  
    <div class="form-group">
    <label for="exampleFormControlInput1">Date of Birth:</label>
    <lf:input class="form-control" type="text" placeholder="Date of Birth" path = "dob" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Address:</label>
    <lf:textarea class="form-control" type="text" placeholder="Address" rows = "5" cols = "30" path = "address" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Income:</label>
       <lf:input class="form-control" type="text" placeholder="Income" path = "income" />
  </div>
</lf:form>
<br><br>
<button type="button" class="btn btn-primary">Submit</button>
<button type="button" class="btn btn-danger">Clear</button>

<br><br>
<a href="${pageContext.request.contextPath}/home" >Back</a>

</div>

<div id="EducationLoan" class="tabcontent">
<br/><br/>
<h2> Please fill below fields to open an Education loan:</h2>

 <lf:form method = "POST" action = "">
  <div class="form-group">
    <label for="exampleFormControlInput1">First Name:</label>
    <lf:input class="form-control" type="text" placeholder="First Name" path = "firstName" /> 	
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Last Name:</label>
    <lf:input class="form-control" type="text" placeholder="Last Name" path = "lastName" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Date of Birth:</label>
   <lf:input class="form-control" type="text" placeholder="Date of Birth" path = "dob" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Address:</label>
    <lf:textarea class="form-control" type="text" placeholder="Address" rows = "5" cols = "30" path = "address" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Income:</label>
     <lf:input class="form-control" type="text" placeholder="Income" path = "income" />
  </div>
</lf:form>

<button type="button" class="btn btn-primary">Submit</button>
<button type="button" class="btn btn-danger">Clear</button>


<br><br>
<a href="${pageContext.request.contextPath}/home" >Back</a>

</div>

<!-- Tab content -->
<div id="PersonalLoan" class="tabcontent">
<br/><br/>
<h2> Please fill below fields to open a Personal loan:</h2>

 <lf:form method = "POST" action = "">
  <div class="form-group">
    <label for="exampleFormControlInput1">First Name:</label>
     <lf:input class="form-control" type="text" placeholder="First Name" path = "firstName" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Last Name:</label>
    <lf:input class="form-control" type="text" placeholder="Last Name" path = "lastName" />
  </div>
  
    <div class="form-group">
    <label for="exampleFormControlInput1">Date of Birth:</label>
    <lf:input class="form-control" type="text" placeholder="Date of Birth" path = "dob" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Address:</label>
  <lf:textarea class="form-control" type="text" placeholder="Address" rows = "5" cols = "30" path = "address" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Income:</label>
       <lf:input class="form-control" type="text" placeholder="Income" path = "income" />
  </div>
</lf:form>

<button type="button" class="btn btn-primary">Submit</button>
<button type="button" class="btn btn-danger">Clear</button>
<br><br>
<a href="${pageContext.request.contextPath}/home" >Back</a>

</div>

<div id="VehicleLoan" class="tabcontent">
<br/><br/>
<h2> Please fill below fields to open a Vehicle loan:</h2>

 <lf:form method = "POST" action = "">
  <div class="form-group">
    <label for="exampleFormControlInput1">First Name:</label>
     <lf:input class="form-control" type="text" placeholder="First Name" path = "firstName" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Last Name:</label>
    <lf:input class="form-control" type="text" placeholder="Last Name" path = "lastName" />
  </div>
  
    <div class="form-group">
    <label for="exampleFormControlInput1">Date of Birth:</label>
    <lf:input class="form-control" type="text" placeholder="Date of Birth" path = "dob" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Address:</label>
    <lf:textarea class="form-control" type="text" placeholder="Address" rows = "5" cols = "30" path = "address" />
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">Income:</label>
       <lf:input class="form-control" type="text" placeholder="Income" path = "income" />
  </div>
</lf:form>

<button type="button" class="btn btn-primary">Submit</button>
<button type="button" class="btn btn-danger">Clear</button>
<br><br>
<a href="${pageContext.request.contextPath}/home" >Back</a>

</div>

   <jsp:include page="footer.jsp"/>
</body>
</html>