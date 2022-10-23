package com.practice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.entities.Branch;
import com.practice.entities.Subject;

public class SubjectDao {

	private SessionFactory factory;

	public SubjectDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public List<Subject> getAllSubjects(){
		
		Session session = this.factory.openSession();
		List<Subject> subjects = null;
		Query query = session.createQuery("from Subject");
			
		subjects = query.list();
		
		session.close();	
			
		return subjects;
		
	}
	
}
