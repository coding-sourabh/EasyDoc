package com.easydoc.dto;

import com.easydoc.entity.Patient;

public class PatientDTO {
	private Integer patientId;
	private String name;
	private String email;
	private String password;
	private Float height;
	private Float weight;
	private int age;
	private String profileImg;
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
	public Patient toEntity() {
		Patient patient = new Patient();
		patient.setPatientId(this.patientId);
		patient.setName(this.name);
		patient.setEmail(this.email);
		patient.setPassword(this.password);
		patient.setAge(this.age);
		patient.setHeight(this.height);
		patient.setWeight(this.weight);
		patient.setProfileImg(this.profileImg);
		return patient;
	}
	
	public void setDTO(Patient patient) {
		this.setPatientId(patient.getPatientId());
		this.setName(patient.getName());
		this.setEmail(patient.getEmail());
		this.setPassword(patient.getPassword());
		this.setAge(patient.getAge());
		this.setHeight(patient.getHeight());
		this.setWeight(patient.getWeight());
		this.setProfileImg(patient.getProfileImg());
	}
}
