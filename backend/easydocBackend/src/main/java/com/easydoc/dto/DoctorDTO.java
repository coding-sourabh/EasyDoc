package com.easydoc.dto;

import com.easydoc.entity.Doctor;

public class DoctorDTO {
	private Integer doctorId;
	private String name;
	private String email;
	private String password;
	private String specialist;
	private String profileImg;
	private Float fees;
	private Float experience;
	
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public Float getFees() {
		return fees;
	}
	public void setFees(Float fees) {
		this.fees = fees;
	}
	public Float getExperience() {
		return experience;
	}
	public void setExperience(Float experience) {
		this.experience = experience;
	}
	
	public Doctor getEntity() {
		Doctor doctor = new Doctor();
		doctor.setDoctorId(this.getDoctorId());
		doctor.setName(this.getName());
		doctor.setEmail(this.getEmail());
		doctor.setPassword(this.getPassword());
		doctor.setSpecialist(this.getSpecialist());
		doctor.setExperience(this.getExperience());
		doctor.setProfileImg(this.getProfileImg());
		doctor.setFees(this.getFees());
		return doctor;
	}
	
	public void getDTO(Doctor doctor) {
		this.setDoctorId(doctor.getDoctorId());
		this.setName(doctor.getName());
		this.setEmail(doctor.getEmail());
		this.setPassword(doctor.getPassword());
		this.setSpecialist(doctor.getSpecialist());
		this.setExperience(doctor.getExperience());
		this.setProfileImg(doctor.getProfileImg());
		this.setFees(doctor.getFees());
	}
}
