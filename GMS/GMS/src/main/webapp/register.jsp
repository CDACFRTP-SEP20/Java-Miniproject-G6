<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form method="post"
		action="<%=request.getContextPath()%>/CitizenController/registercitizen">
		Username: <input type="text" name="username"> <br>
		Password: <input type="password" name="password"> <br>
		Email:	<input type="text" name="email" > <br>
		Phone No:	<input type="text" name="phoneno" minlength="10" maxlength="10"> <br>
		Address:	<input type="text" name="address" > <br>
		
		
		<input type="submit" value="Register">
	</form>
</body>
</html>