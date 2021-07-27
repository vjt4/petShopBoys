package com.revature.services;

import java.util.List;

import com.revature.daos.UsersDAO;
import com.revature.daos.UsersInterface;
import com.revature.models.Users;

public class UserService {

	private UsersInterface uDAO = new UsersDAO();
	
	public void newUser(Users newUser) {
		uDAO.newUser(newUser);
	}
	
	public List<Users> getAllusers(){
		return uDAO.getAllUsers();
	}
	
	public Users getUserById(int users_id) {
		return uDAO.getUserById(users_id);
	}
	
	public Users getUserByUsername(String username) {
		return uDAO.getUserByUsername(username);
	}
	
	public void removeUser(Users user) {
		uDAO.removeUser(user);
	}
	
}
