package com.revature.drivers;

import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.GroupChatDao;
import com.revature.models.GroupChat;
import com.revature.models.GroupChatMessage;

public class MessageDriver {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		DirectMessageDao messDao = (DirectMessageDao) ac.getBean("directMessageDaoImpl");
		
		// All work
//		messDao.save(new DirectMessage(1, 1, 2, "This is a test message, hope I'm alive"));
//		messDao.save(new DirectMessage(3, 3, 1, "This is another test message, hope I'm alive and corrctly spelt"));
//		messDao.save(new DirectMessage(5, 2, 3, "This is another test message, hope I'm alive but dont show up"));
//		
		//  and doesn't show the message whose user is not included
//		messDao.findById(1).forEach(dm -> {
//			System.out.println(dm);
//		});
		
		GroupChatDao gcDao = (GroupChatDao) ac.getBean("groupChatDaoImpl");
		
		// Works
//		gcDao.createGroupChat(new GroupChat("The tested name"));
//		gcDao.creatGroupChatMessage(new GroupChatMessage("This is not the end"));
//		gcDao.creatGroupChatMessage(new GroupChatMessage("They'll never see me coming"));
//		gcDao.creatGroupChatMessage(new GroupChatMessage(7, "This is my first message", new GroupChat(202)));
		
		gcDao.findGroupChats().forEach(chat -> {
			System.out.println(chat);
		});
//		System.out.println(cgc.addMessage(cgcm));
	}

}
