package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Animals;
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
		
		HibernateUtil.closeSession();
		
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

}