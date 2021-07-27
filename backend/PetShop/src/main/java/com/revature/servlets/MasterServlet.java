package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;
import com.revature.controllers.UserController;
import com.revature.models.LoginDTO;

public class MasterServlet extends HttpServlet{
	
	//Controllers go here
	private UserController userController = new UserController();
	private LoginController loginController = new LoginController();
	
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("application/json");
		res.setStatus(404);
		
		String URI = req.getRequestURI().replace("/Project1/", "");
		
		
		switch(URI) {
		case "login":
		{
			System.out.println("in login");
			break;
		}
			
		case "cart":
		{
			System.out.println("in cart");
			break;
		}
		case "user":
		{
			System.out.println("in user");
			userController.getAllUsers(res, req);
			break;
		}
		case "pet":
		{
			System.out.println("in pet");
			
		}
			
		
		}
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		doGet(req, res);
		
	}

}
