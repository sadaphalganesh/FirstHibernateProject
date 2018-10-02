package com.HBnateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cascade.User;

public class HBNTest {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		SessionFactory sessionFactory= cfg.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		//CRUD operations are done using session objects
		
		/*//CREATE ......
		UserDetails userDetails;
		for(int i=1;i<=10;i++) {
		
			userDetails=new UserDetails();
			userDetails.setUserName("User>>"+i);
			session.save(userDetails);
			}
			*/
		
		
		/*
		//READ....SELECT...
		//dont forget to change hbm2ddl as update here
		UserDetails user=session.get(UserDetails.class, 2);
		System.out.println(user.getUserName());
		*/
		/*
		//DELETE...
		//First pullup the object and then apply delete
		UserDetails user=session.get(UserDetails.class, 4);
		session.delete(user);
		*/
		
		
		//UPDATE.....
		//first pull up the object to be replaced and then apply update
		
		UserDetails user=session.get(UserDetails.class, 2);
		user.setUserName("updated user");
		session.update(user);
		
		
		//following code is common for all operations
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
