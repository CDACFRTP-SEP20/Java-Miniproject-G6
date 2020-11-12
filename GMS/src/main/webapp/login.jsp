<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/loginstyle.css"%></style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>

<body>
	<div class="header">
		<a href="#" class="logo">Greviance Management System</a>
		<div class="header-right">
			<a href="index.jsp">HOME</a>
		</div>
	</div>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<br>

				<caption>
					<b><center>
							<h3>Login Form</h3>
						</center></b>
				</caption>
				<br>

				<form method="POST" action="j_security_check">

					<fieldset class="form-group">
						<label>Username</label> <input type="text" class="form-control"
							name="j_username" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="j_password" required="required">
					</fieldset>



					<button type="submit" class="btn btn-success">Login</button>
					<button type="reset" class="btn btn-danger">Reset</button>
					<br>
					<a href="register.jsp">New user? Register</a>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
