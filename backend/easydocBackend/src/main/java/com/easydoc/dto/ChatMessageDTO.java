package com.easydoc.dto;

import com.easydoc.entity.ChatMessage;

public class ChatMessageDTO {
    private Integer messageId;
	private Integer doctorId;
	private Integer patientId;
	private String message;
	private String timestamp;
	private String messageBy;
	
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessageBy() {
		return messageBy;
	}
	public void setMessageBy(String by) {
		this.messageBy = by;
	}
	
	public ChatMessage toEntity() {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setMessageId(this.getMessageId());
		chatMessage.setPatientId(this.getPatientId());
		chatMessage.setDoctorId(this.getDoctorId());
		chatMessage.setMessage(this.getMessage());
		chatMessage.setTimestamp(this.getTimestamp());
		chatMessage.setMessageBy(this.getMessageBy());
		return chatMessage;
	}
	
	public void setDTO(ChatMessage chatMessage) {
		this.setMessageId(chatMessage.getMessageId());
		this.setPatientId(chatMessage.getPatientId());
		this.setDoctorId(chatMessage.getDoctorId());
		this.setMessage(chatMessage.getMessage());
		this.setTimestamp(chatMessage.getTimestamp());
		this.setMessageBy(chatMessage.getMessageBy());
	}
}
