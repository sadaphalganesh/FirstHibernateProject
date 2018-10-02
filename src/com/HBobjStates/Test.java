package com.HBobjStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//three states of hibernate objects
//transient--->persistent----->detached
public class Test {
	
	public static void main(String[] args) {
		
		//objects those are not tracked by hibernate are transient
		
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("ramesh");
		
		Configuration cfg=new Configuration();
		SessionFactory sessionFactory= cfg.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		//after processing through save method.. objects  are processed(tracked) by hibernate and any changes in it are saved to DB within a scope of hbn session are called PERSISTENT
		
		
		session.save(userDetails);
		//here the above object becomes the persistent
		//NOW Check DB
		
		//eventhough we are saving to the object to db  i.e session.save(obj),and again updating it
		//within the scope of the session the object that goes in the db is the last update call it has got
		
		userDetails.setUserName("ganesh");
		
		//NOW Check DB
		
		session.getTransaction().commit();
		session.close();
		//HERE OBJ become detached...it hbn cannot track it
		//OBJECTS out of hibernate session scope are DETACHED objects
		//no use of updating obj here....it will not be saved in db....
		
		userDetails.setUserName("sarvesh");
		
	}

	
}
