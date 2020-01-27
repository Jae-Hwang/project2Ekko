package com.revature.daos;

import java.util.List;

import com.revature.models.Post;
import com.revature.models.User;

public interface PostDao {

	public List<Post> findAll(int page);
	
	public List<Post> findByUserId(int uid, int page);
	
	public void save(Post post);
	
	public int getMaxPageUserId(int uid);
	
	public List<Post> findByFriends(List<User> friends, int page);
	
	public int getMaxPageFriends(List<User> friends);
}
