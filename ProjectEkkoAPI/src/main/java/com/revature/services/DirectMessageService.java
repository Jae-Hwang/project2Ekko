package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.DirectMessageDao;
import com.revature.models.DirectMessage;

@Service
public class DirectMessageService {

	@Autowired
	private DirectMessageDao dirMsgDao;
	
	public List<DirectMessage> findById(int id) {
		return dirMsgDao.findById(id);
	};
	
	public void save(DirectMessage m) {
		dirMsgDao.save(m);
	};
	
}
