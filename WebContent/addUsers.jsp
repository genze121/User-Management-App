<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>User Management App</title>

<style type="text/css">
.add-button-design {
	font-family: galindo;
}

.card-header-color {
	font-family: galindo;
	background: #ac63ed !important;
}

.form-add-design {
	font-family: galindo;
}

.message-text {
	font-family: galindo;
	font-size: 20px;
}
</style>
</head>
<body style="background: #329175;">
	<%@include file="all_Component/navbar.jsp"%>
	<%
		if (user == null) {
		session.setAttribute("errorMssg", "Please Login....");
		response.sendRedirect("login.jsp");
	}
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header card-header-color">
						<h4 class="text-center">
							<i class='fa fa-plus-circle'></i> User Management - Add Users
						</h4>

						<%
							String success = (String) session.getAttribute("successMessage");
						String error = (String) session.getAttribute("errorMessage");

						if (success != null) {
						%>
						<div class="alert alert-success message-text" role="alert">
							<%=success%>
						</div>
						<%
							session.removeAttribute("successMessage");
						}

						if (error != null) {
						%>
						<div class="alert alert-danger message-text" role="alert">
							<%=error%>
						</div>
						<%
							}
						session.removeAttribute("errorMessage");
						%>

					</div>
					<div class="card-body">
						<form action="addUsers" method="post">
							<%
								if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userId">
							<%
								}
							%>

							<div class="form-group form-add-design">
								<label for="exampleInputName1">Name</label> <input type="text"
									class="form-control" name="name" id="exampleInputName1"
									placeholder="Enter name">
							</div>

							<div class="form-group form-add-design">
								<label for="exampleInputEmail1">Email</label> <input
									type="email" class="form-control" name="email"
									id="exampleInputEmail1" placeholder="Enter email">
							</div>

							<div class="form-group form-add-design">
								<label for="exampleFormControlSelect1">Country</label> <select
									class="form-control" name="countries"
									id="exampleFormControlSelect1">
									<option>India</option>
									<option>Australia</option>
									<option>Spain</option>
									<option>Portugal</option>
									<option>Canada</option>
									<option>Argentina</option>
									<option>USA</option>
									<option>UK</option>
									<option>America</option>
								</select>
							</div>

							<div class="add-button-design mt-4">
								<button type="submit"
									class="btn badge-pill btn-lg btn-block btn-primary">Add
									Users</button>
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