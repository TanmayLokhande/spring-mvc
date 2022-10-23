package com.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.Teacher1Dao;
import com.practice.entities.Teacher1;
import com.practice.helper.FactoryProvider;

/**
 * Servlet implementation class addTeacher
 */
@WebServlet("/addTeacher")
public class addTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTeacher() {
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
		
		String tname = request.getParameter("tname");
		
		Teacher1 t = new Teacher1();
		t.settName(tname);
		
		Teacher1Dao tdao = new Teacher1Dao(FactoryProvider.getFactory());
		
		int teacher_id = tdao.addTeacher(t);
		
		out.print(teacher_id);
				
	}

}
