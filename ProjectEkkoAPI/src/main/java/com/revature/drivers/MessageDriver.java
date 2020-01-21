package com.revature.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.MessageDao;
import com.revature.models.Message;

public class MessageDriver {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageDao messDao = (MessageDao) ac.getBean("messageDaoImpl");
		
		messDao.save(new Message(1, 1, 2, "This is a test message, hop I'm alive"));
		
		System.out.println(messDao.findById(1));
		
	}

}
