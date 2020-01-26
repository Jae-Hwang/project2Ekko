package com.revature.daos;

import com.revature.models.GroupChat;
import com.revature.models.User;

public interface UserDao {
	
	public User findByUsernamePassword(String user, String pass);
	public void save(User u);
	public User FindById(int id);
	public void makeGroupChat(GroupChat gc);
	public void addToGroupChat(GroupChat gc);
	
}
