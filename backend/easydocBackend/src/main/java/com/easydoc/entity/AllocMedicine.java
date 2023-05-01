package com.easydoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AllocMedicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer allocMedicineId;
	private Integer patientId;
	private Integer medicineId;
	private Integer consultId;
	
	public Integer getAllocMedicineId() {
		return allocMedicineId;
	}
	public void setAllocMedicineId(Integer allocMedicineId) {
		this.allocMedicineId = allocMedicineId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	public Integer getConsultId() {
		return consultId;
	}
	public void setConsultId(Integer consultId) {
		this.consultId = consultId;
	}
}
