package com.easydoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	}
