package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.FriendListDao;
import com.revature.models.FriendList;
import com.revature.models.User;

@Service
public class FriendListService {

	@Autowired
	private FriendListDao friendListDao; 
	
	public FriendList findall(int owner) {
		return friendListDao.findAll(owner);
	};
	
	public void updateFriends(int owner, User friend) {
		friendListDao.updateFriends(owner, friend);
	};
	
	public void saveFriends(int owner, User friend) {
		friendListDao.saveFriends(owner, friend);
	};
	
	
}
