package com.revature.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Message;

@Controller
public class MessageController {
	
	@GetMapping("/message/id}")
	@ResponseBody
	public ResponseEntity<Message> findById(@PathVariable("id") int id) {

		return null;
	}

}
