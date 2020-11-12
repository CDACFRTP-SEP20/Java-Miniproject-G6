<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Register complaint
	<%String username=request.getParameter("username");
	  session.setAttribute("username",username);
	  //session.setAttribute("userId",userId);
	%>

	<form
		action="<%=request.getContextPath()%>/CitizenController/registercomplaint">
		Description: <input type="text" name="description"> <br>
		Remark: <input type="text" name="remark"> <br> 
		<label for="dept">Dept Name:</label> 
		<select name="dept" id="dept">
			<option value="water">Water</option>
			<option value="road">Road</option>
			<option value="electricity">Electricity</option>
		</select> <br>
		Upload Screenshot: <input type="file" name="screenshot"/><br>
		 <input type="submit" value="Register complaint">

	</form>
</body>
</html>
