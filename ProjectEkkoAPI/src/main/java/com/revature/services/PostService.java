package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.PostDao;
import com.revature.models.Post;
import com.revature.models.User;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;

	public List<Post> findByUserId(int uid, int page) {
		return postDao.findByUserId(uid, page);
	}
	
	public String getMaxPageByUserId(int uid) {
		return Integer.toString(postDao.getMaxPageUserId(uid));
	}
	
	public void save(int uid, Post post) {
		post.setOwner(new User(uid, "", ""));
		postDao.save(post);
	}
}
