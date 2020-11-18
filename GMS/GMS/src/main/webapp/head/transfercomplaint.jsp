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
<style>
<%@ include file="/loginstyle.css"%>
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="header">
		<a href="#" class="logo">Grievance Management System</a>
		<div class="header-right">
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
							<h3>Transfer Complaint to other Department</h3>
						</center></b>

				</caption>
				<br>
				<form action="<%=request.getContextPath()%>/HeadController/transferComplaint">
					<fieldset class="form-group">
						<label>Select the Department :</label>
			 
					<select name="depts" id="depts" class="form-control">
						<option value="water">Water</option>
						<option value="road">Road</option>
						<option value="electricity">Electricity</option>
						<option value="health">Health</option>
					</select>
					<br>
					<center>
						<button type="submit" class="btn btn-success">Transfer
							Complaint</button>
					</center>
				</form>
			</div>
		</div>
	</div>
</body>
</html>