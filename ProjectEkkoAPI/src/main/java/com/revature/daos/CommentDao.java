package com.revature.daos;

import java.util.List;

import com.revature.models.Comment;

public interface CommentDao {

	public List<Comment> getCommentsByPostId(int pid, int page);

	public Comment save(Comment comment);
}
