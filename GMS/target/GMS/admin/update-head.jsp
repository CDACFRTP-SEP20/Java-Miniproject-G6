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
	Updating user
	<form method="post"
		action="<%=request.getContextPath()%>/AdminController/updatehead">
		Username: <input type="text" name="username" value="${user.username}" readonly="readonly"> <br>
		Password: <input type="password" name="password" value="${user.password}"> <br>
		Email:	<input type="text" name="email" value="${user.email}"> <br>
		Phone No:	<input type="text" name="phoneno" value="${user.phoneNo}"> <br>
		Address:	<input type="text" name="address" value="${user.address}"> <br>
		Dept Id:  <input type="number" name="deptid" value="${user.deptId}"> <br> 
		Role: <input type="text" name="role" value="${user.role}"> <br> 
		<input type="submit" value="Update Head">
	</form>
</body>
</html>