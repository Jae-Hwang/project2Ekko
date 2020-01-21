package com.revature.daos;

import com.revature.models.User;

public interface UserDao {
	
	public User findByUsernamePassword(String username, String password);
	public void save(User u);
	
}
