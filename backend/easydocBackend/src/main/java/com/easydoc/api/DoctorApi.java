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

import com.easydoc.dto.DoctorDTO;
import com.easydoc.exception.EasydocException;
import com.easydoc.service.DoctorService;

@RestController
@RequestMapping(value = "api")
@CrossOrigin
public class DoctorApi {
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("doctor")
	ResponseEntity<List<DoctorDTO>> getAllDoctors() {
		List<DoctorDTO> doctorList = doctorService.getDoctors();
		return new ResponseEntity<>(doctorList, HttpStatus.OK);
	}
	
	@GetMapping("doctor/{doctorId}")
	ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Integer doctorId) {
		DoctorDTO doctorDTO = doctorService.getDoctorsById(doctorId);
		return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
	}
	
	@PostMapping("doctor")
	ResponseEntity<Integer> addDoctor(@RequestBody DoctorDTO doctorDTO) throws EasydocException{
		Integer doctorAddedId = doctorService.addDoctor(doctorDTO);
		return new ResponseEntity<>(doctorAddedId, HttpStatus.CREATED);
	}
	
	@GetMapping("doctor/{email}/{password}")
	ResponseEntity<DoctorDTO> login(@PathVariable String email, @PathVariable String password) throws EasydocException {
		DoctorDTO dDTO = doctorService.login(email, password);
		return new ResponseEntity<>(dDTO, HttpStatus.OK);
	}
}
