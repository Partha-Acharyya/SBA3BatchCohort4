<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<head>
<!--  <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">   -->
 <style>

.BankNameheader {
	font-family: "Times New Roman", Times, serif;
}

.aliceblue {
	outline: 50px solid rgba(240, 248, 255, 0.5) !important;
	outline-offset: -200px;
	overflow: hidden;
	position: relative;
	height: 60px;
	width: 60px;
}


.adc {
	text-decoration: none;
	text-shadow: 2px 2px 5px red;
	font-weight: bold;
}

.td {
	background-color: white;
	border-radius: 15px 15px;
	margin: 100px 400px;
	text-align: center;
	padding: 20px;
	border: #666666 1px solid;
	box-shadow: 5px 5px;
	cursor: pointer;
}

.header {
	margin-left: 15px;
	color: #804000;
	font-weight: 900;
	font-family: fantasy;
}

.DCupgrade {
	background-color: #808080;
	padding: 15px;
	border: 5px solid grey;
	margin: 50px 300px;
	color: white;
	font-weight: bold;
	border-radius: 15px 15px;
}

body {
	background-color: aliceblue;
	font-family: Arial, Helvetica, sans-serif;
}

.navbar {
	margin-top: 25px;
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

.navbar a:hover, .dropdown:hover .dropbtn input[type=submit]:hover {
	background-color: red;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
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
input[type=submit] {
  background-color: #333;
  border: none;
  color: white;
  padding: 10px 28px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
</head>
<div align="center">
<!-- <img Class="aliceblue" src="logo1.PNG" /> -->

<!-- <c:url value="/resources/logo1.PNG"  /> -->

<span Class="header">Integrated Banking System</span>


</div>