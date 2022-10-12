package com.tan.tut;

import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void main( String[] args ) throws IOException {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    
	    Student st = new Student();
	    st.setId(101);
	    st.setName("Tanmay");
	    st.setCity("Amt");
	    
	    System.out.println(st);
	    
	    
	    Address ad = new Address();
	    ad.setStreet("Street1");
	    ad.setCity("Delhi");
	    ad.setOpen(true);
	    ad.setAddedDate(new Date());
	    ad.setX(1234.45);
	    
	    FileInputStream fis = new FileInputStream("src/main/java/Photo (2).jpeg");
	    byte[] data = new byte[fis.available()];
	    fis.read(data);
	    ad.setImage(data);
	    
	    Session session = factory.openSession();
	
	    Transaction tx = session.beginTransaction();
	    
	    session.save(st);
	    session.save(ad);
	     
	    tx.commit();
	    
	    session.close();
	    System.out.println("Done...");
	}
    
}
