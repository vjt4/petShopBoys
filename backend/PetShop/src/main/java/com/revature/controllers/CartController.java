package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.CartDAO;
import com.revature.models.Cart;
import com.revature.models.CartDTO;
import com.revature.services.CartService;

public class CartController {

	private CartDAO cDAO = new CartDAO();
	private CartService cs = new CartService();
	private ObjectMapper om = new ObjectMapper();
	
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
		
		Cart newCart = new Cart();
		
		cDAO.newCart(newCart);
		
	}
	
}
