package com.revature.daos;

import java.util.List;

import com.revature.models.GroupChat;
import com.revature.models.GroupChatMessage;

public interface GroupChatDao {
		
	public void createGroupChat(GroupChat gc);
	public void creatGroupChatMessage(GroupChatMessage gcm);
	public void update(GroupChat gc);
	GroupChat findChatById(int id);
	List<GroupChat> findGroupChats(); // for testing purposes
	List<GroupChatMessage> findMessages(); // for testing purposes
	GroupChatMessage findMessageById(int id);

}
