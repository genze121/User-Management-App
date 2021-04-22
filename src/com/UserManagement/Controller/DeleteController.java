package com.UserManagement.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.UserManagement.Model.UserManagementDAO;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserManagementDAO userManagementDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteController() {
		super();
		userManagementDAO = new UserManagementDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("uid"));

		boolean finalDelete = userManagementDAO.deleteUsers(id);
		HttpSession session = request.getSession();
		if (finalDelete) {
			session.setAttribute("SuccessMessage", "Users deleted successfully.......");
			response.sendRedirect("showUsers.jsp");
		} else {
			session.setAttribute("ErrorMessage", "Something went Wrong.Please try again.......");
			response.sendRedirect("showUsers.jsp");
		}

	}

}
