package com.excilys.formationSpringBoot.transfer;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.excilys.formationSpringBoot.model.Recipe;
import com.excilys.formationSpringBoot.model.RecipeIngredient;

public class RecipeMapper implements Mapper<Recipe, RecipeDTO>{
	@Override
	public RecipeDTO toDTO(Recipe recipe) {
		RecipeDTO recipeDTO = new RecipeDTO();
		recipeDTO.id = recipe.getId().toString();
		recipeDTO.description = recipe.getDescription();
		recipeDTO.instructions = recipe.getInstructions().stream().collect(Collectors.toList());
		recipeDTO.name = recipe.getName();
		recipeDTO.picture = recipe.getPicture();
		return recipeDTO;
	}
	@Override
	public Recipe toModel(RecipeDTO recipeDTO) {
		RecipeIngredientMapper riMapper = new RecipeIngredientMapper();
		Set<RecipeIngredient> set = new HashSet<>();
		for(RecipeIngredientDTO recipeIngredient : recipeDTO.recipeIngredient) {
			set.add(riMapper.toModel(recipeIngredient));
		}
		
		return new Recipe(Recipe.getBuilder()
					.description(recipeDTO.description)
					.id(Long.getLong(recipeDTO.id))
					.name(recipeDTO.name)
					.instructions(recipeDTO.instructions.stream().collect(Collectors.toSet()))
					.picture(recipeDTO.picture)
					.recipeIngredient(set)
					/*.recipeIngredient(recipeDTO.recipeIngredient.stream()
							.flatMap(RecipeIngredientMapper.toModel).collect(Collectors.toSet()))*/
				);
	}
}
