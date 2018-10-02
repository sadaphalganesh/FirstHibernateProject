package com.HbnateInheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) {
		
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("CAR");
		
		TwoWheeler twoWheeler=new TwoWheeler();
		twoWheeler.setVehicleName("duke");
		twoWheeler.setSteeringHandle("steeringHandle");
		
		FourWheeler fourWheeler=new FourWheeler();
		fourWheeler.setVehicleName("fiat");
		fourWheeler.setSteeringWheel("steeringWheel");
		
		Configuration cfg=new Configuration();
		SessionFactory sessionFactory= cfg.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);		
		
		session.getTransaction().commit();
		session.close();
		
		
	}

	
}
