package com.easydoc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easydoc.dto.AllocExcerciseDTO;
import com.easydoc.dto.ExcerciseDTO;
import com.easydoc.service.AllocExcerciseService;
import com.easydoc.service.ExcerciseService;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class ExcerciseApi {
	@Autowired
	ExcerciseService excerciseService;
	
	@Autowired 
	AllocExcerciseService allocExcerciseService;
	
	@GetMapping("excercise")
	ResponseEntity<List<ExcerciseDTO>> getAllDoctors() {
		List<ExcerciseDTO> excerciseList = excerciseService.getAllExcercises();
		return new ResponseEntity<>(excerciseList, HttpStatus.OK);
	}
	
	@GetMapping("excercise/alloc/{patientId}/{consultId}")
	ResponseEntity<List<ExcerciseDTO>> getAllAllocExcerciseForPatient(
			@PathVariable Integer patientId, @PathVariable Integer consultId
			) {
		List<ExcerciseDTO> allocExcerciseList = allocExcerciseService.getExcerciseOfConsult(patientId, consultId);
		return new ResponseEntity<List<ExcerciseDTO>>(allocExcerciseList, HttpStatus.OK);
	}
	
	@PostMapping("excercise/alloc") 
	ResponseEntity<Integer> addAllocExcercise(@RequestBody AllocExcerciseDTO allocExcerciseDTO) {
		Integer allocExcId = allocExcerciseService.addExcerciseToConsult(allocExcerciseDTO);
		return new ResponseEntity<Integer>(allocExcId, HttpStatus.CREATED);
	}
	
	@DeleteMapping("excercise/remove/{patientId}/{consultId}/{excerciseId}")
	ResponseEntity<Long> removeAllocExcercise(@PathVariable Integer patientId, @PathVariable Integer consultId, @PathVariable Integer excerciseId) {
		Long recDel = allocExcerciseService.removeConsultedExcercise(patientId, consultId, excerciseId);
		return new ResponseEntity<Long>(recDel, HttpStatus.OK);
	}
}
