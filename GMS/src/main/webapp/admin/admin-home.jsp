<%@page import="com.gms.model.Users"%>
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
<title>Heads list</title>
</head>
<body>

	<div class="header">
		<a href="#" class="logo">Greviance Management System</a>
		<div class="header-right">
				<a href="<%=request.getContextPath()%>/logout.jsp">Logout</a>
		</div>
	</div>
	<br>
	<!-- logic for rendering list...  -->
	<h4>${deletemsg}</h4>
	
	<table border="1" id="table">
		<tr>
			<th>Username</th>
			<th>Email</th>
			<th>Phone No</th>
			<th>Address</th>
			<th>Dept Id</th>
			<th>Action</th>
		</tr>
		<c:forEach var="user" items="${heads}">




			<tr>
				<!-- user.getUsername(); user.getUserrole() -->

				<td><c:out value="${user.username}"></c:out></td>
				<td><c:out value="${user.email}"></c:out></td>
				<td><c:out value="${user.phoneNo}"></c:out></td>
				<td><c:out value="${user.address}"></c:out></td>
				<td><c:out value="${user.deptId}"></c:out></td>
				<td><a
					href="<%=request.getContextPath()%>/AdminController/deletehead?username=${user.username}">delete</a>
				
				&nbsp<a
					href="<%=request.getContextPath()%>/AdminController/edithead?username=${user.username}">update</a>
				</td>
			</tr>

		</c:forEach>

	</table>
	<br>
	<center>
	<a href="<%=request.getContextPath()%>/admin/add-head.jsp"><button class="btn btn-warning">add head</button></a>
	</center>
</body>
</html>