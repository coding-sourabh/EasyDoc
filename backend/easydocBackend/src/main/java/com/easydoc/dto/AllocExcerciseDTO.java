package com.easydoc.dto;

import com.easydoc.entity.AllocExcercise;

public class AllocExcerciseDTO {
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
	
	public AllocExcercise toEntity() {
		AllocExcercise allocExcercise = new AllocExcercise();
		allocExcercise.setAllocExcerciseId(this.allocExcerciseId);
		allocExcercise.setExcerciseId(this.excerciseId);
		allocExcercise.setPatientId(this.patientId);
		allocExcercise.setConsultId(this.consultId);
		return allocExcercise;
	}
	
	public void setDTO(AllocExcercise allocExcercise) {
		this.setAllocExcerciseId(allocExcercise.getAllocExcerciseId());
		this.setExcerciseId(allocExcercise.getAllocExcerciseId());
		this.setPatientId(allocExcercise.getPatientId());
		this.setConsultId(allocExcercise.getConsultId());
	}
}
