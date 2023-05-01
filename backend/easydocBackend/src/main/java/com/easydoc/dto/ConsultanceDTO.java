package com.easydoc.dto;

import java.util.Date;

import com.easydoc.entity.Consultance;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ConsultanceDTO {
	private Integer consultId;
	private Integer patientId;
	private Integer doctorId;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="Asia/Kolkata")
	private Date dateTime;
	
	public Integer getConsultId() {
		return consultId;
	}
	public void setConsultId(Integer consultId) {
		this.consultId = consultId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public Consultance toEntity() {
		Consultance consultance = new Consultance();
		consultance.setConsultId(this.getConsultId());
//		consultance.setDoctor(this.getDoctorDTO().getEntity());
		consultance.setPatientId(this.getPatientId());
		consultance.setDateTime(this.getDateTime());;
		return consultance;
	}
	
	public void setDTO(Consultance consultance) {
		this.setConsultId(consultance.getConsultId());
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.getDTO(consultance.getDoctor());
		this.setDoctorId(doctorDTO.getDoctorId());
		this.setPatientId(consultance.getPatientId());
		this.setDateTime(consultance.getDateTime());;
	}
	
}
