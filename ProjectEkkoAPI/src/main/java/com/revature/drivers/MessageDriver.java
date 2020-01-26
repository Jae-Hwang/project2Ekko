package com.revature.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.DirectMessageDao;
import com.revature.daos.GroupChatDao;
import com.revature.daos.UserDao;
import com.revature.models.DirectMessage;

public class MessageDriver {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DirectMessageDao messDao = (DirectMessageDao) ac.getBean("directMessageDaoImpl");
		
		// All work
		messDao.save(new DirectMessage(1, 1, 2, "This is a test message, hope I'm alive"));
		messDao.save(new DirectMessage(3, 3, 1, "This is another test message, hope I'm alive and correctly spelt"));
		messDao.save(new DirectMessage(5, 2, 3, "This is another test message, hope I'm alive but dont show up"));
//		
		// And doesn't show the message whose user is not included
//		messDao.findById(1).forEach(dm -> {
//			System.out.println(dm);
//		});
		
//		GroupChatDao gcDao = (GroupChatDao) ac.getBean("groupChatDaoImpl");
		
		// Don't create a message directly
//		gcDao.creatGroupChatMessage(new GroupChatMessage("This is not the end"));
		
		// Create it and reference the chat it belongs to
//		gcDao.creatGroupChatMessage(new GroupChatMessage(7, "This is my first message", new GroupChat(202)));
//		gcDao.creatGroupChatMessage(new GroupChatMessage(13, "This is my second message", new GroupChat(202)));
		
//		gcDao.findGroupChats().forEach(chat -> {
//			System.out.println(chat);
//		});
//		gcDao.findMessages().forEach(msg -> {
//			System.out.println(msg);
//		});
		
//		UserDao uD = (UserDao) ac.getBean("userDaoImpl");
		
		// Works
//		uD.makeGroupChat(new GroupChat("New Chat", new User(1052)));
		
		// Works in adding a user to an existing chat
//		GroupChat gc = gcDao.findChatById(802);
//		User u = uD.FindById(153);
//		System.out.println(gc.getUserList().add(u));
//		uD.addToGroupChat(gc);
//		System.out.println(gcDao.findChatById(802));
		
//		gcDao.creatGroupChatMessage(new GroupChatMessage("What up my glip glop", new GroupChat(802)));
//		System.out.println(gcDao.findChatById(802));
	}

}
