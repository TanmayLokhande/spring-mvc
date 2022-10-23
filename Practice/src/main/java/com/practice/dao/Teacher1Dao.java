package com.practice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.entities.Branch;
import com.practice.entities.Subject;
import com.practice.entities.Teacher1;

public class Teacher1Dao {

	private SessionFactory factory;

	public Teacher1Dao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public int addTeacher( Teacher1 t ) {
		int teacher_id = -1;
		
		Session session = this.factory.openSession();
		Transaction tx = session.beginTransaction();
		teacher_id = (int)session.save(t);
		tx.commit();
		session.close();
		return teacher_id;
	}
	
	public List<Teacher1> getAllteachers(){
		
		Session session = this.factory.openSession();
		List<Teacher1> teachers = null;
		Query query = session.createQuery("from Teacher1");
			
		teachers = query.list();
		
		session.close();
			
		return teachers;
		
	}
	
	public void updateteacher( int t_id,int s_id) {
		Session session = this.factory.openSession();
		Teacher1 t = session.get(Teacher1.class, t_id);
		Subject s = session.get(Subject.class, s_id);
		
		List<Subject> subjects = t.getSubjects();
		List<Teacher1> teachers = s.getTeacher();
		
		if( subjects.size() == 0 || subjects == null ) {
			subjects = new ArrayList<>();
			subjects.add(s);
		}
		else {
			subjects.add(s);
		}
		
		if( teachers.size() == 0 || teachers == null ) {
			teachers = new ArrayList<>();
			teachers.add(t);
		}
		else {
			teachers.add(t);
		}
		
		t.setSubjects(subjects);
		s.setTeacher(teachers);
		
		Transaction tx = session.beginTransaction();
		
		session.save(t);
		session.save(s);
		
		tx.commit();
		session.close();
	}
	
}
