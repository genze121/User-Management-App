<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>User Management App</title>
<style type="text/css">
.home-image {
	width: 100%;
	background: url("images/users.png") no-repeat center;
	background-size: 800px;
	height: 395px;
}

.home-text {
	font-family: galindo;
	text-shadow: 1px 1px 1px black;
	text-transform: uppercase;
}

.button-home {
	font-family: galindo;
	text-shadow: 1px 1px 1px black;
	text-transform: uppercase;
}
</style>
</head>
<body>
	<%@include file="all_Component/navbar.jsp"%>
	
	<%
		if (user == null) {
		session.setAttribute("errorMssg", "Please login....");
		response.sendRedirect("login.jsp");
	}
	%>

	<div class="home-image"></div>
	<div class="mt-4">
		<h3 class="text-center home-text">Start Taking User's Information</h3>
	</div>

	<div class="text-center mt-5 button-home">
		<a href="addUsers.jsp" class="btn btn-outline-info btn-lg"> Start
			Here</a>
	</div>

	<%@include file="all_Component/footer.jsp"%>
</body>
</html>