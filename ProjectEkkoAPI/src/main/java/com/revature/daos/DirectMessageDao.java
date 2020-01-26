package com.revature.daos;

import java.util.List;

import com.revature.models.DirectMessage;

// Interfaces don't get @Repository
public interface DirectMessageDao {
	
	public List<DirectMessage> findById(int id);
	public void save(DirectMessage m);

}
