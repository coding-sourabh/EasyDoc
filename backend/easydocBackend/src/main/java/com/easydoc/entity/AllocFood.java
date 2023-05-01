package com.easydoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AllocFood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer allocFoodId;
	private Integer patientId;
	private Integer foodId;
	private Integer consultId;
	
	public Integer getAllocFoodId() {
		return allocFoodId;
	}
	public void setAllocFoodId(Integer allocFoodId) {
		this.allocFoodId = allocFoodId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public Integer getConsultId() {
		return consultId;
	}
	public void setConsultId(Integer consultId) {
		this.consultId = consultId;
	}
}
