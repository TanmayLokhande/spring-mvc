package com.tan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tan.Dao.UserDao;
import com.tan.entities.User;
import com.tan.helper.FactoryProvider;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao(FactoryProvider.getFactory());
		User user = userDao.getUserByEmailAndPassword(email, password);
		
		HttpSession httpSession = request.getSession();
		
		
		if( user == null ) {	
			
			httpSession.setAttribute("message","Invalid Details" );
			response.sendRedirect("login.jsp");
		}else {
			out.println("<h1>Welcome " + user.getUserName()  + "</h1>");
			
			httpSession.setAttribute("current_user", user);
			
			if( user.getUserType().equals("admin") ) {
				response.sendRedirect("admin.jsp");
			}
			else if( user.getUserType().equals("normal") ) {
				response.sendRedirect("normal.jsp");
			}
			else {
				out.println("We have not identified user type");
			}
			
		}
		
	}
		


}
