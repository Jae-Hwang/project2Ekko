package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.CommentDao;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;

@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> getCommentsByPostId(int pid, int page) {
		return commentDao.getCommentsByPostId(pid, page);
	}
	
	public void save(int uid, int pid, Comment comment) {
		comment.setOwner(new User(uid, "", ""));
		comment.setParent(new Post(pid));
		commentDao.save(comment);
	}
}
