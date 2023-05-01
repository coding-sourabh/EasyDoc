package com.easydoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.AllocMedicine;

public interface AllocMedicineRepository extends CrudRepository<AllocMedicine, Integer> {
public List<AllocMedicine> findByPatientIdAndConsultId(Integer patientId, Integer consultId);
	
	public AllocMedicine findByPatientIdAndMedicineIdAndConsultId(
			Integer patientId, Integer medicineId, Integer consultId);
	
	public Long deleteByPatientIdAndMedicineIdAndConsultId(
			Integer patientId, Integer medicineId, Integer consultId);
}
