package com.tan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tan.entities.User;
import com.tan.helper.FactoryProvider;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Session session = FactoryProvider.getFactory().openSession();

		try {

			String userName = request.getParameter("user_name");
			String userEmail = request.getParameter("user_email");
			String userPassword = request.getParameter("user-password");
			String userPhone = request.getParameter("user-phone");
			String userAddress = request.getParameter("user_address");

			if (userName.isEmpty()) {
				out.println("name is blank");
				return;
			}

			User user = new User(userName, userEmail, userPassword, userPhone, "default.png", userAddress, "normal");

			

			Transaction tx = session.beginTransaction();

			int userId = (int) session.save(user);

			tx.commit();
			session.close();

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Registration Successfull !! " + userId);

			response.sendRedirect("register.jsp");
			return;

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			
			session.close();
			
			HttpSession httpsession = request.getSession();
			httpsession.setAttribute("message","User already exists");

			response.sendRedirect("register.jsp");

		}

	}

}
