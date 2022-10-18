package com.tan.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tan.entities.Product;

public class ProductDao {
	
	private SessionFactory factory;

	public ProductDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public boolean saveProduct( Product product ) {
		boolean flag = false;
		try {
			
			Session session = this.factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(product);
			
			tx.commit();
			session.close();
			
			flag = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
		}
		
		return true;
		
	}
	
	public List<Product> getAllProducts(){
		
		Session session = this.factory.openSession();
		Query q = session.createQuery("from Product");
		
		List<Product> list = q.list();
		
		return list;
	}

}
