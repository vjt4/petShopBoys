package com.revature.daos;

import com.revature.models.Cart;

public interface CartInterface {

	public void newCart(Cart newCart);
	
	public Cart getCartById(int cart_id);
	
	public void addToCart(int animal_id);
	
	public void removeFromCart(int animal_id);
	
	public void updateCart(Cart cart);
	
	public void purchase(Cart cart);
	
	public void showTotal(double total);
	
}
