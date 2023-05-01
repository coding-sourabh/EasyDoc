package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.MedicineDTO;
import com.easydoc.entity.Medicine;
import com.easydoc.repository.MedicineRepository;

import jakarta.transaction.Transactional;

@Service(value = "medicineService")
@Transactional
public class MedicineService {
	@Autowired
	MedicineRepository medicineRepository;
	
	public List<MedicineDTO> getAllMedicine() {
		List<MedicineDTO> list = new ArrayList<>();
		Iterable<Medicine> itr = medicineRepository.findAll();
		itr.forEach(m -> {
			MedicineDTO medicineDTO = new MedicineDTO();
			medicineDTO.setDTO(m);
			list.add(medicineDTO);
		});
		return list;
	}
}
