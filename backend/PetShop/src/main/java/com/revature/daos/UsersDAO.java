package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class UsersDAO implements UsersInterface{

	@Override
	public void newUser(Users newUser) {

		Session ses = HibernateUtil.getSession();
		
		ses.save(newUser);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public List<Users> getAllUsers() {

		Session ses = HibernateUtil.getSession();
		
		List<Users> userList = ses.createQuery("from Users").list();
		
		HibernateUtil.closeSession();
		
		return userList;
		
	}

	@Override
	public Users getUserById(int users_id) {

		Session ses = HibernateUtil.getSession();
		
		Users user = ses.get(Users.class, users_id);
		
		HibernateUtil.closeSession();
		
		return user;
		
	}

	@Override
	public Users getUserByUsername(String username) {

		Session ses = HibernateUtil.getSession();
		
		//need a query here instead of using ses.get()
		//Query query = ses.createQuery("from Users where username = :username").setParameter("username", username);
		Users u =  (Users) ses.createQuery("from Users where username = :username")
				.setParameter("username", username).uniqueResult();
		
		HibernateUtil.closeSession();
		
//		Users result = (Users) query.uniqueResult();
//		return result;
		
		return u;
		
	}

	@Override
	public void removeUser(Users user) {

		Session ses = HibernateUtil.getSession();
		
		ses.delete(user);
		
		HibernateUtil.closeSession();
		
	}
	
	@Override
	public boolean isPresent(String username) {
		
		Session ses = HibernateUtil.getSession();
		boolean isPresent = false;
		
		List<Users> userList = ses.createQuery("from Users").list();		
		for(Users u : userList) {
			
			if(u.getUsername().compareTo(username) == 0) {
				
				isPresent = true;
				
			}
			
		}
		
		HibernateUtil.closeSession();
		
		return isPresent;
		
	}

	
	
}
