package com.excilys.formationSpringBoot.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recipe")
public class Recipe {
	Long id;
	String name;
	String picture;
	String description;
	Set<RecipeIngredient> recipeIngredient;
	Set<String> instructions;
	
	public Recipe(){
		
	}
	
	public Recipe(Builder builder){
		id = builder.id;
		name = builder.name;
		picture = builder.picture;
		description = builder.description;
		recipeIngredient = builder.recipeIngredient;
		instructions = builder.instructions;	
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="picture")
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany
	@ElementCollection
	public Set<RecipeIngredient> getRecipeIngredient() {
		return recipeIngredient;
	}
	public void setRecipeIngredient(Set<RecipeIngredient> recipeIngredient) {
		this.recipeIngredient = recipeIngredient;
	}
	@ElementCollection
	public Set<String> getInstructions() {
		return instructions;
	}
	
	public void setInstructions(Set<String> instructions) {
		this.instructions = instructions;
	}
	public static class Builder {
		Long id = null;
		String name = null;
		String picture = null;
		String description = null;
		Set<RecipeIngredient> recipeIngredient = null;
		Set<String> instructions = null;
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder picture(String picture) {
			this.picture = picture;
			return this;
		}
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		public Builder recipeIngredient(Set<RecipeIngredient> recipeIngredient) {
			this.recipeIngredient = recipeIngredient;
			return this;
		}
		public Builder instructions(Set<String> instructions) {
			this.instructions = instructions;
			return this;
		}
	}
}
