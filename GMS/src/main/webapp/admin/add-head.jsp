<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
<%@include file="/loginstyle.css"%></style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<div class="header">
		<a href="#default" class="logo">Greviance Management System</a>
		<div class="header-right">
		</a>
			<a href="<%=request.getContextPath()%>/logout.jsp">LOGOUT</a>
		</div>
	</div>
	<br>
		
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<br>
				<caption>
					<b><center>
							<h3>Add Head </h3>
						</center></b>
				</caption>
				<br>
				<form form action="<%=request.getContextPath()%>/AdminController/addhead">			
				
					<fieldset class="form-group">
						<label>Username</label> <input type="text" class="form-control"
							name="username" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Email</label> <input type="email" class="form-control"
							name="email" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Phone no.</label> <input type="tel" class="form-control"
							name="phoneno" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Address</label> <input type="text" class="form-control"
							name="address" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Role</label> <input type="text" class="form-control"
							name="role" required="required">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Department Id</label> <input type="number" class="form-control"
							name="deptid" required="required">
					</fieldset>
					<button type="submit" class="btn btn-success">Add Head</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>