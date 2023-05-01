package com.easydoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AllocExcercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer allocExcerciseId;
	private Integer patientId;
	private Integer excerciseId;
	private Integer consultId;
	
	public Integer getAllocExcerciseId() {
		return allocExcerciseId;
	}
	public void setAllocExcerciseId(Integer allocExcerciseId) {
		this.allocExcerciseId = allocExcerciseId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getExcerciseId() {
		return excerciseId;
	}
	public void setExcerciseId(Integer excerciseId) {
		this.excerciseId = excerciseId;
	}
	public Integer getConsultId() {
		return consultId;
	}
	public void setConsultId(Integer consultId) {
		this.consultId = consultId;
	}
}
