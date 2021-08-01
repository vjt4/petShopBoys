package com.revature.models;

import java.util.Objects;

public class AnimalsDTO {
	
	private int animalId;
	private String name;
	private String species;
	private String breed;
	private String age;
	private String gender;
	private String size;
	private String price;
	private String picture;
	
	public AnimalsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnimalsDTO(int animalId, String name, String species, String breed, String age, String gender, String size,
			String price, String picture) {
		super();
		this.animalId = animalId;
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.age = age;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.picture = picture;
	}

	public AnimalsDTO(String name, String species, String breed, String age, String gender, String size, String price,
			String picture) {
		super();
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.age = age;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "AnimalsDTO [animalId=" + animalId + ", name=" + name + ", species=" + species + ", breed=" + breed
				+ ", age=" + age + ", gender=" + gender + ", size=" + size + ", price=" + price + ", picture=" + picture
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, animalId, breed, gender, name, picture, price, size, species);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimalsDTO other = (AnimalsDTO) obj;
		return Objects.equals(age, other.age) && animalId == other.animalId && Objects.equals(breed, other.breed)
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name)
				&& Objects.equals(picture, other.picture) && Objects.equals(price, other.price)
				&& Objects.equals(size, other.size) && Objects.equals(species, other.species);
	}

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	

}
