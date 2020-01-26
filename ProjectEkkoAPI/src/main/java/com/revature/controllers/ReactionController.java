package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reaction;
import com.revature.services.ReactionService;
import com.revature.util.Log;

@RestController
public class ReactionController {

	@Autowired
	private ReactionService reactionService;
	
	@Autowired
	private Log log;
	
	@GetMapping("/reactions/comments/{cid}/{page}")
	public ResponseEntity<List<Reaction>> getReactionsByCommentId(@PathVariable("cid") int cid, @PathVariable("page") int page) {
		log.info("Method: GET, uri: /reactions/" + cid + "(comment id)/" + page + "(page)");
		
		List<Reaction> reactions = reactionService.getReactionsByCommentId(cid, page);
		if (reactions.size() == 0) {
			log.info("No record found.");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(reactions);
		}
	}
	
	@GetMapping("/reactions/posts/{pid}/{page}")
	public ResponseEntity<List<Reaction>> getReactionsByPostId(@PathVariable("pid") int pid, @PathVariable("page") int page) {
		log.info("Method: GET, uri: /reactions/" + pid + "(post id)/" + page + "(page)");
		
		List<Reaction> reactions = reactionService.getReactionsByPostId(pid, page);
		if (reactions.size() == 0) {
			log.info("No record found.");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(reactions);
		}
	}
	
	@PostMapping("/reactions/comments/{cid}")
	public ResponseEntity<Reaction> saveCommentReaction(@PathVariable("cid") int cid, @RequestBody Reaction reaction) {
		log.info("Method: POST, uri: /reactions/" + cid + "(comment id)");
		
		if (reaction != null) {
			reactionService.saveCommentReaction(cid, reaction);
			log.info("Successfully inserted the post");
			return ResponseEntity.ok().header("X-test", "test").build();
		} else {
			log.info("Request Body is not found.");
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/reactions/posts/{cid}")
	public ResponseEntity<Reaction> savePostReaction(@PathVariable("pid") int pid, @RequestBody Reaction reaction) {
		log.info("Method: POST, uri: /reactions/" + pid + "(post id)");
		
		if (reaction != null) {
			reactionService.savePostReaction(pid, reaction);
			log.info("Successfully inserted the post");
			return ResponseEntity.ok().header("X-test", "test").build();
		} else {
			log.info("Request Body is not found.");
			return ResponseEntity.badRequest().build();
		}
	}
}
