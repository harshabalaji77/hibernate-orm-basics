package com.kodnest.thirdHibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the id to delete");
    	int id = sc.nextInt();
    	
    	// Step 1 & 2: Load the configuration and Create session factory
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Step 3: Open session
        Session session = factory.openSession();
        
        // Step 4: Begin transaction
        Transaction transaction = session.beginTransaction();
        
        // Step 5: Perform operation
        Student obj = session.find(Student.class, id);
        if (obj != null) {
        	session.remove(obj);
        	System.out.println("Student deleted successfully!");
        }
        else {
        	System.out.println("Student doesn't exist.");
        }
        
        // Step 6: Commit transaction
        transaction.commit();
        
        // Step 7: Close session and factory
        session.close();
        factory.close();
    }
}
