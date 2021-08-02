package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Populate;
import com.revature.controllers.AnimalController;
import com.revature.controllers.CartController;
import com.revature.controllers.LoginController;
import com.revature.controllers.UserController;
//import com.revature.models.LoginDTO;

@SuppressWarnings("serial")
public class MasterServlet extends HttpServlet{
	
	//Controllers go here
	private AnimalController ac = new AnimalController();
	private CartController cc = new CartController();
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
			//gets a list of all users
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
		
		res.setContentType("text/html");
		
		res.setStatus(404);
		
		String URI = req.getRequestURI().replace("/PetShop/", ""); //Change URI if your project name is different
		
		switch(URI) {
		
		case "create-account":
		{
			//create user works
			System.out.println(URI);
			uc.createAccount(req, res);
			break;
		}
		
		case "login":
		{
			//login works
			System.out.println(URI);
			lc.login(req, res);
			break;
		}
		case "logout":
		{
			//
			System.out.println(URI);
			lc.logout(req, res);
			break;
		}
			
		case "create-cart":
		{
			//Creates new cart, receives cart object for total
			//Then grabs active user and updates his cart fk to new cart id pk
			System.out.println(URI);
			cc.newCart(req, res);
			break;
		}
		case "add-to-cart":
		{
			//takes in animal objects adds their total cost and updates the cart total$
			System.out.println(URI);
			cc.addToCart(req, res);
			break;
		}
		case "checkout":
		{
			//deletes cart, removes animal from database
			System.out.println(URI);
			cc.checkout(req, res);
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
		
		case "pet-by-id":
		{
			//gets pet by id
			System.out.println(URI);
			ac.getAnimalsById(req, res);
			break;
		}
			
		
	}
		
	}

}