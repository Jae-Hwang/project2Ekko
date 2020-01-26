package com.revature.daos;

import com.revature.models.User;

public interface UserDao {
	
	public User findByUsernamePassword(String user, String pass);
	public void save(User u);
	public User FindById(int id);
	public User findByUsername(String username);
	
}
