package com.sudhir.HibernateCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.sudhir.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	static SessionFactory sessionFactoryObj;
	 private static SessionFactory buildSessionFactory() {
		 
		         // Creating Configuration Instance & Passing Hibernate Configuration File
		         Configuration configObj = new Configuration();
		         configObj.configure("hibernate.cfg.xml");
		         ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
		         sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		         return sessionFactoryObj;
		     }

    public static void main( String[] args )
    {
    	Session session=buildSessionFactory().openSession();
    	Transaction tx=session.beginTransaction();
    	Employee employee=new Employee();
    	employee.setEmpAddress("chennai");
    	employee.setEmpName("sudhir");
    	session.save(employee);
    	tx.commit();
        System.out.println( "Hello World!" );
    }
}
