package com.UserManagement.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UserManagement.Bean.UserBean;
import com.UserManagement.Model.LoginDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginDAO loginDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		loginDAO = new LoginDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password_");

		UserBean user = loginDAO.loginUsers(username, password);
		HttpSession session = request.getSession();
		if (user != null) {
			System.out.println("User Details is available:- " + user);
			session.setAttribute("user", user);
			response.sendRedirect("home.jsp");
		} else {
			System.out.println("User Details is not available:- " + user);
			session.setAttribute("errorMssg", "Invalid Username or Password...");
			response.sendRedirect("login.jsp");
		}
	}

}
