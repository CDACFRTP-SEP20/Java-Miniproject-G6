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
		<a href="#default" class="logo">Grievance Management System</a>
		<div class="header-right">
		</a>
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
							<h3>Add Head </h3>
						</center></b>
				</caption>
				<br>
				<form form action="<%=request.getContextPath()%>/AdminController/addhead">               
                        
                              <fieldset class="form-group">
                                    <label>Username<span class="text-danger">*</span></label> <input type="text" class="form-control"
                                          name="username" pattern="[A-Za-z]{1,10}" minlength="3" required="required">
                              </fieldset>


                              <fieldset class="form-group">
                                    <label>Password<span class="text-danger">*</span></label> <input type="password"
                                          class="form-control" name="password" required="required">
                              </fieldset>


                              <fieldset class="form-group">
                                    <label>Email<span class="text-danger">*</span></label> <input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" class="form-control"
                                          name="email" required="required">
                              </fieldset>

                              <fieldset class="form-group">
                                    <label>Phone no.<span class="text-danger">*</span></label> <input type="tel" class="form-control"
                                          name="phoneno"  pattern="[7-9]{1}[0-9]{9}" minlength="10" maxlength="10" required="required">
                              </fieldset>


                              <fieldset class="form-group">
                                    <label>Address<span class="text-danger">*</span></label> <input type="text" class="form-control"
                                          name="address" required="required">
                              </fieldset>

                              <fieldset class="form-group">
                        <label>Select Department<span class="text-danger" required>*</span></label> 
                                          <select
                                          name="dept" id="dept" class="form-control">
                                          <option value="water">Water</option>
                                          <option value="road">Road</option>
                                          <option value="electricity">Electricity</option>
                                          <option value="health">Health</option>
                                    </select>
                              </fieldset>
                              <button type="submit" class="btn btn-success">Add Head</button>
                        </form>

			</div>
		</div>
	</div>
</body>
	<jsp:include page="../footer.jsp"/>
</html>