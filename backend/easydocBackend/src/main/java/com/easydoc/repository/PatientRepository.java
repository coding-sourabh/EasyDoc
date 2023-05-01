package com.easydoc.repository;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
	public Patient findByEmail(String email);
}
