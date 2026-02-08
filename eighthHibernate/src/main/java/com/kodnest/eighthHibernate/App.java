package com.kodnest.eighthHibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Student s1 = new Student("Harsha", "harsha@mail.com");
        Student s2 = new Student("Akash", "akash@mail.com");
        Student s3 = new Student("Manohar", "manohar@mail.com");
        
        Club c1 = new Club("CollegeRadio");
        Club c2 = new Club("CollegeSports");
        Club c3 = new Club("CollegeNSS");
        
        Set<Club> clubSet1 = new HashSet<Club>();
        clubSet1.add(c1);
        clubSet1.add(c2);
        
        Set<Club> clubSet2 = new HashSet<Club>();
        clubSet2.add(c2);
        clubSet2.add(c3);
        
        Set<Club> clubSet3 = new HashSet<Club>();
        clubSet3.add(c1);
        clubSet3.add(c3);
        
        s1.setClubs(clubSet1);
        s2.setClubs(clubSet2);
        s3.setClubs(clubSet3);
        
     // Step 1 & 2: Load the configuration and Create session factory
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Step 3: Open session
        Session session = factory.openSession();
        
        // Step 4: Begin transaction
        Transaction transaction = session.beginTransaction();
        
        // Step 5: Perform operation
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);
        session.persist(c1);
        session.persist(c2);
        session.persist(c3);
        
        // Step 6: Commit transaction
        transaction.commit();
        
        // Step 7: Close session and factory
        session.close();
        factory.close(); 
    }
}