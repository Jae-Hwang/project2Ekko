package com.revature.daos;

import java.util.List;

import com.revature.models.Message;

// Interfaces don't get @Repository
public interface MessageDao {
	
	public List<Message> findById(int id);
	
	public void save(Message m);

}
