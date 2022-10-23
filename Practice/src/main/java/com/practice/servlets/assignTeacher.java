package com.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import com.practice.dao.SubjectDao;
import com.practice.dao.Teacher1Dao;
import com.practice.helper.FactoryProvider;

/**
 * Servlet implementation class assignTeacher
 */
@WebServlet("/assignTeacher")
public class assignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignTeacher() {
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
		
		int t_id = Integer.parseInt(request.getParameter("t_Id"));
		int s_id = Integer.parseInt(request.getParameter("s_Id"));
		
		Teacher1Dao tdao = new Teacher1Dao(FactoryProvider.getFactory());
		SubjectDao sdao = new SubjectDao(FactoryProvider.getFactory());
		
		tdao.updateteacher(t_id, s_id);
		
		out.print("success");
		
		
	}

}
