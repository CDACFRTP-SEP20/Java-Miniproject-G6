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
</head>
<body>
	<!-- logic for rendering list...  -->
	<table border="1">
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
</body>
</html>
