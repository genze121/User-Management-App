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
	background-color: cyan !important;
}

.reg-button-design {
	font-family: galindo;
}

.form-design {
	font-family: galindo;
}

.message {
	font-family: galindo;
	font-size: 15px;
}
</style>
</head>
<body style="background: #60439e;">
	<%@include file="all_Component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-1">
					<div class="card-header card-header-color">
						<h4 class="text-center header-design">
							<i class='fa fa-user-plus'></i> User Management - Registration
						</h4>

						<%
							String check = (String) session.getAttribute("checkMssg");
						String success = (String) session.getAttribute("successMssg");
						String error = (String) session.getAttribute("errorMssg");

						if (check != null) {
						%>
						<div class="alert alert-danger message" role="alert">
							<%=check%>
						</div>
						<%
							session.removeAttribute("checkMssg");
						}

						if (success != null) {
						%>
						<div class="alert alert-success message" role="alert">
							<%=success%>
						</div>
						<%
							session.removeAttribute("successMssg");
						}

						if (error != null) {
						%>
						<div class="alert alert-danger message" role="alert">
							<%=error%>
						</div>
						<%
							session.removeAttribute("errorMssg");
						}
						%>
					</div>
					<div class="card-body">
						<form action="register" method="post">
							<div class="form-group form-design">
								<label for="exampleInputFirst1">First Name</label> <input
									type="text" class="form-control" name="first_name"
									id="exampleInputFirst1" placeholder="Enter first name" required>
							</div>
							<div class="form-group form-design">
								<label for="exampleInputLast1">Last Name</label> <input
									type="text" class="form-control" name="last_name"
									id="exampleInputLast1" placeholder="Enter last name" required>
							</div>
							<div class="form-group form-design">
								<label for="exampleInputEmail1">Username</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="username"
									placeholder="Enter email" required> <small
									id="emailHelp" class="form-text text-muted">We'll never
									share your email with anyone else.</small>
							</div>
							<div class="form-group form-design">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" name="password_"
									id="exampleInputPassword1" placeholder="Password" required>
							</div>
							<div class="form-group form-check form-design">
								<input type="checkbox" class="form-check-input" name="checkBox"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">I agree the terms and conditions</label>
							</div>
							<div class="reg-button-design">
								<button type="submit"
									class="btn badge-pill btn-lg btn-block btn-danger">Submit</button>
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