package com.kodnest.fifthHibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student name, email and phone");
        KodnestStudent kodnestStudent = new KodnestStudent(sc.next(), sc.next(), sc.next());
        System.out.println("Enter Student address of city, street, state and zipcode");
        Address address = new Address(sc.next(), sc.next(), sc.next(), sc.next());
        
        kodnestStudent.setAddress(address);
        
        // Step 1 & 2: Load the configuration and Create session factory
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Step 3: Open session
        Session session = factory.openSession();
        
        // Step 4: Begin transaction
        Transaction transaction = session.beginTransaction();
        
        // Step 5: Perform operation
        session.persist(kodnestStudent);
        
        // Step 6: Commit transaction
        transaction.commit();
        
        // Step 7: Close session and factory
        session.close();
        factory.close(); 
    }
}