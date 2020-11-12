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
	${deletemsg}

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
		<c:forEach var="complaints" items="${complaints }">
			<tr>
				<!-- user.getUsername(); user.getUserrole() -->
				<td><c:out value="${complaints.cId}"></c:out></td>
				<td><c:out value="${complaints.userId}"></c:out></td>
				<td><c:out value="${complaints.deptId}"></c:out></td>
				<td><c:out value="${complaints.description}"></c:out></td>
				<td><c:out value="${complaints.userRemark}"></c:out></td>
				<td><c:out value="${complaints.headRemark}"></c:out></td>
				<td><c:out value="${complaints.status}"></c:out></td>
				<td><a
					href="<%=request.getContextPath()%>/HeadController/deleteuser?cid=${complaints.cid}">Transfer</a>
					<select name="dept" id="dept">
						<option value="1">Water</option>
						<option value="2">road</option>
						<option value="3">health</option>
						<option value="4">Electricity</option>
				</select></td>
				<td><a
					href="<%=request.getContextPath()%>/HeadController/edituser?cid=${user.username}">change
						status</a></td>
			</tr>
		</c:forEach>

	</table>
	<a href="<%=request.getContextPath()%>/logout.jsp">Logout</a>
</body>
</html>
