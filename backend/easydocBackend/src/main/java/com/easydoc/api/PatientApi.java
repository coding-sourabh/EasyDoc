package com.easydoc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easydoc.dto.PatientDTO;
import com.easydoc.exception.EasydocException;
import com.easydoc.service.PatientService;

	@RestController
	@RequestMapping(value = "api")
	@CrossOrigin
	public class PatientApi {
		@Autowired
		PatientService patientService;
		
		@GetMapping("patient")
		ResponseEntity<List<PatientDTO>> getAllPatients() {
			List<PatientDTO> patientList = patientService.getPatients();
			return new ResponseEntity<>(patientList, HttpStatus.OK);
		}
		
		@GetMapping("patient/{patientId}")
		ResponseEntity<PatientDTO> getPatientById(@PathVariable Integer patientId) {
			PatientDTO patientDTO = patientService.getPatientById(patientId);
			return new ResponseEntity<>(patientDTO, HttpStatus.OK);
		}
		
		@GetMapping("patient/{email}/{password}")
		ResponseEntity<PatientDTO> login(@PathVariable String email, @PathVariable String password) throws EasydocException {
		    PatientDTO pDTO = patientService.login(email, password);
			return new ResponseEntity<>(pDTO, HttpStatus.OK);
		}
		
		@PostMapping("patient")
		ResponseEntity<Integer> addPatient(@RequestBody PatientDTO patientDTO) throws EasydocException {
			Integer patientAddedId = patientService.addPatient(patientDTO);
			return new ResponseEntity<>(patientAddedId, HttpStatus.CREATED);
		}
}