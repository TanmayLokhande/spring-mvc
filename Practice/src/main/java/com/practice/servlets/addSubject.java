package com.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.entities.Branch;
import com.practice.entities.Subject;
import com.practice.helper.FactoryProvider;

/**
 * Servlet implementation class addSubject
 */
@WebServlet("/addSubject")
public class addSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSubject() {
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
		
		String subname = request.getParameter("subname");
		int b_Id = Integer.parseInt(request.getParameter("b_Id"));
		
		Subject s = new Subject();
		s.setSub_name(subname);
		
		
		Session session = FactoryProvider.getFactory().openSession();
		
		Branch b = session.get(Branch.class, b_Id);
		s.setBranch(b);

		
		List<Subject> subjects = b.getSubjects();
		
		if( subjects.size() == 0 || subjects == null) {
			subjects = new ArrayList<>();
			subjects.add(s);
		}
		else {
			subjects.add(s);
		}
		
		b.setSubjects(subjects);
				
		Transaction tx = session.beginTransaction();
		
		int sid = (int)session.save(s);
		session.save(b);
		tx.commit();
		session.close();
	}

}
