<html>
<head>
<style><%@include file="/loginstyle.css"%></style>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

</head>
<body>

<div class="header">
  <a href="#" class="logo">Grievance Management System</a>
  <div class="header-right">
    <a href="<%=request.getContextPath()%>/AppController" >LOGIN</a>
  </div>
</div>
	<img alt="background-image" src="images/background-home.jpg" style="opacity:0.5;height:auto;width:100%;"/>
<br>

	<jsp:include page="footer.jsp"/>
</body>
</html>