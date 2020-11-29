<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "lf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Management Module</title>


</head>
<body>

<jsp:include page="header.jsp"/>

 <lf:form method = "POST" action = "">
 <h2> Enter loan number to pre closure </h2>

<div class="form-group">
    <label for="exampleFormControlInput1">Loan Number:</label>
  <lf:input class="form-control" type="text" placeholder="Loan Number" path = "number" />
  </div>

<br><br>

<button type="button" class="btn btn-primary">Approve</button>
<button type="button" class="btn btn-danger">Reject</button>

</lf:form>
<br><br>
<a href="${pageContext.request.contextPath}/home" >Back</a>




<jsp:include page="footer.jsp"/>
</body>
</html>