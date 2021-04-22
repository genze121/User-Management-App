package com.UserManagement.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UserManagement.Bean.UserManagementBean;
import com.UserManagement.Model.UserManagementDAO;

/**
 * Servlet implementation class AddUsersController
 */
@WebServlet("/addUsers")
public class AddUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserManagementDAO userManagementDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUsersController() {
		super();
		userManagementDAO = new UserManagementDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("countries");
		int userid = Integer.parseInt(request.getParameter("userId"));

		UserManagementBean users = new UserManagementBean(name, email, country, userid);

		boolean finalAdded = userManagementDAO.addUsers(users);
		HttpSession session = request.getSession();
		if (finalAdded) {
			session.setAttribute("successMessage", "Users addedd successfully.......");
			response.sendRedirect("addUsers.jsp");
		} else {
			session.setAttribute("errorMessage", "Something went wrong.Please try again......");
			response.sendRedirect("addUsers.jsp");
		}

	}

}
