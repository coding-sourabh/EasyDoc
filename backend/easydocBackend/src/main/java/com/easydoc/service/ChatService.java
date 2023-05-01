package com.easydoc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoc.dto.ChatMessageDTO;
import com.easydoc.entity.ChatMessage;
import com.easydoc.repository.ChatRepository;
import com.pusher.rest.Pusher;

@Service(value="chatService")
public class ChatService {

	@Autowired
	ChatRepository chatRepository;
	
	Pusher pusher = new Pusher("1558327", "34ba18071d982e21615a", "23abbc51dd5db9420aed");
	
	public void pushMessage(Integer patientId, Integer doctorId, ChatMessageDTO messageDTO) {
		pusher.setCluster("mt1");
		pusher.setEncrypted(true);
		String channel = "p" + patientId.toString() + "d" + doctorId.toString();
		pusher.trigger(channel, "chat", Collections.singletonMap("message", messageDTO));
		
		ChatMessage chatMessage = messageDTO.toEntity();
	    chatRepository.save(chatMessage);
	}
	
	public List<ChatMessageDTO> getAllMessages(Integer patientId, Integer doctorId) {
		List<ChatMessage> entityList = chatRepository.findBypatientIdAndDoctorId(patientId, doctorId);
		List<ChatMessageDTO> list = new ArrayList<>(); 
		for(ChatMessage mssg: entityList) {
			ChatMessageDTO messageDTO = new ChatMessageDTO();
			messageDTO.setDTO(mssg);
			list.add(messageDTO);
		}
		return list;
	}
}
