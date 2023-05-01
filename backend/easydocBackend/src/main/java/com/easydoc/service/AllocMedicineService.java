package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.AllocMedicineDTO;
import com.easydoc.dto.MedicineDTO;
import com.easydoc.entity.AllocMedicine;
import com.easydoc.entity.Medicine;
import com.easydoc.repository.AllocMedicineRepository;
import com.easydoc.repository.MedicineRepository;

import jakarta.transaction.Transactional;

@Service(value = "allocMedicineService")
@Transactional
public class AllocMedicineService {
	@Autowired
	AllocMedicineRepository allocMedicineRepository;
	@Autowired
	MedicineRepository medicineRepository;
	
	public List<MedicineDTO> getMedicineOfConsult(Integer patientId, Integer consultId) {
		List<MedicineDTO> medicineList = new ArrayList<MedicineDTO>();
		List<AllocMedicine> allocMedicineList = allocMedicineRepository.findByPatientIdAndConsultId(patientId, consultId); 
		allocMedicineList.forEach(allocExc -> {
			Optional<Medicine> optional = medicineRepository.findById(allocExc.getMedicineId());
			if(optional.isPresent()) {
				MedicineDTO medicineDTO = new MedicineDTO();
				medicineDTO.setDTO(optional.get());
				medicineList.add(medicineDTO);
			}
		});
		return medicineList;
	}
	
	public Integer addMedicineToConsult(AllocMedicineDTO allocMedicineDTO) {
		Optional<AllocMedicine> optional = Optional.ofNullable(allocMedicineRepository.findByPatientIdAndMedicineIdAndConsultId(allocMedicineDTO.getPatientId(), allocMedicineDTO.getMedicineId(), allocMedicineDTO.getConsultId()));
		if(optional.isEmpty()) {
		    return allocMedicineRepository.save(allocMedicineDTO.toEntity()).getAllocMedicineId();
		}
		return -1;
	}
	
	public Long removeConsultedMedicine( Integer patientId, Integer consultId, Integer medicineId) {
		return allocMedicineRepository.deleteByPatientIdAndMedicineIdAndConsultId(patientId, medicineId, consultId);
	}
}
