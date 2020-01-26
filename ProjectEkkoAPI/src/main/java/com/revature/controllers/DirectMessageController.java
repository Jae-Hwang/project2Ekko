package com.revature.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.DirectMessage;
import com.revature.services.DirectMessageService;

@RestController
public class DirectMessageController {
	
	@Autowired
	private DirectMessageService DMService;
	
	@GetMapping("/directMsg/{uid}")
	public ResponseEntity<List<DirectMessage>> findById(@PathVariable("uid") int uid) {
		
		List<DirectMessage> dirMsgs = DMService.findById(uid);
		return ResponseEntity.status(HttpStatus.OK).header("Not X-test", "test").body(dirMsgs);
		
	}
	
	@PostMapping("/directMsg/save")
	public ResponseEntity<DirectMessage> save(@RequestBody DirectMessage m) {
		DirectMessage newM = new DirectMessage(m.getUser1Id(), m.getUser2Id(), m.getMessage());
		DMService.save(newM);
		return ResponseEntity.ok().header("Message created", "test").build();
	}

}
