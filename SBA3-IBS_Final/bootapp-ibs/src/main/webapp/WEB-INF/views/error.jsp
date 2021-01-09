<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<head>
<title>error page</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
<div align="center">
		<h4>Sorry an exception occured! : <c:out value="${message}"></c:out></h4> 
</div>
	<jsp:include page="footer.jsp" />
</body>
</html>