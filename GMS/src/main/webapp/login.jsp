<jsp:include page="loginHeader.jsp"/>
  <center>  <%  String registerdmsg=(String)session.getAttribute("registerdmsg"); 
      if(registerdmsg != null)
      out.print(registerdmsg);
      session.setAttribute("registerdmsg","");
      %>
</center>
	<br>
	<div class="container col-md-5" style="height:700px">
		<div class="card">
			<div class="card-body">
				<br>

				<caption>
					<b><center>
							<h3>Login Form</h3>
						</center></b>
				</caption>
				<br>
				<form name="loginform" method="POST" action="j_security_check">

					<fieldset class="form-group">
						<label>Username</label> <input type="text" class="form-control"
							name="j_username" id="username"required="required">
					</fieldset>


					<fieldset class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="j_password" id="password" required="required">
					</fieldset>



					<button type="submit" class="btn btn-success" onclick="validate()">Login</button>
					<button type="reset" class="btn btn-danger">Reset</button>
					<br>
					<a href="register.jsp">New user? Register</a>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
