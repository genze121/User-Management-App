package com.UserManagement.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UserManagement.Bean.UserBean;
import com.UserManagement.Model.RegisterDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegisterDAO registerDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		registerDAO = new RegisterDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String checkbox = request.getParameter("checkBox");
		HttpSession session = request.getSession();
		if (checkbox == null) {
			session.setAttribute("checkMssg", "Please fill up the form......");
			response.sendRedirect("register.jsp");
		} else {

			String firstname = request.getParameter("first_name");
			String lastname = request.getParameter("last_name");
			String username = request.getParameter("username");
			String password = request.getParameter("password_");

			UserBean user = new UserBean();
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setUsername(username);
			user.setPassword(password);

			boolean finalRegister = registerDAO.registerUser(user);
			if (finalRegister) {
				session.setAttribute("successMssg", "Registered successfully.....");
				response.sendRedirect("register.jsp");
			} else {
				session.setAttribute("errorMssg", "Something went wrong.Please try again.....");
				response.sendRedirect("register.jsp");
			}

		}
	}

}
