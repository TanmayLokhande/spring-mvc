package com.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entities.Branch;
import com.practice.helper.FactoryProvider;

/**
 * Servlet implementation class addClass
 */
@WebServlet("/addBranch")
public class addClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addClass() {
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
		
		String classname = request.getParameter("bname");
		
		Branch b = new Branch();
		b.setBranch_name(classname);
		
		Session session = FactoryProvider.getFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		int bid = (int)session.save(b);
		
		tx.commit();
		session.close();
		out.print(bid);
	}

}
