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
<title>Heads list</title>
</head>
<body>
	<!-- logic for rendering list...  -->
	${deletemsg}
	<a href="<%=request.getContextPath()%>/admin/add-head.jsp">add head</a>
	<table border="1">
		<tr>
			<th>Username</th>
			<th>Email</th>
			<th>Phone No</th>
			<th>Address</th>
			<th>Dept Id</th>
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
				</td>
				<td><a
					href="<%=request.getContextPath()%>/AdminController/edithead?username=${user.username}">update</a>
				</td>
			</tr>

		</c:forEach>

	</table>
	<br>
	<a href="<%=request.getContextPath()%>/logout.jsp">Logout</a>
</body>
</html>