package com.easydoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Excercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer excerciseId;
	private String name;
	private String category;
	private String routine;
	private String description;
	private String image;
		
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
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

}
