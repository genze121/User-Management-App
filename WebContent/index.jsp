<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>User Management App</title>

<style type="text/css">
.index-image {
	width: 100%;
	background-attachment: fixed;
	background-size: cover;
	background-repeat: no-repeat;
	height: 70vh;
}

.index-text {
	font-family: galindo;
	text-shadow: 1px 1px 1px black;
	text-transform: uppercase;
	
}
</style>
</head>
<body>
	<%@include file="all_Component/navbar.jsp"%>
	<div class="index-text mt-4">
		<h2 class="text-center">
			<i class='fa fa-plug'></i> Welcome To User Management App
		</h2>
	</div>
	<div class="container-fluid">
		<img alt="index-screen" class="index-image" src="images/index.jpg">
	</div>

	<%@include file="all_Component/footer.jsp"%>
</body>
</html>