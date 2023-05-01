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

import com.easydoc.dto.AllocMedicineDTO;
import com.easydoc.dto.MedicineDTO;
import com.easydoc.service.AllocMedicineService;
import com.easydoc.service.MedicineService;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class MedicineApi {
	@Autowired
	MedicineService medicineService;
	
	@Autowired
	AllocMedicineService allocMedicineService;
	
	@GetMapping(value = "medicine")
	ResponseEntity<List<MedicineDTO>> getAllDoctors() {
		List<MedicineDTO> medicineList = medicineService.getAllMedicine();
		return new ResponseEntity<>(medicineList, HttpStatus.OK);
	}
	
	@GetMapping("medicine/alloc/{patientId}/{consultId}")
	ResponseEntity<List<MedicineDTO>> getAllAllocMedicineForPatient(
			@PathVariable Integer patientId, @PathVariable Integer consultId
			) {
		List<MedicineDTO> allocMedicineList = allocMedicineService.getMedicineOfConsult(patientId, consultId);
		return new ResponseEntity<List<MedicineDTO>>(allocMedicineList, HttpStatus.OK);
	}
	
	@PostMapping("medicine/alloc") 
	ResponseEntity<Integer> addAllocMedicine(@RequestBody AllocMedicineDTO allocMedicineDTO) {
		Integer allocExcId = allocMedicineService.addMedicineToConsult(allocMedicineDTO);
		return new ResponseEntity<Integer>(allocExcId, HttpStatus.CREATED);
	}
	
	@DeleteMapping("medicine/remove/{patientId}/{consultId}/{medicineId}")
	ResponseEntity<Long> removeAllocExcercise(@PathVariable Integer patientId, @PathVariable Integer consultId, @PathVariable Integer medicineId) {
		Long recDel = allocMedicineService.removeConsultedMedicine(patientId, consultId, medicineId);
		return new ResponseEntity<Long>(recDel, HttpStatus.OK);
	}
}
