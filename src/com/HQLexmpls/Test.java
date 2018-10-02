package com.HQLexmpls;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//	HQL is nearly same as SQL only the difference is instead of TABLE name we have the CLASS name
//and instead of column name we have the property names.....
//and instead of resultset(record set) we have the list

public class Test {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		SessionFactory sessionFactory= cfg.configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query<UserDetails> query=(Query) session.createQuery("from UserDetails");
		//pagination
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<UserDetails> list=query.list();
		for(UserDetails u:list) {
			System.out.println(u.getUserName());
		}
		System.out.println(list.size());
		session.getTransaction().commit();
		session.close();
		
	}

	
}
