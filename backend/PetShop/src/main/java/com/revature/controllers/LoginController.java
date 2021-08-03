package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.Users;
import com.revature.services.LoginService;
import com.revature.services.UserService;

public class LoginController {
	
	ObjectMapper om = new ObjectMapper();
	private LoginService ls = new LoginService();
	private UserService us = new UserService();
	
	public void login(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		if(req.getMethod().equals("POST")) {
			
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			
			LoginDTO lDTO = om.readValue(body, LoginDTO.class);
			
			if(ls.login(lDTO.username, lDTO.password)) {
				
				HttpSession ses = req.getSession();
				
				ses.setAttribute("user", lDTO);
				
				ses.setAttribute("LoggedIn", true);
				
				ls.updateToActive(lDTO.username);
				
				res.setStatus(200);
				
				Users user = us.getUserByUsername(lDTO.username);
				
				String json = om.writeValueAsString(user);
				
				res.getWriter().print(json);
				//res.getWriter().print("Login was successful");
				
				//need to return a user object that the user/password are referring to
				
			} else {
				
				HttpSession ses = req.getSession(false);
				
				if(ses != null) {
					ses.invalidate();
				}
				
				res.setStatus(401);
				res.getWriter().print("Login was unsuccessful");
				
			}
			
		}
		
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		BufferedReader reader = req.getReader();
//		
//		StringBuilder sb = new StringBuilder();
//		
//		String line = reader.readLine();
//		
//		while(line != null) {
//			sb.append(line);
//			line = reader.readLine();
//		}
//		
//		String body = new String(sb);
//		
//		LoginDTO lDTO = om.readValue(body, LoginDTO.class);
		
		//ls.updateToInactive(lDTO.username);
		ls.updateToInactive();
		
		res.setStatus(200);
		
		
		
	}

}
