package com.kodnest.seventhHibernate;

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
    	System.out.println("Enter Department name and location:");
    	Department department = new Department(sc.next(), sc.next());
    	
    	System.out.println("Enter Employee name, salary and department:");
    	Employee employee1 = new Employee(sc.next(), sc.next(), department);
    	Employee employee2 = new Employee(sc.next(), sc.next(), department);
    	Employee employee3 = new Employee(sc.next(), sc.next(), department);
    	
    	List<Employee> empList = new ArrayList<Employee>();
    	empList.add(employee1);
    	empList.add(employee2);
    	empList.add(employee3);
    	
    	department.setEmployees(empList);
    	
    	// Step 1 & 2: Load the configuration and Create session factory
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Step 3: Open session
        Session session = factory.openSession();
        
        // Step 4: Begin transaction
        Transaction transaction = session.beginTransaction();
        
        // Step 5: Perform operation
        session.persist(department);
        
        // Step 6: Commit transaction
        transaction.commit();
        
        // Step 7: Close session and factory
        session.close();
        factory.close();		
    }
}
