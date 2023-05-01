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

import com.easydoc.dto.AllocFoodDTO;
import com.easydoc.dto.FoodDTO;
import com.easydoc.service.AllocFoodService;
import com.easydoc.service.FoodService;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class FoodApi {
	@Autowired
	FoodService foodService;
	
	@Autowired 
	AllocFoodService allocFoodService;
	
	@GetMapping(value = "food")
	ResponseEntity<List<FoodDTO>> getAllDoctors() {
		List<FoodDTO> foodList = foodService.getAllFood();
		return new ResponseEntity<>(foodList, HttpStatus.OK);
	}
	
	@GetMapping("food/alloc/{patientId}/{consultId}")
	ResponseEntity<List<FoodDTO>> getAllAllocFoodForPatient(
			@PathVariable Integer patientId, @PathVariable Integer consultId
			) {
		List<FoodDTO> allocFoodList = allocFoodService.getFoodOfConsult(patientId, consultId);
		return new ResponseEntity<List<FoodDTO>>(allocFoodList, HttpStatus.OK);
	}
	
	@PostMapping("food/alloc") 
	ResponseEntity<Integer> addAllocFood(@RequestBody AllocFoodDTO allocFoodDTO) {
		Integer allocExcId = allocFoodService.addFoodToConsult(allocFoodDTO);
		return new ResponseEntity<Integer>(allocExcId, HttpStatus.CREATED);
	}
	
	@DeleteMapping("food/remove/{patientId}/{consultId}/{foodId}")
	ResponseEntity<Long> removeAllocExcercise(@PathVariable Integer patientId, @PathVariable Integer consultId, @PathVariable Integer foodId) {
		Long recDel = allocFoodService.removeConsultedFood(patientId, consultId, foodId);
		return new ResponseEntity<Long>(recDel, HttpStatus.OK);
	}

}
