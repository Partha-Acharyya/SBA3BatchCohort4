<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<jsp:include page="header.jsp" />
<spring:form action="rd-confirm" method="post"
			modelAttribute="rdInputDto">

			<table>
			<tr>
					
							<td><label>Transfer from account</label></td>
							<td><select name="AccountNumber">
									<c:forEach var="balan" items="${accountBalance}">
										<option value="${balan.accountNumber}">${balan.accountNumber}</option>
									</c:forEach>
							</select></td>
						
				</tr>
				<tr>
					<td><spring:label path="investmentAmount">investment Amount</spring:label></td>
					<td><spring:input path="investmentAmount" type="text" name="investmentAmount" /></td>
				</tr>
				<tr>
					<td><spring:label path="tenure">tenure in months</spring:label></td>
					<td><spring:input path="tenure" type="number" name="tenure" /></td>
				</tr>
				<%
				//Calendar cal = Calendar.getInstance();
				//cal.add(Calendar.MONTH, tenure);
				//Date maturitydate=getDate(cal);
				
				LocalDate maturitydate = LocalDate.now().plusMonths(tenure);
				%>
				<tr>
					<td><spring:label path="maturityDate">maturityDate</spring:label></td>
					<td><spring:input path="maturityDate" type="date" id="maturityDate" value=<%=maturitydate %>
							name="maturityDate" /></td>
				</tr>
				<tr>
					<td><spring:label path="monthlyDebitDate">monthly DebitDate</spring:label></td>
					<td><spring:input path="monthlyDebitDate" type="number" min="1" max="31"
							
							name="monthlyDebitDate" /></td>
				</tr>
				
				

				<tr>
					<td><button  onClick="${pageContext.request.contextPath}/user/account" >Back</button></td>
					<td><input type="submit" value="Apply Now" /></td>
					
				</tr>

			</table>

		</spring:form>
		<jsp:include page="footer.jsp" />
		</div>
</body>
</html>