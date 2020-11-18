<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
<%@ include file="/loginstyle.css"%>
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<a href="#" class="logo">Grievance Management System</a>
		<div class="header-right">
			<a
				href="<%=request.getContextPath()%>/citizen/register-complaint.jsp">
				REGISTER COMPLAINT</a> <a
				href="<%=request.getContextPath()%>/CitizenController/listcomplaints">
				YOUR COMPLAINTS</a> <a href="<%=request.getContextPath()%>/logout.jsp">LOGOUT</a>
		</div>
	</div>
	<br>
	
		<h3 style="text-align:center;">
			Welcome <%=request.getRemoteUser()%>
			<%
				session.setAttribute("citizenname", request.getRemoteUser());
			%>
		</h3>
	<br>
	<center>
	<div class="row">
  		<div class="col-sm-6">
		<div class="container ">
			<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
				<div class="card-header"><b>Water Department</b></div>
				<div class="card-body">
					<p class="card-text">You can register water related complaints.</p>
				</div>
			</div>
		</div>
		</div>
		<div class="col-sm-6">
		<div class="container ">
			<div class="card bg-light mb-3" style="max-width: 18rem;">
				<div class="card-header"><b>Road Department</b></div>
				<div class="card-body">
					<p class="card-text">You can register road related complaints.</p>
				</div>
			</div>
		</div>
		</div>
		</div>
		<div class="row">
  		<div class="col-sm-6">
		<div class="container">
			<div class="card bg-light mb-3" style="max-width: 18rem;">
				<div class="card-header"><b>Electricity Department</b></div>
				<div class="card-body">
					<p class="card-text">You can register electricity related complaints.</p>
				</div>
			</div>
		</div>
		</div>
		<div class="col-sm-6">
		<div class="container">
			<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
				<div class="card-header"><b>Health Department</b></div>
				<div class="card-body">
					<p class="card-text">You can register health related complaints.</p>
				</div>
			</div>
		</div>
		</div>
		</div>
	</center>
</body>
</html>
