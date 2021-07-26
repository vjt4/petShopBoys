package com.revature.daos;

import java.util.List;

import com.revature.models.Users;

public interface UsersInterface {

	public void newUser (Users newUser);
	
	public List<Users> getAllUsers();
	
	public Users getUserById(int users_id);
	
	public Users getUserByUsername(String username);
	
	public void removeUser(Users user);
	
}
