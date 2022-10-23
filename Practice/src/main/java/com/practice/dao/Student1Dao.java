package com.practice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.entities.Branch;
import com.practice.entities.Student1;

public class Student1Dao {

	private SessionFactory factory;

	public Student1Dao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	
	public int addStudent( Student1 student,int branch_id ) {
		
		int student_id = -1;
		
		Session session = this.factory.openSession();
		
		Branch b = session.get(Branch.class, branch_id);
		student.setBranch(b);
		
		List<Student1> students = b.getStudents();
		
		if( students == null ) {
			students = new ArrayList<>();
			students.add(student);
		}
		else {
			students.add(student);
		}
		
		Transaction tx = session.beginTransaction();
		
		student_id = (int)session.save(student);
		session.save(b);
		
		
		tx.commit();
		session.close();
		
		return student_id;
	}
	
	public List<Student1> getAllStudents(){
		
		Session session = this.factory.openSession();
		List<Student1> students = null;
		Query query = session.createQuery("from Student1");
			
		students = query.list();
		
		session.close();	
			
		return students;
		
	}
	
}
