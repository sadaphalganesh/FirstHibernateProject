package com.ganesh.test;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ganesh.Address;
import com.ganesh.UserDetails;
import com.ganesh.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("RAMESH");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("car");
		
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleName("jeep");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle1);
		
		vehicle.getUsers().add(user);
		vehicle1.getUsers().add(user);
		
		
		SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		//session.save(user1);
		session.save(vehicle);
		session.save(vehicle1);
		session.getTransaction().commit();
		session.close();
		
		
	
		/*Address address1=new Address();		
		address1.setCity("pune");
		address1.setState("maharashtra");
		address1.setPinCode(413999);
		
		Address address2=new Address();		
		address2.setCity("mumbai");
		address2.setState("maharashtra");
		address2.setPinCode(872999);
		
		user.getListOfAddresses().add(address1);
		user.getListOfAddresses().add(address2);*/
		
		/*Address homeAddress=new Address();		
		homeAddress.setCity("pune");
		homeAddress.setState("maharashtra");
		homeAddress.setPinCode(413999);
		user.setHomeAddress(homeAddress);
		
		Address officeAddress=new Address();		
		officeAddress.setCity("mumbai");
		officeAddress.setState("maharashtra");
		officeAddress.setPinCode(872999);
		user.setOfficeAddress(officeAddress);*/
		
		//ONE-TO-ONE MAPPING
		/*Vehicle vehicle=new Vehicle();
		user.setVehicle(vehicle);
		
	
		vehicle.setVehicleName("Car");
	*/
	}
}
