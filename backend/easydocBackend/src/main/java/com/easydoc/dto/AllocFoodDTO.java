package com.easydoc.dto;

import com.easydoc.entity.AllocFood;

public class AllocFoodDTO {
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
	
	public AllocFood toEntity() {
		AllocFood allocFood = new AllocFood();
		allocFood.setAllocFoodId(this.allocFoodId);
		allocFood.setFoodId(this.foodId);
		allocFood.setPatientId(this.patientId);
		allocFood.setConsultId(this.consultId);
		return allocFood;
	}
	
	public void setDTO(AllocFood allocFood) {
		this.setAllocFoodId(allocFood.getAllocFoodId());
		this.setFoodId(allocFood.getAllocFoodId());
		this.setPatientId(allocFood.getPatientId());
		this.setConsultId(allocFood.getConsultId());
	}
}
