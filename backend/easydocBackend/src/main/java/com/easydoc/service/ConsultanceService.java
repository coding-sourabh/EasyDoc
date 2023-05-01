package com.easydoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.ConsultanceDTO;
import com.easydoc.entity.Consultance;
import com.easydoc.entity.Doctor;
import com.easydoc.repository.ConsultanceRepository;
import com.easydoc.repository.DoctorRepository;

import jakarta.transaction.Transactional;

@Service(value = "consultanceService")
@Transactional
public class ConsultanceService {
	@Autowired
	ConsultanceRepository consultanceRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	public List<ConsultanceDTO> getAllConsultanceOfPatient(Integer patientId) {
		List<ConsultanceDTO> list = new ArrayList<ConsultanceDTO>();
		List<Consultance> entityList = consultanceRepository.findByPatientId(patientId);
		entityList.forEach(c -> {
			ConsultanceDTO cdto = new ConsultanceDTO();
			cdto.setDTO(c);
			list.add(cdto);
		});
		return list;
	}
	
	public Integer addConsultance(ConsultanceDTO consultanceDTO) { 
		Consultance consultance = new Consultance();
		Optional<Doctor> optionalDoc = doctorRepository.findById(consultanceDTO.getDoctorId());
		
	 	Optional<Consultance> consultOptional = Optional.ofNullable(
	 			consultanceRepository.findByPatientIdAndDoctor(consultanceDTO.getPatientId(), optionalDoc.get()));
		if(consultOptional.isPresent()) {
			return consultOptional.get().getConsultId();
		}
	 	
		consultance.setPatientId(consultanceDTO.getPatientId());
		consultance.setDateTime(consultanceDTO.getDateTime());
		consultance.setDoctor(optionalDoc.get());
		Integer savedConsultanceId = consultanceRepository.save(consultance).getConsultId();
		return savedConsultanceId;
	}
}
