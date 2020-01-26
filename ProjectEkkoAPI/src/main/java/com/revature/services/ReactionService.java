package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.ReactionDao;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.Reaction;
import com.revature.util.Log;

@Service
public class ReactionService {
	
	@Autowired
	private ReactionDao reactionDao;
	
	@Autowired
	private Log log;
	
	public List<Reaction> getReactionsByPostId(int pid) {
		return reactionDao.getReactionsByPostId(pid);
	}
	
	public List<Reaction> getReactionsByCommentId(int cid) {
		return reactionDao.getReactionsByCommentId(cid);
	}
	
	public void savePostReaction(int pid, Reaction reaction) {
		reaction.setParentPost(new Post(pid));
		reactionDao.save(reaction);
	}
	
	public void saveCommentReaction(int cid, Reaction reaction) {
		reaction.setParentComment(new Comment(cid));
		reactionDao.save(reaction);
	}
	
	public void delete(int rid) {
		reactionDao.delete(new Reaction(rid));
	}
	
	public void deleteByUserIdAndCommentsId(int uid, int cid) {
		List<Reaction> r = reactionDao.getReactionsByCommentId(cid);
		for (Reaction reaction : r) {
			if (reaction.getOwner().getId() == uid) {
				reactionDao.delete(reaction);
				return;
			}
		}
		log.info("was not able to delete");
	}
	
	public void deleteByUserIdAndPostsId(int uid, int pid) {
		List<Reaction> r = reactionDao.getReactionsByPostId(pid);
		for (Reaction reaction : r) {
			if (reaction.getOwner().getId() == uid) {
				reactionDao.delete(reaction);
				return;
			}
		}
		log.info("was not able to delete");
	}
	
}
