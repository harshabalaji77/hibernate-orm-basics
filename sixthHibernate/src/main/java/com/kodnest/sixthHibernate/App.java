package com.kodnest.sixthHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter Course name:");
        Course course1 = new Course(sc.next());
        Course course2 = new Course(sc.next());
        Course course3 = new Course(sc.next());
        
        System.out.println("Enter Student name, email and phone:");
        KodnestStudent kodnestStudent = new KodnestStudent(sc.next(), sc.next(), sc.next());
        
        course1.setKodnestStudent(kodnestStudent);
        course2.setKodnestStudent(kodnestStudent);
        course3.setKodnestStudent(kodnestStudent);
        
        List<Course> courseList = new ArrayList<Course>();
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        
        kodnestStudent.setCourses(courseList);
        
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
