package com.revature.services;

import java.util.List;

import com.revature.daos.AnimalsDAO;
import com.revature.daos.AnimalsInterface;
import com.revature.models.Animals;

public class AnimalService {
	
	private AnimalsInterface aDAO = new AnimalsDAO();
	
	public void newAnimal(Animals newAnimal) {
		aDAO.newAnimal(newAnimal);
	}
	
	public List<Animals> getAllAnimals(){
		return aDAO.getAllAnimals();
	}
	
	public Animals getAnimalById(int animal_id) {
		return aDAO.getAnimalById(animal_id);
	}
	
	public List<Animals> getAnimalsBySpecies(String species){
		return aDAO.getAnimalsBySpecies(species);
	}
	
	public void removeAnimal(Animals animal) {
		aDAO.removeAnimal(animal);
	}

}
