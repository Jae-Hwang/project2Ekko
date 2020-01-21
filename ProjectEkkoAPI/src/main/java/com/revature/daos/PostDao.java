package com.revature.daos;

import java.util.List;

import com.revature.models.Post;

public interface PostDao {

	public List<Post> findAll(int page);
	
	public List<Post> findByUserId(int uid, int page);
	
	public Post save(Post post);
}
