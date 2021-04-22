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
 * Servlet implementation class EditController
 */
@WebServlet("/updateUsers")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManagementDAO userManagementDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditController() {
		super();
		userManagementDAO = new UserManagementDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("countries");
		int userId = Integer.parseInt(request.getParameter("userId"));

		UserManagementBean users = new UserManagementBean(id, name, email, country, userId);

		boolean finalUpdated = userManagementDAO.updateUsers(users);
		HttpSession session = request.getSession();
		if (finalUpdated) {
			System.out.println("User Management Info:- " + users);
			session.setAttribute("SuccessMessage", "Users updated successfully.......");
			response.sendRedirect("showUsers.jsp");
		} else {
			System.out.println("User Management No Info:- " + users);
			session.setAttribute("ErrorMessage", "Something went Wrong.Please try again.......");
			response.sendRedirect("editUsers.jsp?uid=" + id);
		}
	}

}
