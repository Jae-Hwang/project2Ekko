package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.GroupChat;
import com.revature.models.GroupChatMessage;
import com.revature.models.User;
import com.revature.services.GroupChatService;

@RestController
public class GroupChatController {
	
	@Autowired
	private GroupChatService GCService;
	
	@PostMapping("/groupChat/create")
	public ResponseEntity<GroupChat> makeGroupChat(@RequestBody GroupChat gc) {
		System.out.println(gc); // REMOVE AFTER
		GroupChat newGC = new GroupChat(gc.getChatName(), new User(gc.getId()));
		System.out.println(newGC); // REMOVE AFTER
		GCService.makeGroupChat(newGC);
		return ResponseEntity.ok().header("Created group chat", "test").build();
	}
	
	@PostMapping("/groupChat/addUser") // Get the findChatById function first
	public ResponseEntity<GroupChat> addToGroupChat(@RequestBody GroupChat gc, User u) {
		GroupChat currentChat = GCService.findChatById(gc.getId());
		User newUser = GCService.FindById(u.getId());
		currentChat.getUserList().add(newUser);
		GCService.addToGroupChat(currentChat);
		return ResponseEntity.ok().header("Added user to chat", "test").build();
	}

	@PostMapping("/groupChat/addMsg")
	public ResponseEntity<GroupChatMessage> creatGroupChatMessage(@RequestBody GroupChatMessage gcm) {
		GroupChatMessage newMessage = new GroupChatMessage(gcm.getChatMessage(), new GroupChat(gcm.getId()));
		GCService.creatGroupChatMessage(newMessage);
		return ResponseEntity.ok().header("Typing new message to chat", "test").build();
	}
	
	
}
