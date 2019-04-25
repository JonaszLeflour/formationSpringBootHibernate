package com.excilys.formationSpringBoot.transfer;

import java.util.List;

public class RecipeDTO {
	public String id;
	public String name;
	public String picture;
	public String description;
	public List<RecipeIngredientDTO> recipeIngredient;
	public List<String> instructions;
}
