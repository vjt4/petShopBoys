package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class LoginDAO {
	private UsersDAO uDAO = new UsersDAO();
	
	public Users getUser(String username , String password) {
		Session ses = HibernateUtil.getSession();
		Users user = (Users) ses.createQuery("FROM Users U WHERE U.username = :username AND U.password = :password")
				.setParameter("username", username)
				.setParameter("password", password)
				.uniqueResult();
		
		
		System.out.println("Hibernate object");
		HibernateUtil.closeSession();
		
		if(user.getUsername().equals(username) && (user.getPassword().equals(password)))
			return user;
		else
			return null;
	}
	
	public void updateToActive(String username) {
		Session ses = HibernateUtil.getSession();

		Users u = uDAO.getUserByUsername(username);
		Transaction tr = ses.beginTransaction();
		u.setActive(true);

		System.out.println("User: " + username + " is now active !");
		
		tr.commit();
		
		HibernateUtil.closeSession();
	}
	
	public void updateToInactive(String username) {
		Session ses = HibernateUtil.getSession();

		Users u = uDAO.getUserByUsername(username);
		Transaction tr = ses.beginTransaction();
		u.setActive(false);

		System.out.println("User: " + username + " is now active !");
		
		tr.commit();
		
		HibernateUtil.closeSession();
	}
	

}
