package com.easydoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easydoc.entity.ChatMessage;

public interface ChatRepository extends CrudRepository<ChatMessage, Integer> {
	public List<ChatMessage> findBypatientIdAndDoctorId(Integer patientId, Integer doctorId);
}
