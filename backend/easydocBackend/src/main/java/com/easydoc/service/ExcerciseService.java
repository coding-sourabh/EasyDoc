package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.ExcerciseDTO;
import com.easydoc.entity.Excercise;
import com.easydoc.repository.ExcerciseRepository;

import jakarta.transaction.Transactional;

@Service(value="excerciseService")
@Transactional
public class ExcerciseService {
	@Autowired
	ExcerciseRepository excerciseRepository;
	
	public List<ExcerciseDTO> getAllExcercises() { 
		List<ExcerciseDTO> list = new ArrayList<>();
		Iterable<Excercise> itr = excerciseRepository.findAll();
		itr.forEach((excercise) -> {
			ExcerciseDTO excerciseDTO = new ExcerciseDTO();
			excerciseDTO.getDTO(excercise);
			list.add(excerciseDTO);
		});
		
		return list;
	}
}
