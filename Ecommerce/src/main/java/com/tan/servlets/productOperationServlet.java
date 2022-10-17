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

import com.tan.Dao.CategoryDao;
import com.tan.entities.Category;
import com.tan.helper.FactoryProvider;

/**
 * Servlet implementation class productOperationServlet
 */
@WebServlet("/productOperation")
public class productOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public productOperationServlet() {
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

		try {

			String op = request.getParameter("operation");

			if (op.trim().equals("addCategory")) {
				String catTitle = request.getParameter("catTitle");
				String catDescription = request.getParameter("catDescription");

				Category category = new Category();
				category.setCategoryTitle(catTitle);
				category.setCategoryDescription(catDescription);

				CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());

				int catId = categoryDao.saveCategory(category);

				System.out.println(catId);

				HttpSession httpSession = request.getSession();
				if (catId == -1) {
					httpSession.setAttribute("message", "Category already exists");
				}
				else {
					httpSession.setAttribute("message", "Category added successfully " + catId);
				}
				
				response.sendRedirect("admin.jsp");
				return;

			} else if (op.trim().equals("addProduct")) {

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}

	}

}
