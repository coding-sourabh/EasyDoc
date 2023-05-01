package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.PatientDTO;
import com.easydoc.entity.Patient;
import com.easydoc.exception.EasydocException;
import com.easydoc.repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service(value = "patientService")
@Transactional
public class PatientService {
	@Autowired
	PatientRepository patientRepository;
	
	public List<PatientDTO> getPatients() {
		List<PatientDTO> patientList = new ArrayList<>();
		Iterable<Patient> itr = patientRepository.findAll();
		itr.forEach((Patient patient) -> {
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setDTO(patient);
			patientList.add(patientDTO);
		});
		return patientList;
	}
	
	public PatientDTO getPatientById(Integer patientId) {
		Optional<Patient> optional = patientRepository.findById(patientId);
		PatientDTO patientDTO = new PatientDTO();
		if(optional.isPresent()) {
			Patient patient = optional.get();
			patientDTO.setDTO(patient);
		}
		return patientDTO;
	}
	
	public Integer addPatient(PatientDTO patientDTO) throws EasydocException {
		Optional<Patient> patOptional = Optional.ofNullable(patientRepository.findByEmail(patientDTO.getEmail()));
		if(patOptional.isPresent()) {
			throw new EasydocException("This user already exists.");
		}
		Patient patient = patientDTO.toEntity();
		Integer savedPatientId = patientRepository.save(patient).getPatientId();
		return savedPatientId;
	}
	
	public PatientDTO login(String email, String password) throws EasydocException {
		PatientDTO patientDTO = new PatientDTO();
		 Optional<Patient> optionalPatient = Optional.ofNullable(patientRepository.findByEmail(email));
		 if(optionalPatient.isEmpty() || !optionalPatient.get().getPassword().equals(password))
			 throw new EasydocException("Wrong Credentials");
		 patientDTO.setDTO(optionalPatient.get());
		 return patientDTO;
	}
}
