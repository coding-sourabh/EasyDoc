package com.easydoc.repository;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{
	public Doctor findByEmail(String email);
}
