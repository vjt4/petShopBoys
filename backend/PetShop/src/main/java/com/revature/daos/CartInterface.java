package com.revature.daos;

import com.revature.models.Animals;
import com.revature.models.Cart;

public interface CartInterface {

	public void newCart(Cart newCart);
	
	public void addToCart(Animals animal_id);
	
	public void removeFromCart(Animals animal_id);
	
	public void purchase(Cart cart);
	
	public void showTotal(double total);
	
	public void removeCart(Cart cart);
	
}
