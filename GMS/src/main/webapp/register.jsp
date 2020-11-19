<jsp:include page="loginHeader.jsp"/>
	<br>

	<div class="container col-md-5" style="height:700px">
		<div class="card">
			<div class="card-body">

				<br>


				<caption>
					<b><center>
							<h3>Registration Form</h3>
						</center></b>

				</caption>
				<br>

				                        <form name="registration" form
                              action="<%=request.getContextPath()%>/CitizenController/registercitizen">

                              <fieldset class="form-group">
                                    <label>Name<span class="text-danger">*</span></label> <input type="text" class="form-control"
                                          name="username" id="username" pattern="[A-Za-z]{1,10}" minlength="3" required="required">
                              </fieldset>


                              <fieldset class="form-group">
                                    <label>Password<span class="text-danger">*</span></label> <input type="password"
                                          class="form-control" name="password" id="password" minlength="8" maxlength="8" required="required">
                              </fieldset>


                              <fieldset class="form-group">
                                    <label>Email<span class="text-danger">*</span></label> <input type="text" class="form-control"
                                          name="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required="required">
                              </fieldset>

                              <fieldset class="form-group">
                                    <label>Phone no.<span class="text-danger">*</span></label> <input type="tel" class="form-control"
                                          name="phoneNo" id="phoneno" pattern="[7-9]{1}[0-9]{9}" minlength="10" maxlength="10" required="required">
                              </fieldset>


                              <fieldset class="form-group">
                                    <label>Address<span class="text-danger">*</span></label> <input type="tel" class="form-control"
                                          name="address" id="address" required="required">
                              </fieldset>



                              <button type="submit" class="btn btn-success" onclick="validate()">Register</button>
                              <button type="reset" class="btn btn-danger">Reset</button>
                              <br>
                              <a href="<%=request.getContextPath()%>/AppController" >Already registered? Sign up</a>
                        </form>

			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>



