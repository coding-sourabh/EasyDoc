package com.easydoc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easydoc.dto.ChatMessageDTO;
import com.easydoc.service.ChatService;

@RestController
@CrossOrigin
@RequestMapping(value = "api")
public class ChatApi {
	
	@Autowired
	ChatService chatService;
	
	@PostMapping(value="message/push/{patientId}/{doctorId}")
	ResponseEntity<String> pushMessage(@PathVariable Integer patientId, @PathVariable Integer doctorId, @RequestBody ChatMessageDTO messageDTO) {
		chatService.pushMessage(patientId, doctorId, messageDTO);
		return new ResponseEntity<String>("Message pushed", HttpStatus.OK);
	}
	
	@GetMapping(value="message/{patientId}/{doctorId}")
	ResponseEntity<List<ChatMessageDTO>> getMessages(@PathVariable Integer patientId, @PathVariable Integer doctorId) {
		List<ChatMessageDTO> messageList =  chatService.getAllMessages(patientId, doctorId);
		return new ResponseEntity<List<ChatMessageDTO>>(messageList, HttpStatus.OK);
	}
}
