package com.revature.daos;

import java.util.List;

import com.revature.models.Reaction;

public interface ReactionDao {

	public List<Reaction> getReactionsByPostId(int pid, int page);
	
	public List<Reaction> getReactionsByCommentId(int cid, int page);
	
	public Reaction addReactionToPost(int pid, Reaction reaction);
	
	public Reaction addReactionToComment(int cid, Reaction reaction);
}
