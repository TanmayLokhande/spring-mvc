package com.tan.Dao;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tan.entities.Category;
import com.tan.helper.FactoryProvider;

public class CategoryDao {
	
	
	private SessionFactory factory;

	public CategoryDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public int saveCategory(Category category) {
		int catId = -1;
		Session session = FactoryProvider.getFactory().openSession();
		 try {
			
			 
			 Transaction tx = session.beginTransaction();
			 
			 catId = (int)session.save(category);
			 
			 tx.commit();
			 session.close();
			 

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.close();
		
		}
		 return catId;
		
	}
	
	
	public List<Category> getCategories(){
		
		Session session = this.factory.openSession();
		
		Query query = session.createQuery("from Category");
		
		List<Category> list = query.list();
		
		return list;
		
	}
	
}
