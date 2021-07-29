package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Animals;
import com.revature.models.Cart;
import com.revature.utils.HibernateUtil;

public class CartDAO implements CartInterface{

	AnimalsDAO aDAO = new AnimalsDAO();
	CartDAO cDAO = new CartDAO();
	
	@Override
	public void newCart(Cart newCart) {

		Session ses = HibernateUtil.getSession();
		
		ses.save(newCart);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public Cart getCartById(int cart_id) {

		Session ses = HibernateUtil.getSession();
		
		Cart cart = ses.get(Cart.class, cart_id);
		
		HibernateUtil.closeSession();
		
		return cart;
		
	}
	
	
	@Override
	public void updateCart(Cart cart) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.merge(cart);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public void purchase(Cart cart) {

		Session ses = HibernateUtil.getSession();
		
		ses.delete(cart);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public void addToCart(int animal_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromCart(int animal_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showTotal(double total) {
		// TODO Auto-generated method stub
		
	}

}
