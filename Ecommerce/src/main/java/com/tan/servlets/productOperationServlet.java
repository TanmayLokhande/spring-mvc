package com.tan.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;

import com.tan.Dao.CategoryDao;
import com.tan.Dao.ProductDao;
import com.tan.entities.Category;
import com.tan.entities.Product;
import com.tan.helper.FactoryProvider;

/**
 * Servlet implementation class productOperationServlet
 */
@WebServlet("/productOperation")
@MultipartConfig
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
				String pName = request.getParameter("pName");
				String pDesc = request.getParameter("pDesc");
				int pPrice = Integer.parseInt(request.getParameter("pPrice"));
				int pDiscount = Integer.parseInt(request.getParameter("pDiscount"));
				int pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
				int catId = Integer.parseInt(request.getParameter("catId"));
				Part part = request.getPart("pPic");
				
				Product p = new Product();
				p.setpName(pName);
				p.setpDesc(pDesc);
				p.setpPrice(pPrice);
				p.setpDiscount(pDiscount);
				p.setpQuantity(pQuantity);
				p.setpPhoto(part.getSubmittedFileName());
				
				CategoryDao cDao = new CategoryDao(FactoryProvider.getFactory());
				
				Category category = cDao.getCategoryById(catId);
				
				p.setCategory(category);
				
				ProductDao pDao = new ProductDao(FactoryProvider.getFactory());
				
				pDao.saveProduct(p);
				
				String path = request.getRealPath("images")+File.separator + "products" + File.separator + part.getSubmittedFileName()	;
				System.out.println(path);
				
				try {
					FileOutputStream fos = new FileOutputStream(path);
					InputStream is = part.getInputStream();
					
					byte[] data = new byte[is.available()];
					
					is.read(data);
					
					fos.write(data);
					fos.close();
					is.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
				
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Product added successfully ");
				response.sendRedirect("admin.jsp");
				return;

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}

	}

}
