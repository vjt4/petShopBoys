package com.revature.services;

import com.revature.daos.CartDAO;
import com.revature.daos.CartInterface;
import com.revature.models.Cart;

public class CartService {

	private CartInterface cDAO = new CartDAO();
	
	public void newCart(Cart newCart) {
		cDAO.newCart(newCart);
	}
	
	public Cart getCartById(int cart_id) {
		return cDAO.getCartById(cart_id);
	}
	
	public void addToCart(int animal_id) {
		cDAO.addToCart(animal_id);
	}
	
	public void removeFromCart(int animal_id) {
		cDAO.removeFromCart(animal_id);
	}
	
	public void updateCart(Cart cart) {
		cDAO.updateCart(cart);
	}
	
	public void purchase(Cart cart) {
		cDAO.purchase(cart);
	}
	
	public void showTotal(double total) {
		cDAO.showTotal(total);
	}

	public void updateUser(Cart newCart) {
		cDAO.updateUser(newCart);
		
	}

	public void updateCartTotal(double totalCost) {
		cDAO.updateCartTotal(totalCost);
		
	}

	public void checkout() {
		cDAO.checkout();
		
	}
	
}
