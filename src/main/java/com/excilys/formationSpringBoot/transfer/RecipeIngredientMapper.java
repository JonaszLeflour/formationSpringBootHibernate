package com.excilys.formationSpringBoot.transfer;

import com.excilys.formationSpringBoot.model.RecipeIngredient;

public class RecipeIngredientMapper {
	
	public static RecipeIngredient toModel(RecipeIngredientDTO dto) {
		
		return new RecipeIngredient(RecipeIngredient.getBuilder()
				.id(Long.getLong(dto.id))
				.ingredient(IngredientMapper.toModel(dto.ingredient))
				.quantity(Long.getLong(dto.quantity))
				.unit(dto.unit)
			);
	}
	
	public static RecipeIngredientDTO toDTO(RecipeIngredient model) {
		RecipeIngredientDTO dto = new RecipeIngredientDTO();
		dto.id = model.getId().toString();
		dto.ingredient = IngredientMapper.toDTO(model.getIngredient());
		dto.quantity = model.getQuantity().toString();
		dto.unit = model.getUnit();
		return dto;
	}
}
