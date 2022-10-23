package com.practice.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Array;

import com.practice.helper.FactoryProvider;

public class map {

	public static void main(String[] args) {

		Session session = FactoryProvider.getFactory().openSession();
		
		
		Branch b = session.get(Branch.class, 1);
	
		
		String hql = "FROM Student1 E WHERE E.branch = 1";
		Query query = session.createQuery(hql);
		List<Student1> results = query.list();
		
		
		Student1 s = results.get(0);
		
		System.out.println(s.getStudent_name());
		
//		Transaction tx = session.beginTransaction();
//	
//		session.save(t);
//	
//		tx.commit();
		
		session.close();
		
	}

}
