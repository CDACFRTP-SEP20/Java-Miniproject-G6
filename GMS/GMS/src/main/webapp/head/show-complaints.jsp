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
<title>Insert title here</title>
<style>
<%@ include file="/loginstyle.css"%>
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="header">
		<a href="#" class="logo">Grievance Management System</a>
		<div class="header-right">
			 <a href="<%=request.getContextPath()%>/logout.jsp">LOGOUT</a>
		</div>
	</div>
	<!-- logic for rendering list...  -->
	${deletemsg}
	<br><br>
	<caption>
		<b><center>
				<h3>Complaint List</h3>
			</center></b>
	</caption>
	<br>

	<table border="1" id="table" align="center">
		<tr>
			<th>Complaintid</th>
			<th>Username</th>
			<th>Dept Name</th>
			<th>Description</th>
			<th>Remark</th>
			<th>Status</th>
			<th colspan="2" style="text-align:center">Action</th>
		</tr>
		<c:forEach var="complaints" items="${complaints }">
			<tr>
			<!-- user.getUsername(); user.getUserrole() -->
			<td><c:out value="${complaints.cId}"></c:out></td>  
			<td><c:out value="${complaints.username}"></c:out></td>
			<td><c:out value="${complaints.deptName}"></c:out></td>
			<td><c:out value="${complaints.description}"></c:out></td>
			<td><c:out value="${complaints.userRemark}"></c:out></td>
			<td><c:out value="${complaints.status}"></c:out></td>
			<td>
				<a href="<%=request.getContextPath()%>/HeadController/transferComplaintpage?cid=${complaints.cId}">Transfer</a>
			</td>
			<td>
				<a href="<%=request.getContextPath()%>/HeadController/takeAction?cid=${complaints.cId}">Take Action</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<hr>
	<br>
	<caption>
		<b><center>
				<h3>Resolved Complaints</h3>
			</center>
		</b>
	</caption>
	<table border="1" id="table" align="center">
		<tr>
			<th>Complaintid</th>
			<th>Username</th>
			<th>Dept Name</th>
			<th>Description</th>
			<th>Remark</th>
			<th>Status</th>
		</tr>
		<c:forEach var="complaint" items="${resolvedComplaints }">
			<tr>
			<!-- user.getUsername(); user.getUserrole() -->
			<td><c:out value="${complaint.cId}"></c:out></td>  
			<td><c:out value="${complaint.username}"></c:out></td>
			<td><c:out value="${complaint.deptName}"></c:out></td>
			<td><c:out value="${complaint.description}"></c:out></td>
			<td><c:out value="${complaint.userRemark}"></c:out></td>
			<td><c:out value="${complaint.status}"></c:out></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>