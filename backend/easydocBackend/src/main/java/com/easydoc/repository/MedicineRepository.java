package com.easydoc.repository;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.Medicine;

public interface MedicineRepository extends CrudRepository<Medicine, Integer> {

}
