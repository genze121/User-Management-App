<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>User Management App</title>
<style type="text/css">
.header-design {
	font-family: galindo;
	text-shadow: 1px 1px black;
	font-size: 25px;
}

.card-header-color {
	background-color: #d88f5b !important;
}

.log-button-design {
	font-family: galindo;
}

.form-log-design {
	font-family: galindo;
}

.message {
	font-family: galindo;
	font-size: 15px;
}
</style>
</head>
<body style="background: #0aa888;">
	<%@include file="all_Component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header card-header-color">
						<h4 class="text-center text-light header-design">
							<i class='fa fa-user'></i> User Management - Login
						</h4>
						<%
							String error = (String) session.getAttribute("errorMssg");
						if (error != null) {
						%>
						<div class="alert alert-danger message" role="alert">
							<%=error%>
						</div>
						<%
							session.removeAttribute("errorMssg");
						}
						%>
						<%
							String logout = (String) session.getAttribute("logoutMssg");
						if (logout != null) {
						%>
						<div class="alert alert-danger message" role="alert">
							<%=logout%>
						</div>
						<%
							session.removeAttribute("logoutMssg");
						}
						%>

					</div>
					<div class="card-body">
						<form action="login" method="post">

							<div class="form-group form-log-design">
								<label for="exampleInputEmail1">Username</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="username"
									placeholder="Enter email" required> <small
									id="emailHelp" class="form-text text-muted">We'll never
									share your email with anyone else.</small>
							</div>
							<div class="form-group form-log-design">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" name="password_"
									id="exampleInputPassword1" placeholder="Password" required>
							</div>

							<div class="log-button-design">
								<button type="submit"
									class="btn badge-pill btn-lg btn-block btn-success">Submit</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_Component/footer.jsp"%>
</body>
</html>