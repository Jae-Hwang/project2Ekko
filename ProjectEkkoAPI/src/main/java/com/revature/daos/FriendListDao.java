package com.revature.daos;

import java.util.List;

import com.revature.models.FriendList;
import com.revature.models.User;

public interface FriendListDao {

	public List<FriendList> findAll();
	public List<User> findById(int id);
}
