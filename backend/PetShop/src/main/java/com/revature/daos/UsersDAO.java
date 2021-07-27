package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

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
		
		Users user = ses.get(Users.class, username);
		
		HibernateUtil.closeSession();
		
		return user;
		
	}

	@Override
	public void removeUser(Users user) {

		Session ses = HibernateUtil.getSession();
		
		ses.delete(user);
		
		HibernateUtil.closeSession();
		
	}

	
	
}
