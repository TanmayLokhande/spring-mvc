package com.tan.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Student student = session.get(Student.class, 101);
		
		System.out.println(student);
		
		session.close();
		factory.close();
	}
	
	
}
