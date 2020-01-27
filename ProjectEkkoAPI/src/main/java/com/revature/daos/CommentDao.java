package com.revature.daos;

import java.util.List;

import com.revature.models.Comment;

public interface CommentDao {

	public List<Comment> getCommentsByPostId(int pid);

	public void save(Comment comment);

	public int getMaxPageByPostId(int pid);
}
