package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Populate;
import com.revature.controllers.AnimalController;
import com.revature.controllers.LoginController;
import com.revature.controllers.UserController;
//import com.revature.models.LoginDTO;

@SuppressWarnings("serial")
public class MasterServlet extends HttpServlet{
	
	//Controllers go here
	private AnimalController ac = new AnimalController();
	private UserController uc = new UserController();
	private LoginController lc = new LoginController();
	private Populate populate = new Populate();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("application/json");
		
		res.setStatus(404);
		
		String URI = req.getRequestURI().replace("/PetShop/", ""); //Change URI if your project name is different
		
		switch(URI) {
		
			
		case "user":
		{
			System.out.println("Get list of users");
			uc.getAllUsers(req, res);
			break;
		}
		case "pet":
		{
			//returns all of the pets
			System.out.println("Get list of pets");
			ac.getAllAnimals(req, res);
			break;
		}
			
		
	}
		
	}
	
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("application/html");
		
		res.setStatus(404);
		
		String URI = req.getRequestURI().replace("/PetShop/", ""); //Change URI if your project name is different
		
		switch(URI) {
		
		case "create-account":
		{
			//create user works
			System.out.println("Create Account");
			uc.createAccount(req, res);
			break;
		}
		
		case "login":
		{
			//login works
			System.out.println("Login to account");
			lc.login(req, res);
			break;
		}
			
		case "cart":
		{
			System.out.println("in cart");
			break;
		}
		case "populate":
		{
			//This is to populate an empty db
			System.out.println("Populating tables");
			populate.please();
			break;
		}
		case "pet-by-species":
		{
			//gets pet by species : dog,cat,fish exist
			System.out.println("Get list of pets by species");
			ac.getAnimalsBySpecies(req, res);
			break;
		}
			
		
	}
		
	}

}