<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>

<div class="navbar">
  <a href="Account.jsp">Home</a>
   <div class="dropdown">
    <button class="dropbtn">Cards 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="DebitCard.jsp">Debit Card</a>
      <a href="CreditCard.jsp">Credit Card</a>
        </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Benificiary Management 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="AddIBSBeneficiary.jsp">Add IBS Benificiary</a>
      <a href="AddNonIBSBeneficiary.jsp" >Add non IBS Benificiary</a>
       <a href="View Or Delete List Of Beneficiaries.jsp" >View Or Delete List Of Beneficiaries</a>
        </div>
  </div> 
   <div class="dropdown">
    <button class="dropbtn">Deposits 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="${pageContext.request.contextPath}/RecurringDeposit.jsp"> Recurring Deposit</a>
      <a href="${pageContext.request.contextPath}/FixedDeposit.jsp" >Fixed Deposit</a>
      
        </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Loans 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="${pageContext.request.contextPath}/OpenLoan.jsp"> Open a Loan</a>
      <a href="${pageContext.request.contextPath}/PayEMI.jsp" >Pay Loan EMI</a>
      <a href="${pageContext.request.contextPath}/GenerateStatement.jsp" >Generate Statement</a>
      <a href="${pageContext.request.contextPath}/PreClosureRequest.jsp" >Request Pre-Closure</a>
        </div>
  </div> 
  <a href="serviceprovider.jsp">Service Provider</a>
  <a href="CreatePassword.jsp">Change Password</a>
  
  <a href="1stLogin.jsp">Sign Out</a>
  
</div>

<h3>Account summary</h3>
<h5>Account Balance is INR: /-</h5>

</body>
</html>
