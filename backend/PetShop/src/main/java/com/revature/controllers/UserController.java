package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UsersDAO;
import com.revature.models.AccountDTO;
import com.revature.models.Users;
import com.revature.services.UserService;

public class UserController {

	private UsersDAO uDAO = new UsersDAO();
	private UserService us = new UserService();
	private ObjectMapper om = new ObjectMapper();
	
	public void createAccount(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		AccountDTO aDTO = om.readValue(body,  AccountDTO.class);
		
		if(!uDAO.isPresent(aDTO.getUsername())) {
			
			Users newUser = new Users(aDTO.getUsername(), aDTO.getPassword(), aDTO.getFirstName(), aDTO.getLastName(), aDTO.getEmail(), aDTO.isAdmin());
			
			uDAO.newUser(newUser);
			
			res.setStatus(201);
			
			res.getWriter().print("Account successfully created!");		
			
		}
	
	}
	
	public void getAllUsers(HttpServletResponse res) throws IOException {
		
		List<Users> userList = us.getAllUsers();
		
		String json = om.writeValueAsString(userList);
		
		res.getWriter().print(json);
		
		res.setStatus(200);
		
	}
	
}
