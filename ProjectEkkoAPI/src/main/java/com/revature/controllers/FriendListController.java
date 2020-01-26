package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.FriendList;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.services.FriendListService;

@RestController
public class FriendListController {

	@Autowired
	private FriendListService FLService;
	
	@GetMapping("/friends/{uid}")
	public ResponseEntity<FriendList> findall(@PathVariable("uid") int uid) {
		
		FriendList friends = FLService.findall(uid);
		if (friends.getUsers().isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("X-test", "test").body(friends);
		}
	}
	
	@PostMapping("/friends/save") 
	public ResponseEntity<FriendList> save(@RequestBody FriendList u) {
		//log.info("Method: GET, uri: /logging/");
		System.out.println(u);
		List<User> nl = new ArrayList<>(u.getUsers());
		FLService.saveFriends(u.getId(), nl.get(0));
		
		return ResponseEntity.ok().header("X-test", "test").build();
	}
	
	
}
