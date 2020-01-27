package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Comment;
import com.revature.models.CommentDto;
import com.revature.services.CommentService;
import com.revature.util.Log;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private Log log;
	
	@GetMapping("/comments/{pid}")
	private ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable("pid") int pid) {
		log.info("Method: GET, uri: /comments/" + pid + "(post id)");
		
		List<Comment> comments = commentService.getCommentsByPostId(pid);
		if (comments.size() == 0) {
			log.info("No record found.");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(comments);
		}
	}
	
	@PostMapping("/comments/{pid}")
	private ResponseEntity<Comment> save(@PathVariable("pid") int pid, @RequestBody CommentDto commentDto) {
		log.info("Method: POST, uri: /comments/" + pid + "(post id)");
		log.info("Data transfered: " + commentDto);
		
		if (commentDto != null) {
			commentService.save(commentDto.getUid(), pid, new Comment(commentDto.getContent()));
			log.info("Successfully inserted the Comment");
			return ResponseEntity.ok().header("X-test", "test").build();
		} else {
			log.info("Request Body is not found.");
			return ResponseEntity.badRequest().build();
		}
	}
}
