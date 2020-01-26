package com.revature.daos;

import java.util.List;

import com.revature.models.FriendList;
import com.revature.models.User;

public interface FriendListDao {

	public List<User> findAll(int owner);
	public List<FriendList> findById(int id);
	public void updateFriends(int onwer, User friend); 
	public void saveFriends(int owner, User friend);
}
