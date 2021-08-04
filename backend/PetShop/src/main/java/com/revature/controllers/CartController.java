package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Animals;
import com.revature.models.AnimalsDTO;
import com.revature.models.Cart;
import com.revature.models.CartDTO;
import com.revature.services.AnimalService;
import com.revature.services.CartService;
import com.revature.services.UserService;

public class CartController {

	private CartService cs = new CartService();
	private ObjectMapper om = new ObjectMapper();
	private UserService us = new UserService();
	private AnimalService as = new AnimalService();
	
	public void newCart(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		CartDTO cDTO = om.readValue(body, CartDTO.class);
		
		Cart newCart = new Cart(Integer.parseInt(cDTO.getId()),Double.parseDouble(cDTO.getTotal()));
		
		cs.newCart(newCart);
		
		//Gets active user (Should only have one active at a time)
		//Updates User cart fk with the new cart
		cs.updateUser(newCart);
		
		String json = om.writeValueAsString(newCart);
		res.setContentType("application/json");
		res.getWriter().print(json);
		
	}
	
	public void deleteCart(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		
	}

	public void assignCart(HttpServletRequest req, HttpServletResponse res)throws IOException {
		
		
		
		
	}

	public void addToCart(HttpServletRequest req, HttpServletResponse res)throws IOException {
		
		//Get JSON (animal objects)
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		String body = new String(sb);
		
		
		
		//Convert JSON into a list of animal DTO's
		List<AnimalsDTO> aDTO = om.readValue(body, new TypeReference<List<AnimalsDTO>>(){});
		
		
		//Loop through each animal
		double totalCost = 0;
		for(AnimalsDTO a : aDTO) {
			
			
			
			//Getting the price and adding it to the total
			totalCost += Double.parseDouble(a.getPrice());
			
			as.updateAnimalIntoCart(a.getAnimalId());
			
			System.out.println(a.toString());
		}
		
		
		System.out.println("Together they cost: " + totalCost);	
		cs.updateCartTotal(totalCost);
		System.out.println();
		
	}

	public void checkout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("in controller");
		
		BufferedReader reader = req.getReader();
//		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		System.out.println(line + "\n =====================");
		
//		while(line != null) {
//			sb.append(line);
//			line = reader.readLine();
//		}
//		String body = new String(sb);
//		List<AnimalsDTO> aDTO = om.readValue(body, new TypeReference<List<AnimalsDTO>>(){});
//		
//		for(AnimalsDTO a : aDTO) {
//			
//			System.out.println("In for loop");
//			
//			Animals temp = as.getAnimalById(a.getAnimalId());
//			
//			cs.removeFromCart(temp.getAnimalId());
//			System.out.println(a.toString());
//		}
		Animals temp = as.getAnimalById(Integer.parseInt(line));
		System.out.println("Animal: " + temp);
		cs.removeFromCart(temp.getAnimalId());
		
		
		
	}
	
}
