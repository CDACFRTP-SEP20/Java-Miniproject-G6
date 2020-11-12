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
		<a href="#" class="logo">Greviance Management System</a>
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
	<caption>
		<b><center>
			<h3>Your Complaints </h3>
				</center></b>	
	</caption>
	<br>
	<table border="1" id="table" align="center">
		<tr>
			<th>complaintid</th>
			<th>userid</th>
			<th>deptid</th>
			<th>description</th>
			<th>remark</th>
			<th>status</th>
			<th>Action</th>
		</tr>
		<c:forEach var="complaints" items="${complaints}">

			<tr>
			<!-- user.getUsername(); user.getUserrole() -->
			<td><c:out value="${complaints.cId}"></c:out></td>  
			<td><c:out value="${complaints.userId}"></c:out></td>
			<td><c:out value="${complaints.deptId}"></c:out></td>
			<td><c:out value="${complaints.description}"></c:out></td>
			<td><c:out value="${complaints.userRemark}"></c:out></td>
			<td><c:out value="${complaints.headRemark}"></c:out></td>
			<td><c:out value="${complaints.status}"></c:out></td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<center>
		</center>
	
	
	
	
	
</body>
</html>
