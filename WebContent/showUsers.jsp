<%@page import="com.UserManagement.Bean.UserManagementBean"%>
<%@page import="java.util.List"%>
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
.table-design {
	font-family: galindo;
	font-size: 20px;
}

.table .thead-design th {
	color: #fff;
	background-color: #e81744;
	border-color: #FF8888;
}

.text-show {
	font-family: galindo;
	font-size: 35px;
	text-transform: uppercase;
	text-decoration: underline;
}

.message-text-show {
	font-family: galindo;
	font-size: 20px;
}

.tab-design {
	text-transform: uppercase;
}
</style>


</head>
<body style="background: #889191;">
	<%@include file="all_Component/navbar.jsp"%>

	<%
		if (user == null) {
		session.setAttribute("errorMssg", "Please login....");
		response.sendRedirect("login.jsp");
	}
	%>


	<%
		String success = (String) session.getAttribute("SuccessMessage");
	String error = (String) session.getAttribute("ErrorMessage");

	if (success != null) {
	%>
	<div class="alert alert-success message-text-show" role="alert">
		<%=success%>
	</div>
	<%
		session.removeAttribute("SuccessMessage");
	}

	if (error != null) {
	%>
	<div class="alert alert-danger message-text-show" role="alert">
		<%=error%>
	</div>
	<%
		}
	session.removeAttribute("ErrorMessage");
	%>
	<div class="container">
		<div class="row mt-5">
			<div class="container">
				<h3 class="text-center text-show">
					<i class='fa fa-address-book-o'></i> Show users information
				</h3>
			</div>
			<table class="table table-bordered table-hover table-design mt-5">
				<thead class="thead-design">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Country</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>

				<%
					if (user != null) {
					UserManagementDAO userManagementDAO = new UserManagementDAO();
					List<UserManagementBean> lists = userManagementDAO.getAllUsers(user.getId());

					for (UserManagementBean users : lists) {
				%>
				<tbody>
					<tr>
						<td><%=users.getId()%></td>
						<td><%=users.getName()%></td>
						<td><%=users.getEmail()%></td>
						<td><%=users.getCountries()%></td>

						<td class="tab-design"><a
							href="editUsers.jsp?uid=<%=users.getId()%>"
							style="color: #12e5d3;"> Edit </a>&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?uid=<%=users.getId()%>" style="color: #12e5d3;">
								Delete </a></td>
					</tr>
				</tbody>
				<%
					}
				}
				%>

			</table>
		</div>
	</div>
	<%@include file="all_Component/footer.jsp"%>
</body>
</html>