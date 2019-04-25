package com.excilys.formationSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recipe_ingredient")
public class RecipeIngredient {
	Long id;
	Ingredient ingredient;
	Long quantity;
	String unit;
	
	public RecipeIngredient () {};
	public RecipeIngredient (Builder builder) {
		id = builder.id;
		ingredient = builder.ingredient;
		quantity = builder.quantity;
		unit = builder.unit;
	}
	
	public static class Builder {
		Long id;
		Ingredient ingredient;
		Long quantity;
		String unit;
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder ingredient(Ingredient ingredient) {
			this.ingredient = ingredient;
			return this;
		}
		
		public Builder quantity(Long quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public Builder unit(String unit) {
			this.unit = unit;
			return this;
		}
		
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
	
	@ManyToOne
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	@Column(name="quantity")
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="unity")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
