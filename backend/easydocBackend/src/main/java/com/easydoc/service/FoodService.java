package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.FoodDTO;
import com.easydoc.entity.Food;
import com.easydoc.repository.FoodRepository;

@Service(value = "foodService")
public class FoodService {
	@Autowired
	FoodRepository foodRepository;
	
	public List<FoodDTO> getAllFood() {
		List<FoodDTO> list = new ArrayList<FoodDTO>();
		Iterable<Food> itr = foodRepository.findAll();
		itr.forEach(f -> {
			FoodDTO foodDTO = new FoodDTO();
			foodDTO.getDTO(f);
			list.add(foodDTO);
		});
		return list;
	}
}
