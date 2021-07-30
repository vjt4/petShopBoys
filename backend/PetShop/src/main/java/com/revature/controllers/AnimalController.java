package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Animals;
import com.revature.services.AnimalService;

public class AnimalController {
	
	private AnimalService as = new AnimalService();
	private ObjectMapper om = new ObjectMapper();

	public void getAllAnimals(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		List<Animals> animalList = as.getAllAnimals();
		
		String json = om.writeValueAsString(animalList);
		
		res.getWriter().print(json);
		
		res.setStatus(200);
		
	}
	
	public void getAnimalsBySpecies(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		Animals aDTO = om.readValue(body, Animals.class);
		//{"species":" ? "}
		System.out.println(aDTO.getSpecies());
		System.out.println("=============================");
		
		List<Animals> animalList = as.getAnimalsBySpecies(aDTO.getSpecies());
		
		String json = om.writeValueAsString(animalList);
		
		res.setContentType("application/json");
		res.getWriter().print(json);
		
		res.setStatus(200);
		
	}
	
}