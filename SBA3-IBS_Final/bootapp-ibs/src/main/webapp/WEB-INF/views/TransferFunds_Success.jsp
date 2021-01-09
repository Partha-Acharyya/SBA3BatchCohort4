<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Transaction Successful</title>
</head>

<body>
	
<jsp:include page="header.jsp" />
	<jsp:include page="navbar.jsp" />
	<div align="center">

	
	
	<h6>Transaction Successful- Debitted amount from ${AccountStatementOutputDto.accountNumber} and credited to ${AccountStatementOutputDto.beneficiaryAccountNumber}</h6>
	
	<jsp:include page="footer.jsp" />
</div>
</body>

</html>










