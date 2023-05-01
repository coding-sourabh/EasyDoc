package com.easydoc.dto;

import com.easydoc.entity.Excercise;

public class ExcerciseDTO {
	private Integer excerciseId;
	private String name;
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	private String category;
	private String routine;
	private String description;
	
	public Integer getExcerciseId() {
		return excerciseId;
	}
	public void setExcerciseId(Integer excerciseId) {
		this.excerciseId = excerciseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRoutine() {
		return routine;
	}
	public void setRoutine(String routine) {
		this.routine = routine;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Excercise getEntity() {
		Excercise Excercise = new Excercise();
		Excercise.setExcerciseId(this.getExcerciseId());
		Excercise.setName(this.getName());
		Excercise.setRoutine(this.getRoutine());
		Excercise.setCategory(this.getCategory());
		Excercise.setDescription(this.getDescription());
		Excercise.setImage(this.image);
		return Excercise;
	}
	
	public void getDTO(Excercise excercise) {
		this.setExcerciseId(excercise.getExcerciseId());
		this.setName(excercise.getName());
		this.setRoutine(excercise.getRoutine());
		this.setCategory(excercise.getCategory());
		this.setDescription(excercise.getDescription());
		this.setImage(excercise.getImage());
	}
}
