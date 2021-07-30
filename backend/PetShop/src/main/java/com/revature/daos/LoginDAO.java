package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class LoginDAO {
	private UsersDAO ud = new UsersDAO();
	
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
//		Users user =  (Users) ses.createQuery("Update Users U set U.active = true WHERE U.username = :username")
//				.setParameter("username", username)
//				.uniqueResult();
		
		Users u = ud.getUserByUsername(username);
		System.out.println(u.toString() + "  ===========before change");
		u.setActive(true);
		System.out.println(u.toString() + "  ===========after change");
		ses.merge(u);
		//ses.save(u);
		System.out.println(u.toString() + "  ===========after merge");
		
		
		System.out.println("User: " + username + " is now active !");
		
		
		HibernateUtil.closeSession();
	}
	

}
