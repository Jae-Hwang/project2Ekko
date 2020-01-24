package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.ReactionDao;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.Reaction;

@Service
public class ReactionService {
	
	@Autowired
	private ReactionDao reactionDao;
	
	public List<Reaction> getReactionsByPostId(int pid, int page) {
		return reactionDao.getReactionsByPostId(pid, page);
	}
	
	public List<Reaction> getReactionsByCommentId(int cid, int page) {
		return reactionDao.getReactionsByCommentId(cid, page);
	}
	
	public void savePostReaction(int pid, Reaction reaction) {
		reaction.setParentPost(new Post(pid));
		reactionDao.save(reaction);
	}
	
	public void saveCommentReaction(int cid, Reaction reaction) {
		reaction.setParentComment(new Comment(cid));
		reactionDao.save(reaction);
	}
}
