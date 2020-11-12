<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%=request.getRemoteUser() %>
<% 
session.setAttribute("citizenname",request.getRemoteUser()); 
%>


<a href="<%=request.getContextPath()%>/citizen/register-complaint.jsp">
Register complaint</a>
<a href="<%=request.getContextPath()%>/CitizenController/listcomplaints">
View complaints</a>
<a href="<%=request.getContextPath()%>/logout.jsp">Logout</a>


</body>
</html>
