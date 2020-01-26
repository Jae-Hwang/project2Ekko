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

import com.revature.models.Post;
import com.revature.services.PostService;
import com.revature.util.Log;

@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private Log log;

	@GetMapping("/posts/{uid}/{page}")
	public ResponseEntity<List<Post>> findByUserId(@PathVariable("uid") int uid, @PathVariable("page") int page) {
		log.info("Method: GET, uri: /posts/" + uid + "(user id)/" + page + "(page)");
		
		List<Post> posts = postService.findByUserId(uid, page);
		if (posts.size() == 0) {
			log.info("No record found.");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("X-test", "test").body(posts);
		}
	}

	@PostMapping("/posts/{uid}")
	public ResponseEntity<Post> save(@PathVariable("uid") int uid, @RequestBody Post post) {
		log.info("Method: POST, uri: /posts/" + uid + "(user id)");
		
		if (post != null) {
			postService.save(uid, post);
			log.info("Successfully inserted the Post");
			return ResponseEntity.ok().header("X-test", "test").build();
		} else {
			log.info("Request Body is not found.");
			return ResponseEntity.badRequest().build();
		}

	}
}
