package com.tan.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	
	public static void main( String[] args ) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating question
		
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java");
		
		//Creating answer
		Answer ans = new Answer();
		ans.setAnswerId(343);
		ans.setAnswer("A programming language");
		
		q1.setAnswer(ans);
		
		
		Question q2 = new Question();
		q2.setQuestionId(1213);
		q2.setQuestion("What is colleaction frameworks");
		
		//Creating answer
		Answer ans1 = new Answer();
		ans1.setAnswerId(344);
		ans1.setAnswer("Api to work with objects");
		
		q2.setAnswer(ans1);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		session.save(q2);
		session.save(ans);
		session.save(ans1);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
