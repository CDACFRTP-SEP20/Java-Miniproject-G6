<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/loginstyle.css"%></style>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<a href="#" class="logo">Greviance Management System</a>
		<div class="header-right">
		<a href="<%=request.getContextPath()%>/citizen/register-complaint.jsp">
			REGISTER COMPLAINTS</a>
		<a href="<%=request.getContextPath()%>/CitizenController/listcomplaints">
			YOUR COMPLAINTS</a>
		<a href="<%=request.getContextPath()%>/logout.jsp">LOGOUT</a>
		</div>
	</div>
	
	<br>
	
	<br>
	<marquee behavior="alternate">
	<h3>
	welcome
		<%=request.getRemoteUser() %>
		 
		<% 
		session.setAttribute("citizenname",request.getRemoteUser()); 
		%>
	</h3>
	</marquee>
</body>
</html>
