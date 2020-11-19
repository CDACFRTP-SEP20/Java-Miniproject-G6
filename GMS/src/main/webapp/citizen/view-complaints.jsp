<%@page import="com.gms.model.Complaint"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/loginstyle.css"%></style>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<div class="header">
		<a href="#" class="logo">Grievance Management System</a>
		<div class="header-right">
		<a href="<%=request.getContextPath()%>/citizen/register-complaint.jsp">
		REGISTER COMPLAINTS
		</a>
				<a href="<%=request.getContextPath()%>/logout.jsp">LOGOUT</a>
		</div>
	</div>
	<!-- logic for rendering list...  -->
	<br>
	<br>
	<div style="height:500px">
	<caption>
		<b><center>
			<h3>Your Complaints </h3>
				</center></b>	
	</caption>
	<br>
	<table border="1" id="table" align="center">
		<tr>
			<th>Complaint Id</th>
			<th>Username</th>
			<th>Dept Id</th>
			<th>Description</th>
			<th>Remark</th>
			<th>Status</th>
		</tr>
		<c:forEach var="complaints" items="${complaints}">
			<tr>
			<td><c:out value="${complaints.cId}"></c:out></td>  
			<td><c:out value="${complaints.username}"></c:out></td>
			<td><c:out value="${complaints.deptName}"></c:out></td>
			<td><c:out value="${complaints.description}"></c:out></td>
			<td><c:out value="${complaints.userRemark}"></c:out></td>
			<td><c:out value="${complaints.status}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	</div>	
</body>
<jsp:include page="../footer.jsp"/>
</html>
 