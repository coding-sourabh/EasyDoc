package com.easydoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.AllocExcercise;

public interface AllocExcerciseRepository extends CrudRepository<AllocExcercise, Integer> {
	public List<AllocExcercise> findByPatientIdAndConsultId(Integer patientId, Integer consultId);
	
	public AllocExcercise findByPatientIdAndExcerciseIdAndConsultId(
			Integer patientId, Integer excerciseId, Integer consultId);
	
	public Long deleteByPatientIdAndExcerciseIdAndConsultId(
			Integer patientId, Integer excerciseId, Integer consultId);
	
}
