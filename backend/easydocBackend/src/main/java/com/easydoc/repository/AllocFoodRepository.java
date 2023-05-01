package com.easydoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.AllocFood;

public interface AllocFoodRepository extends CrudRepository<AllocFood, Integer> {
    public List<AllocFood> findByPatientIdAndConsultId(Integer patientId, Integer consultId);
	
	public AllocFood findByPatientIdAndFoodIdAndConsultId(
			Integer patientId, Integer foodId, Integer consultId);
	
	public Long deleteByPatientIdAndFoodIdAndConsultId(
			Integer patientId, Integer foodId, Integer consultId);
}
