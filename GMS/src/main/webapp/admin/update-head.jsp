<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/loginstyle.css"%></style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="header">
		<a href="#default" class="logo">Grievance Management System</a>
		<div class="header-right">
			<a href="<%=request.getContextPath()%>/logout.jsp">LOGOUT</a>
		</div>
	</div>
	<br>

	<div class="container col-md-5" style="height:700px">
		<div class="card">
			<div class="card-body">
				<br>
				<caption>
					<b><center>
							<h3>Update Head </h3>
						</center></b>
				</caption>
				<br>
				<form method="post"
					action="<%=request.getContextPath()%>/AdminController/updatehead">		
						
					<fieldset class="form-group">
						<label>Username</label> <input type="text" class="form-control"
							name="username" value="${user.username}" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" value="${user.password}" name="password" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Email</label> <input type="email" class="form-control"
							value="${user.email}" name="email" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Phone no.</label> <input type="tel" class="form-control"
							value="${user.phoneNo}" name="phoneno" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Address</label> <input type="text" class="form-control"
							value="${user.address}" name="address" required="required">
					</fieldset>

					
					<fieldset class="form-group">
					<!-- 	<label>Department Id</label> <input type="number"
							class="form-control" name="deptid" required="required">  -->
							<select
							name="dept" id="dept" class="form-control">
							<option value="water">Water</option>
							<option value="road">Road</option>
							<option value="electricity">Electricity</option>
							<option value="health">Health</option>
						</select>
					</fieldset>
					<button type="submit" class="btn btn-success">Update Head</button>
				</form>
			</div>
		</div>
	</div>
	</form>	
	
	<jsp:include page="../footer.jsp"/>
</body>
</html>