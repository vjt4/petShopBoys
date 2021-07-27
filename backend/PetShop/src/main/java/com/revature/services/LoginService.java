package com.revature.services;

import com.revature.models.Users;

public class LoginService {

	public boolean login(String username, String password) {
		
		UserService userService = new UserService();
		
		Users user = userService.getUserByUsername(username);
		
		if(password.equals(user.getPassword())) {
			return true;
		}
		
		return false;
		
	}
	
}
