package com.sudhir.HibernateCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.sudhir.entity.Employee;

public class CacheTest {
	static SessionFactory sessionFactoryObj;
	 private static SessionFactory buildSessionFactory() {
		         // Creating Configuration Instance & Passing Hibernate Configuration File
		         Configuration configObj = new Configuration();
		         configObj.configure("hibernate.cfg.xml");
		         ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
		         sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		         return sessionFactoryObj;
		     }
	public static void main(String[] args) {
		Session session=buildSessionFactory().openSession();
		session.get(Employee.class, 1);
		System.out.println("first done");
		//session.get(Employee.class, 1);
		session.close();
		Session session1=sessionFactoryObj.openSession();
		session1.get(Employee.class, 1);
		//session1.get(Employee.class, 1);
		System.out.println("second done");
		session1.close();
	}

}
