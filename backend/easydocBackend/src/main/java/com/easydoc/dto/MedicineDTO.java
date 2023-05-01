package com.easydoc.dto;

import com.easydoc.entity.Medicine;

public class MedicineDTO {
	private Integer medicineId;
	private String medicineName;
	private String medicineImage;
	private String description;
	
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineImage() {
		return medicineImage;
	}
	public void setMedicineImage(String medicineImage) {
		this.medicineImage = medicineImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Medicine toEntity() {
		Medicine medicine = new Medicine();
		medicine.setMedicineId(this.getMedicineId());
		medicine.setMedicineName(this.medicineName);
		medicine.setMedicineImage(this.medicineImage);
		medicine.setDescription(this.getDescription());;
		return medicine;
	}
	
	public void setDTO(Medicine medicine) {
		this.setMedicineId(medicine.getMedicineId());
		this.setMedicineName(medicine.getMedicineName());
		this.setMedicineImage(medicine.getMedicineImage());
		this.setDescription(medicine.getDescription());;
	}
	
}
