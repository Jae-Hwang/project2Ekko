package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reaction;
import com.revature.models.ReactionDto;
import com.revature.services.ReactionService;
import com.revature.util.Log;

@RestController
public class ReactionController {

	@Autowired
	private ReactionService reactionService;

	@Autowired
	private Log log;

	@GetMapping("/reactions/comments/{cid}/{page}")
	public ResponseEntity<List<Reaction>> getReactionsByCommentId(@PathVariable("cid") int cid,
			@PathVariable("page") int page) {
		log.info("Method: GET, uri: /reactions/comments/" + cid + "(comment id)/" + page + "(page)");

		List<Reaction> reactions = reactionService.getReactionsByCommentId(cid);
		if (reactions.size() == 0) {
			log.info("No record found.");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(reactions);
		}
	}

	@GetMapping("/reactions/posts/{pid}/{page}")
	public ResponseEntity<List<Reaction>> getReactionsByPostId(@PathVariable("pid") int pid,
			@PathVariable("page") int page) {
		log.info("Method: GET, uri: /reactions/posts/" + pid + "(post id)/" + page + "(page)");

		List<Reaction> reactions = reactionService.getReactionsByPostId(pid);
		if (reactions.size() == 0) {
			log.info("No record found.");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(reactions);
		}
	}

	@PostMapping("/reactions/comments/{cid}")
	public ResponseEntity<Reaction> saveCommentReaction(@PathVariable("cid") int cid,
			@RequestBody ReactionDto reactionDto) {
		log.info("Method: POST, uri: /reactions/comments/" + cid + "(comment id)");
		log.info("Data transfered: " + reactionDto);

		if (reactionDto != null) {
			reactionService.saveCommentReaction(cid, new Reaction(reactionDto.getUid(), reactionDto.getType()));
			log.info("Successfully inserted the post");
			return ResponseEntity.ok().build();
		} else {
			log.info("Request Body is not found.");
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/reactions/posts/{pid}")
	public ResponseEntity<Reaction> savePostReaction(@PathVariable("pid") int pid,
			@RequestBody ReactionDto reactionDto) {
		log.info("Method: POST, uri: /reactions/posts/" + pid + "(post id)");
		log.info("Data transfered: " + reactionDto);

		if (reactionDto != null) {
			reactionService.savePostReaction(pid, new Reaction(reactionDto.getUid(), reactionDto.getType()));
			log.info("Successfully inserted the post");
			return ResponseEntity.ok().build();
		} else {
			log.info("Request Body is not found.");
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/reactions/{rid}")
	public ResponseEntity<Reaction> delete(@PathVariable("rid") int rid) {
		log.info("Method: DELETE, uri: /reactions/" + rid + "(reaction id)");

		reactionService.delete(rid);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/reactions/comments/{uid}/{cid}")
	public ResponseEntity<Reaction> deleteByUserIdAndCommentsId(@PathVariable("uid") int uid,
			@PathVariable("cid") int cid) {
		log.info("Method: DELETE, uri: /reactions/comments/" + uid + "(user id)/" + cid + "(comment id)");

		reactionService.deleteByUserIdAndCommentsId(uid, cid);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/reactions/posts/{uid}/{pid}")
	public ResponseEntity<Reaction> deleteByUserIdAndPostsId(@PathVariable("uid") int uid,
			@PathVariable("pid") int pid) {
		log.info("Method: DELETE, uri: /reactions/posts/" + uid + "(user id)/" + pid + "(post id)");

		reactionService.deleteByUserIdAndPostsId(uid, pid);
		return ResponseEntity.ok().build();
	}
}
