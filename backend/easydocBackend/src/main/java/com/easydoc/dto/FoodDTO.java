package com.easydoc.dto;

import com.easydoc.entity.Food;

public class FoodDTO {
	private Integer foodId;
	private String foodName;
	private String foodImage;
	private String category;
	private Float calories;
	private Float amount;
	private String description;
	
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Float getCalories() {
		return calories;
	}
	public void setCalories(Float calories) {
		this.calories = calories;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Food getEntity() {
		Food food = new Food();
		food.setFoodId(this.getFoodId());
		food.setFoodName(this.getFoodName());
		food.setFoodImage(this.getFoodImage());
		food.setCategory(this.getCategory());
		food.setDescription(this.getDescription());
		food.setCalories(this.getCalories());
		food.setAmount(this.getAmount());
		return food;
	}
	
	public void getDTO(Food food) {
		this.setFoodId(food.getFoodId());
		this.setFoodName(food.getFoodName());
		this.setFoodImage(food.getFoodImage());
		this.setCategory(food.getCategory());
		this.setDescription(food.getDescription());
		this.setCalories(food.getCalories());
		this.setAmount(food.getAmount());
	}
}
