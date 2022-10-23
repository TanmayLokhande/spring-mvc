package com.practice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.practice.entities.Branch;

public class BranchDao {

	private SessionFactory factory;

	public BranchDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public List<Branch> getAllBranches(){
		
		Session session = this.factory.openSession();
		List<Branch> list = null;
		Query query = session.createQuery("from Branch");
			
		list = query.list();
		
		session.close();	
			
		return list;
		
		
	}
	
}


