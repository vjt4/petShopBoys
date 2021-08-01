package com.revature.daos;

import java.util.List;

import com.revature.models.Animals;
import com.revature.models.Cart;

public interface AnimalsInterface {

	public void newAnimal(Animals newAnimal);
	
	public List<Animals> getAllAnimals();
	
	public Animals getAnimalById(int animal_id);
	
	public List<Animals> getAnimalsBySpecies(String species);
	
	public void removeAnimal(Animals animal);

	public void updateAnimalIntoCart(int animalId);
	
	public List<Animals> getAnimalByCartId(int cartId);
	
}
