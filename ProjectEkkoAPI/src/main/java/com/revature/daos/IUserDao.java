package com.revature.daos;

import com.revature.models.User;

public interface IUserDao {
	
	public User findByUsernamePassword(String username, String password);
	public void save(User u);
	
}
