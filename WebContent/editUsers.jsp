<%@page import="com.UserManagement.Bean.UserManagementBean"%>
<%@page import="com.UserManagement.Model.UserManagementDAO"%>
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
	background: #15eadf !important;
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
<body style="background: #b78680;">
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
							<i class='fa fa-edit'></i> User Management - Edit Users
						</h4>
					</div>
					<div class="card-body">
						<form action="updateUsers" method="post">
							<%
								int userid = Integer.parseInt(request.getParameter("uid"));
							UserManagementDAO userManagementDAO = new UserManagementDAO();
							UserManagementBean userManagementBean = userManagementDAO.getUsersById(userid);
							%>
							<%
								if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userId">
							<%
								}
							%>

							<%
								if (userManagementBean != null) {
							%>
							<input type="hidden" value="<%=userManagementBean.getId()%>"
								name="uid">
							<%
								}
							%>

							<div class="form-group form-add-design">
								<label for="exampleInputName1">Name</label> <input type="text"
									class="form-control" name="name" id="exampleInputName1"
									value="<%=userManagementBean.getName()%>"
									placeholder="Enter name">
							</div>

							<div class="form-group form-add-design">
								<label for="exampleInputEmail1">Email</label> <input
									type="email" class="form-control" name="email"
									value="<%=userManagementBean.getEmail()%>"
									id="exampleInputEmail1" placeholder="Enter email">
							</div>

							<div class="form-group form-add-design">
								<label for="exampleFormControlSelect1">Country</label> <select
									class="form-control" name="countries"
									id="exampleFormControlSelect1">
									<option><%=userManagementBean.getCountries()%></option>
									<option>India</option>
									<option>Australia</option>
									<option>Spain</option>
									<option>Portugal</option>
									<option>Canada</option>
									<option>USA</option>
									<option>UK</option>
									<option>America</option>
									<option>Argentina</option>
								</select>
							</div>

							<div class="add-button-design mt-4">
								<button type="submit"
									class="btn badge-pill btn-lg btn-block btn-warning">Update
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