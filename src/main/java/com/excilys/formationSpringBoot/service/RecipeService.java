package com.excilys.formationSpringBoot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excilys.formationSpringBoot.persistence.RecipeDAO;
import com.excilys.formationSpringBoot.transfer.RecipeDTO;
import com.excilys.formationSpringBoot.transfer.RecipeMapper;

@Service
public class RecipeService 	{
	
	RecipeDAO dao;
	
	@Autowired
	public RecipeService(RecipeDAO dao){
		this.dao = dao;
	}
	
	List<RecipeDTO> getAllRecipies() {
		return dao.getAllRecipies()
				.stream()
				.map(model -> RecipeMapper.toDTO(model))
				.collect(Collectors.toList());
	}
	
	RecipeDTO getRecipieById(Long id) {
		return RecipeMapper.toDTO(dao.getRecipyByid(id));
	}

}
