<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Adding new head
	<form action="<%=request.getContextPath()%>/AdminController/addhead">
		
		Username: <input type="text" name="username"> <br>
		Password: <input type="password" name="password"> <br>
		Email:	<input type="text" name="email"> <br>
		Phone No:	<input type="text" name="phoneno"> <br>
		Address:	<input type="text" name="address"> <br>
		Role:  <input type="text" name="role"> <br> 
		Dept Id:  <input type="number" name="deptid"> <br> 
		<input type="submit" value="Add Head">

	</form>
</body>
</html>