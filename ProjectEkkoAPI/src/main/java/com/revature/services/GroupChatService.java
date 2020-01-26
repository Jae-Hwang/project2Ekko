package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.GroupChatDao;
import com.revature.daos.UserDao;
import com.revature.models.GroupChat;
import com.revature.models.GroupChatMessage;
import com.revature.models.User;

@Service
public class GroupChatService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private GroupChatDao gcDao;
	
	public void makeGroupChat(GroupChat gc) {
		userDao.makeGroupChat(gc);
	};
	
	public void addToGroupChat(GroupChat gc) {
		userDao.addToGroupChat(gc);
	};
	
	public User FindById(int id) {
		return userDao.FindById(id);
	};
	
	public void creatGroupChatMessage(GroupChatMessage gcm) {
		gcDao.creatGroupChatMessage(gcm);
	}
	
	public GroupChat findChatById(int id) {
		return gcDao.findChatById(id);
	}
	
}
