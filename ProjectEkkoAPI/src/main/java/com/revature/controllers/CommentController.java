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
import com.revature.services.CommentService;
import com.revature.util.Log;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private Log log;
	
	@GetMapping("/comments/{pid}/{page}")
	private ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable("pid") int pid, @PathVariable("page") int page) {
		log.info("Method: GET, uri: /comments/" + pid + "(post id)/" + page + "(page)");
		
		List<Comment> comments = commentService.getCommentsByPostId(pid, page);
		if (comments.size() == 0) {
			log.info("No record found.");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(comments);
		}
	}
	
	@PostMapping("/comments/{uid}/{pid}")
	private ResponseEntity<Comment> save(@PathVariable("uid") int uid, @PathVariable("pid") int pid, @RequestBody Comment comment) {
		log.info("Method: POST, uri: /comments/" + uid + "(user id)/" + pid + "(post id)");
		
		if (comment != null) {
			commentService.save(uid, pid, comment);
			log.info("Successfully inserted the post");
			return ResponseEntity.ok().header("X-test", "test").build();
		} else {
			log.info("Request Body is not found.");
			return ResponseEntity.badRequest().build();
		}
	}
}
