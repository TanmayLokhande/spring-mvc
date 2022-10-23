package com.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.practice.dao.Student1Dao;
import com.practice.entities.Branch;
import com.practice.entities.Student1;
import com.practice.helper.FactoryProvider;

/**
 * Servlet implementation class addStudent
 */
@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudent() {
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
		PrintWriter out =  response.getWriter();
		
		String sname = request.getParameter("sname");
		int branch_id = Integer.parseInt(request.getParameter("b_Id"));
		
		
		Student1 s = new Student1();
		s.setStudent_name(sname);
		
		Student1Dao sdao = new Student1Dao(FactoryProvider.getFactory());
		int s_id = sdao.addStudent(s,branch_id);
		
		out.print(s_id);
	}

}
