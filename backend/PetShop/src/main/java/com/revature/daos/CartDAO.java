package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.Query;
import com.revature.models.Animals;
import com.revature.models.Cart;
import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class CartDAO implements CartInterface{

	private AnimalsDAO aDAO = new AnimalsDAO();
	private UsersDAO uDAO = new UsersDAO();
		
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
		
		//HibernateUtil.closeSession();
		
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

	@Override
	public void updateUser(Cart id) {
		// Update the user fk with the the cart id pk
		
		
		Session ses = HibernateUtil.getSession();
		
		Users x = uDAO.getActiveUser();
		
		Transaction tr = ses.beginTransaction();
		
		x.setCartId(id);
		tr.commit();
		HibernateUtil.closeSession();
		System.out.println("Updated: "  + x.getUsername() + "'s cart");
		
	}

	@Override
	public void updateCartTotal(double totalCost) {
		// TODO Auto-generated method stub
		
		Users x = uDAO.getActiveUser();
		
		
		Cart c = getCartById(x.getCartId().getCartId());
		
		Session ses = HibernateUtil.getSession();
		Transaction tr = ses.beginTransaction();
		c.setTotal(totalCost);
		tr.commit();
		HibernateUtil.closeSession();
		System.out.println("Updated your cart total to: " + totalCost);
		
		
	}

	@Override
	public void checkout() {
		
		//getting cart by the active user
//		Users x = uDAO.getActiveUser();
//		Cart c = getCartById(x.getCartId().getCartId());
//		List<Animals> aList = aDAO.getAnimalByCartId(c.getCartId());
//		
//		
//		
//		Animals temp = aList.get(0);
//		Cart aCart = new Cart();
//		
//		Session ses = HibernateUtil.getSession();
//		Transaction tr = ses.beginTransaction();
//		//aCart.setCartId(c.getCartId());
//		//temp.setAnimalId(8);
//		ses.delete(c);
//		//ses.delete(temp);
//		tr.commit();
//		HibernateUtil.closeSession();
		
//		for(Animals a : aList) {
//			System.out.println(a.toString());
//			
//			Session ses = HibernateUtil.getSession();
//			Animals temp = new Animals();
//			temp.setAnimalId(a.getAnimalId());
//			ses.delete(temp);
//			HibernateUtil.closeSession();
//			
//		}

		
//		Session ses = HibernateUtil.getSession();
//		Transaction tr = ses.beginTransaction();
//		
//		Query query = ses.createQuery("");
		
		
		
		
		
//		Transaction tr = ses.beginTransaction();
		
		
		
		
//		tr.commit();
//		HibernateUtil.closeSession();
		System.out.println("Deleted cart and animals");
		
	}

	@Override
	public void removeAnimal() {
		
		System.out.println("in dao ");
		Users x = uDAO.getActiveUser();
		Cart c = getCartById(x.getCartId().getCartId());
		Cart y = getCartById(1);
		List<Animals> aList = aDAO.getAnimalByCartId(c.getCartId());
		Session ses = HibernateUtil.getSession();
		for (Animals a  : aList) {
			System.out.println(a.toString());
			
			Transaction tr = ses.beginTransaction();
			a.setCartId(y);;
			tr.commit();
			
		
		}
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public void clearCart() {
		Users x = uDAO.getActiveUser();
		Cart c = getCartById(x.getCartId().getCartId());
		Session ses = HibernateUtil.getSession();
		Transaction tr = ses.beginTransaction();
		c.setTotal(0);
		
		tr.commit();
		HibernateUtil.closeSession();
		
		
	}

}
