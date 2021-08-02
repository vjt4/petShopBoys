package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Animals;
import com.revature.models.Cart;
import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class AnimalsDAO implements AnimalsInterface {
	
	

	@Override
	public void newAnimal(Animals newAnimal) {

		Session ses = HibernateUtil.getSession();
		
		ses.save(newAnimal);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public List<Animals> getAllAnimals() {

		Session ses = HibernateUtil.getSession();
		
		List<Animals> animalList = ses.createQuery("from Animals").list();
		
		//HibernateUtil.closeSession();
		
		return animalList;
		
	}

	@Override
	public Animals getAnimalById(int animal_id) {
		
		Session ses = HibernateUtil.getSession();
		
		Animals animal = ses.get(Animals.class, animal_id);
		
		HibernateUtil.closeSession();
		
		return animal;
		
	}

	@Override
	public List<Animals> getAnimalsBySpecies(String species) {

		Session ses = HibernateUtil.getSession();
		
		List<Animals> animalList = ses.createQuery("FROM Animals A where A.species =:species")
				.setParameter("species",species)
				.list();
		
		HibernateUtil.closeSession();
		
		return animalList;
		
	}

	@Override
	public void removeAnimal(Animals animal) {

		Session ses = HibernateUtil.getSession();
		
		ses.delete(animal);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public void updateAnimalIntoCart(int animalId) {
		CartDAO cDAO = new CartDAO();
		UsersDAO uDAO = new UsersDAO();
		
		//Getting cart by getting the active user
		Users x = uDAO.getActiveUser();
		Cart c = cDAO.getCartById(x.getCartId().getCartId());
		Animals a = getAnimalById(animalId);
		
		Session ses = HibernateUtil.getSession();
		Transaction tr = ses.beginTransaction();
		a.setCartId(c);
		tr.commit();
		HibernateUtil.closeSession();
		System.out.println("Updated animals cart key-=-=-=-=-=-=-=-");
		
		
	}

	@Override
	public List<Animals> getAnimalByCartId(int cartId) {
		List<Animals> aList = getAllAnimals();
		List<Animals> temp = new ArrayList<Animals>();
		for(Animals a : aList) {
			
			if(a.getCartId() != null) {
				if(a.getCartId().getCartId() == cartId) {
					temp.add(a);
				}
				
			}
		}
		
		return temp;
	}

}