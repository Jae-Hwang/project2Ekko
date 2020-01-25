package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<User> findByUsernamePassword(@RequestBody User u) {
		//log.info("Method: GET, uri: /logging/");
		
		User user = userService.findByUsernamePassword(u.getUsername(), u.getPassword());
		if (user == null) {
			//log.info("No record found.");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@RequestBody User u) {
		//log.info("Method: POST, uri: /register" + user+ u);
		
		if (u != null) {
			userService.save(u);
			//log.info("Successfully registered user");
			return ResponseEntity.ok().header("X-test", "test").build();
		} else {
			//log.info("Request Body is not found.");
			return ResponseEntity.badRequest().build();
		}

	}
	
	
}
