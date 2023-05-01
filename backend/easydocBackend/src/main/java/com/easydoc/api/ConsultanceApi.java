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

import com.easydoc.dto.ConsultanceDTO;
import com.easydoc.service.ConsultanceService;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class ConsultanceApi {
	@Autowired
	ConsultanceService consultanceService;
	
	@GetMapping(value = "consultance/patient/{patientId}")
	ResponseEntity<List<ConsultanceDTO>> getAllConsulatanceByPatient(@PathVariable Integer patientId) {
		List<ConsultanceDTO> consultanceList = consultanceService.getAllConsultanceOfPatient(patientId);
		return new ResponseEntity<>(consultanceList, HttpStatus.OK);
	}
	
	@GetMapping(value = "consultance/doctor/{doctorId}")
	ResponseEntity<List<ConsultanceDTO>> getAllConsulatanceByDoctor(@PathVariable Integer doctorId) {
		List<ConsultanceDTO> consultanceList = consultanceService.getAllConsultanceOfDoctor(doctorId);
		return new ResponseEntity<>(consultanceList, HttpStatus.OK);
	}
	
	@PostMapping(value = "consultance")
	ResponseEntity<Integer> addConsultance(@RequestBody ConsultanceDTO consultanceDTO) {
		Integer addConsultanceId = consultanceService.addConsultance(consultanceDTO);
		return new ResponseEntity<Integer>(addConsultanceId, HttpStatus.CREATED);
	}
}
