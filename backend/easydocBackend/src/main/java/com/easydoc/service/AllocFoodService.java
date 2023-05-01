package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.AllocFoodDTO;
import com.easydoc.dto.FoodDTO;
import com.easydoc.entity.AllocFood;
import com.easydoc.entity.Food;
import com.easydoc.repository.AllocFoodRepository;
import com.easydoc.repository.FoodRepository;

import jakarta.transaction.Transactional;

@Service(value = "allocFood")
@Transactional
public class AllocFoodService {
	@Autowired
	AllocFoodRepository allocFoodRepository;
	@Autowired
	FoodRepository foodRepository;
	
	public List<FoodDTO> getFoodOfConsult(Integer patientId, Integer consultId) {
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		List<AllocFood> allocFoodList = allocFoodRepository.findByPatientIdAndConsultId(patientId, consultId); 
		allocFoodList.forEach(allocExc -> {
			Optional<Food> optional = foodRepository.findById(allocExc.getFoodId());
			if(optional.isPresent()) {
				FoodDTO foodDTO = new FoodDTO();
				foodDTO.getDTO(optional.get());
				foodList.add(foodDTO);
			}
		});
		return foodList;
	}
	
	public Integer addFoodToConsult(AllocFoodDTO allocFoodDTO) {
		Optional<AllocFood> optional = Optional.ofNullable(allocFoodRepository.findByPatientIdAndFoodIdAndConsultId(allocFoodDTO.getPatientId(), allocFoodDTO.getFoodId(), allocFoodDTO.getConsultId()));
		if(optional.isEmpty()) {
		    return allocFoodRepository.save(allocFoodDTO.toEntity()).getAllocFoodId();
		}
		return -1;
	}
	
	public Long removeConsultedFood( Integer patientId, Integer consultId, Integer foodId) {
		return allocFoodRepository.deleteByPatientIdAndFoodIdAndConsultId(patientId, foodId, consultId);
	}
}
