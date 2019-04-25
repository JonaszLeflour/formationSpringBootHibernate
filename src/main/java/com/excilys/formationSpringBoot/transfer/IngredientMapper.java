package com.excilys.formationSpringBoot.transfer;

import com.excilys.formationSpringBoot.model.Ingredient;

public class IngredientMapper {
public static Ingredient toModel(IngredientDTO dto) {
		return new Ingredient(Ingredient.getBuilder()
				.id(Long.getLong(dto.id))
				.name(dto.name));
	}
	
	public static IngredientDTO toDTO(Ingredient model) {
		IngredientDTO dto = new IngredientDTO();
		dto.id = model.getId().toString();
		dto.name = model.getName();
		return dto;
	}
}
