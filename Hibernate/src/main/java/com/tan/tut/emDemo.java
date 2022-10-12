package com.tan.tut;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class emDemo {
	
	public static void main( String[] args ) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(1421);
		student1.setName("TanmayLik");
		student1.setCity("mumbai");
		
		Certificate certi = new Certificate();
		certi.setCourse("web");
		certi.setDuration("2 months");
		
		
		student1.setCerti(certi);
		
		
		Student student2 = new Student();
		student2.setId(1422);
		student2.setName("Tanmaylokhande");
		student2.setCity("mumbai");
		
		Certificate certi1 = new Certificate();
		certi.setCourse("hiber");
		certi.setDuration("1 months");
		
		
		student2.setCerti(certi1);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		session.close();
		factory.close();
		
	}
}
