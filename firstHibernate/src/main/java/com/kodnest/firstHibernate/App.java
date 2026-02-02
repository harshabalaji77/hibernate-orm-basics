package com.kodnest.firstHibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name, marks and email");
        Student s1 = new Student(sc.next(), sc.nextInt(), sc.next());
        
        // Step 1: Load the configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        // Step 2: Create session factory
        SessionFactory factory = configuration.buildSessionFactory();
        
        // Step 3: Open session
        Session session = factory.openSession();
        
        // Step 4: Begin transaction
        Transaction transaction = session.beginTransaction();
        
        // Step 5: Perform operation
        session.persist(s1);
        
        // Step 6: Commit transaction
        transaction.commit();
        
        // Step 7: Close session and factory
        session.close();
        factory.close();
    }
}
