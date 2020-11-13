<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Greviance Management System</title>

<style>
<%@include file="/loginstyle.css"%>
</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="header">
		<a href="#default" class="logo">Grievance Management System</a>
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
							<h3>Registration Form</h3>
						</center></b>

				</caption>
				<br>

				<form form
					action="<%=request.getContextPath()%>/CitizenController/registercitizen">

					<fieldset class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							name="username" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="email" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Phone no.</label> <input type="tel" class="form-control"
							name="phoneNo" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Address</label> <input type="tel" class="form-control"
							name="address" required="required">
					</fieldset>



					<button type="submit" class="btn btn-success">Register</button>
					<button type="reset" class="btn btn-danger">Reset</button>
					<br> <a href="<%=request.getContextPath()%>/AppController">Already
						registered? Sign up</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>



