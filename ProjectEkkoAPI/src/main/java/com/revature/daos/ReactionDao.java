package com.revature.daos;

import java.util.List;

import com.revature.models.Reaction;

public interface ReactionDao {

	public List<Reaction> getReactionsByPostId(int pid);

	public List<Reaction> getReactionsByCommentId(int cid);

	public void save(Reaction reaction);

	public int getMaxPagePostReaction(int pid);

	public int getMaxPageCommentReaction(int cid);
	
	public void delete(Reaction reaction);
}
