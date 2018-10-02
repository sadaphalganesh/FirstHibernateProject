package com.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) {
		User user=new User();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("CAR");
		
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("jeep");
		
		user.setUserName("Ganesh");
		
		user.getVehicleList().add(vehicle);
		user.getVehicleList().add(vehicle2);
		
		Configuration cfg=new Configuration();
		SessionFactory sessionFactory= cfg.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("1111");
		session.persist(user);
		//if cascading would not have done we would have to save vehicle objects too....
		
		session.getTransaction().commit();
		session.close();
		
		
	}

	
}
