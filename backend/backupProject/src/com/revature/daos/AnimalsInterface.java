package com.revature.daos;

import java.util.List;

import com.revature.models.Animals;

public interface AnimalsInterface {

	public void newAnimal(Animals newAnimal);
	
	public List<Animals> getAllAnimals();
	
	public Animals getAnimalById(int animal_id);
	
	public List<Animals> getAnimalsBySpecies(String species);
	
	public void removeAnimal(Animals animal);
	
}
