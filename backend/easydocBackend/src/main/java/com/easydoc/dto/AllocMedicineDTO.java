package com.easydoc.dto;

import com.easydoc.entity.AllocMedicine;

public class AllocMedicineDTO {
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
	
	public AllocMedicine toEntity() {
		AllocMedicine allocMedicine = new AllocMedicine();
		allocMedicine.setAllocMedicineId(this.allocMedicineId);
		allocMedicine.setMedicineId(this.medicineId);
		allocMedicine.setPatientId(this.patientId);
		allocMedicine.setConsultId(this.consultId);
		return allocMedicine;
	}
	
	public void setDTO(AllocMedicine allocMedicine) {
		this.setAllocMedicineId(allocMedicine.getAllocMedicineId());
		this.setMedicineId(allocMedicine.getAllocMedicineId());
		this.setPatientId(allocMedicine.getPatientId());
		this.setConsultId(allocMedicine.getConsultId());
	}
}
