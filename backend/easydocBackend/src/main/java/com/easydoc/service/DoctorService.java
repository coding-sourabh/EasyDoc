package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.DoctorDTO;
import com.easydoc.entity.Doctor;
import com.easydoc.exception.EasydocException;
import com.easydoc.repository.DoctorRepository;

@Service(value = "doctorService")
public class DoctorService {
	@Autowired
	DoctorRepository doctorRepository;
	
	public List<DoctorDTO> getDoctors() {
		List<DoctorDTO> doctorList = new ArrayList<>();
		Iterable<Doctor> itr = doctorRepository.findAll();
		itr.forEach((Doctor doctor) -> {
			DoctorDTO doctorDTO = new DoctorDTO();
			doctorDTO.getDTO(doctor);
			doctorList.add(doctorDTO);
		});
		return doctorList;
	}
	
	public DoctorDTO getDoctorsById(Integer doctorId) {
		Optional<Doctor> optional = doctorRepository.findById(doctorId);
		DoctorDTO doctorDTO = new DoctorDTO();
		if(optional.isPresent()) {
			Doctor doctor = optional.get();
			doctorDTO.getDTO(doctor);
		}
		return doctorDTO;
	}
	
	public Integer addDoctor(DoctorDTO doctorDTO) throws EasydocException {
		Optional<Doctor> docOptional = Optional.ofNullable(doctorRepository.findByEmail(doctorDTO.getEmail()));
		if(docOptional.isPresent()) {
			throw new EasydocException("This user already exists.");
		}
		Doctor doctor = doctorDTO.getEntity();
		Integer savedDoctorId = doctorRepository.save(doctor).getDoctorId();
		return savedDoctorId;
	}

	public DoctorDTO login(String email, String password) throws EasydocException {
		DoctorDTO doctorDTO = new DoctorDTO();
		 Optional<Doctor> optionalDoctor = Optional.ofNullable(doctorRepository.findByEmail(email));
		 if(optionalDoctor.isEmpty() || !optionalDoctor.get().getPassword().equals(password))
			 throw new EasydocException("Wrong Credentials");
		 doctorDTO.getDTO(optionalDoctor.get());
		 return doctorDTO;
	}
}
