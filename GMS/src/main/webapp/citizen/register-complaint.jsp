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

  <script  src="register-complaint.js" type="text/javascript">  </script>
</head>
<body>

<div class="header">
		<a href="#" class="logo">Greviance Management System</a>
		<div class="header-right">
		<a href="<%=request.getContextPath()%>/CitizenController/listcomplaints">
			YOUR COMPLAINTS</a>
		<a href="<%=request.getContextPath()%>/logout.jsp">LOGOUT</a>
		</div>
</div>		
	<br>
	
	<%String username=request.getParameter("username");
	  session.setAttribute("username",username);
	  //session.setAttribute("userId",userId);
	%>
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


				<form name="register-complaint" action="<%=request.getContextPath()%>/CitizenController/registercomplaint">

					<fieldset class="form-group">
						<label>Description:</label> <input type="text" class="form-control"
							name="description" id="description" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Remark:</label> <input type="text"
							class="form-control" id="remark" name="remark" required="required">
					</fieldset>


					<fieldset class="form-group">
						<label for="dept">Dept Name:</label> 
						<select name="dept" id="dept">
						<option value="water">Water</option>
						<option value="road">Road</option>
						<option value="electricity">Electricity</option>
						</select>
					</fieldset>
						 <fieldset class="form-group">
					Upload Screenshot: <input type="file" name="screenshot"/><br>
					</fieldset>

					
					<center>
					<button type="submit" onclick="validate()" class="btn btn-success">Register Complaint</button>
					</center>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
