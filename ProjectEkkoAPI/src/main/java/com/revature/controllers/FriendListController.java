package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.revature.services.UserService;

@RestController
public class FriendListController {

	@Autowired
	private FriendListService FLService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/friends/{uid}")
	public ResponseEntity<List<User>> findall(@PathVariable("uid") int uid) {
		
		FriendList friends = FLService.findall(uid);
		List user = new ArrayList<User>(friends.getUsers());
//		List names = new ArrayList<String>();
//		for(int i=0;i<user.size();i++) {
//			System.out.println(user.get(i));
//		}
		if (friends.getUsers().isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("X-test", "test").body(user);
		}
	}
	
	@PostMapping("/friends/save") 
	public ResponseEntity<FriendList> save(@RequestBody User u) {
		//log.info("Method: GET, uri: /logging/");
		User user = userService.findByUsername(u.getUsername());
		FLService.saveFriends(u.getId(), user);
		
		return ResponseEntity.ok().header("X-test", "test").build();
	}
	
	@PostMapping("/friends/update") 
	public ResponseEntity<FriendList> update(@RequestBody User u) {
		//log.info("Method: GET, uri: /logging/");
		User user = userService.findByUsername(u.getUsername());
		FLService.updateFriends(u.getId(), user);
		
		return ResponseEntity.ok().header("X-test", "test").build();
	}
	
	
}
