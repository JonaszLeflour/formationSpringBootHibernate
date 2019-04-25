package com.excilys.formationSpringBoot.transfer;
import java.util.stream.Collectors;

import com.excilys.formationSpringBoot.model.Recipe;

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
		Recipe recipe = new Recipe(Recipe.getBuilder()
					.description(recipeDTO.description)
					.id(Long.getLong(recipeDTO.id))
					.name(recipeDTO.name)
					.instructions(recipeDTO.instructions.stream().collect(Collectors.toSet()))
					.picture(recipeDTO.picture)
					/*.recipeIngredient(recipeDTO.recipeIngredient.stream()
							.flatMap(RecipeIngredientMapper.toModel).collect(Collectors.toSet()))*/
				);
		return recipe;
	}
}
