package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.AllocExcerciseDTO;
import com.easydoc.dto.ExcerciseDTO;
import com.easydoc.entity.AllocExcercise;
import com.easydoc.entity.Excercise;
import com.easydoc.repository.AllocExcerciseRepository;
import com.easydoc.repository.ExcerciseRepository;

import jakarta.transaction.Transactional;

@Service(value = "allocExcercise")
@Transactional
public class AllocExcerciseService {
	@Autowired
	AllocExcerciseRepository allocExcerciseRepository;
	@Autowired
	ExcerciseRepository excerciseRepository;
	
	public List<ExcerciseDTO> getExcerciseOfConsult(Integer patientId, Integer consultId) {
		List<ExcerciseDTO> excerciseList = new ArrayList<ExcerciseDTO>();
		List<AllocExcercise> allocExcerciseList = allocExcerciseRepository.findByPatientIdAndConsultId(patientId, consultId); 
		allocExcerciseList.forEach(allocExc -> {
			Optional<Excercise> optional = excerciseRepository.findById(allocExc.getExcerciseId());
			if(optional.isPresent()) {
				ExcerciseDTO excerciseDTO = new ExcerciseDTO();
				excerciseDTO.getDTO(optional.get());
				excerciseList.add(excerciseDTO);
			}
		});
		return excerciseList;
	}
	
	public Integer addExcerciseToConsult(AllocExcerciseDTO allocExcerciseDTO) {
		Optional<AllocExcercise> optional = Optional.ofNullable(allocExcerciseRepository.findByPatientIdAndExcerciseIdAndConsultId(allocExcerciseDTO.getPatientId(), allocExcerciseDTO.getExcerciseId(), allocExcerciseDTO.getConsultId()));
		if(optional.isEmpty()) {
		    return allocExcerciseRepository.save(allocExcerciseDTO.toEntity()).getAllocExcerciseId();
		}
		return -1;
	}
	
	public Long removeConsultedExcercise( Integer patientId, Integer consultId, Integer exerciseId) {
		return allocExcerciseRepository.deleteByPatientIdAndExcerciseIdAndConsultId(patientId, exerciseId, consultId);
	}
}
