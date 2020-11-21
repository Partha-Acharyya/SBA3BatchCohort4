<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<style>

</style>
<head>

 <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">  

</head>

<jsp:include page="header.jsp"/>
<div class="Header"></div>


<body>

	<center>
		<div class="navbar">
			<!--  <a href="#">Home</a>
    <div class="dropdown">
    <button class="dropbtn">Deposits 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Views/jsp/RecurringDeposit.jsp"> Recurring Deposit</a>
      <a href="Views/jsp/FixedDeposit.jsp" >Fixed Deposit</a>
      
        </div>
  </div> 
   <div class="dropdown">
    <button class="dropbtn">Cards 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Views/jsp/DebitCardUpgrade.jsp">Debit Card</a>
      <a href="Views/jsp/CreditCard.jsp">Credit Card</a>
        </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Loans 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Views/jsp/OpenLoan.jsp"> Open a Loan</a>
        </div>
  </div>  -->
			<a href="/views/jsp/Register.jsp">Register Here</a>
		</div>

		<form action="user/home" method="post">
			<br />
			<table>
				<tr>
					<td><label>Enter UID</label></td>
					<td><input type="text" name="UID" /></td>
				</tr>
				<tr>
					<td><label>Enter Password</label></td>
					<td><input type="password" name="Pwd" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
					<td><a href="WEB-INF/views/jsp/BankRepLogin.jsp">Login as a Bank
							Rep</a></td>
				</tr>
				</div>


			</table>

		</form>

	</center>
<jsp:include page="footer.jsp"/>
</body>
</html>