package com.easydoc.repository;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.Food;

public interface FoodRepository extends CrudRepository<Food, Integer> {

}
