package com.HibernateMap.Main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.HibernateMap.model.Account;
import com.HibernateMap.model.Employee;

public class EmployeeAccountAssociation {
		 
	    public static void main(String[] args) {
	    	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
		      
		    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
		    Session session=factory.openSession(); 
		      
		    Transaction t= session.beginTransaction();  
	 
	        Account account = new Account();
	        account.setAcc_Number("123-345-65454");
	 
	        // Add new Employee object
	        Employee emp = new Employee();
	        
	        emp.setEmailId("subhopaul999@gmail.com");
	        emp.setFirstName("Subho");
	        emp.setLastName("user");
	        
	        Query query=session.createQuery("update Employee set emailId=:emailId where firstName=:firstName");
	        query.setString("emailId", "subho8892@yahoo.com");
	        query.setString("firstName", "Subho");
	        int modifications = query.executeUpdate();
	        
	        // Save Account
	        session.saveOrUpdate(account);
	        // Save Employee
	        emp.setAccount(account);
	        session.persist(emp);
	 
	        t.commit();
	        session.close();
	        System.out.println("Saved in DB");
	    }
}
