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
<h2> Add Loan Types</h2>

<lf:form method = "POST" action = "">
<div class="form-check">
  <label class="form-check-label">
  
   <lf:radiobutton class="form-check-input" path = "type" />
   Home Loan
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <lf:radiobutton class="form-check-input" path = "type" />Education Loan
  </label>
</div>
<div class="form-check disabled">
  <label class="form-check-label">
    <lf:radiobutton class="form-check-input" path = "type" />Personal Loan
  </label>
</div>

<div class="form-check disabled">
  <label class="form-check-label">
     <lf:radiobutton class="form-check-input" path = "type" />Vehicle Loan
  </label>
</div>

<br><br>
<button type="button" class="btn btn-primary">Submit</button>
<button type="button" class="btn btn-danger">Clear</button>
</lf:form>

<br><br>
<a href="${pageContext.request.contextPath}/home" >Back</a>
<jsp:include page="footer.jsp"/>
</body>
</html>