package com.easydoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.Consultance;
import com.easydoc.entity.Doctor;

public interface ConsultanceRepository extends CrudRepository<Consultance, Integer>  {
	public List<Consultance> findByPatientId(Integer patientId);
	public Consultance findByPatientIdAndDoctor(Integer patientId, Doctor doctor);
}
