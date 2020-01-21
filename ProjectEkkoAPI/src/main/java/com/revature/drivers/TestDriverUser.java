package com.revature.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.IUserDao;
import com.revature.models.User;

public class TestDriverUser {

	ApplicationContext ac = new ClassPathXmlApplicationContext("../webapp/WEB-INF/applicationContext.xml");
	
	IUserDao dao = (IUserDao) ac.getBean("userDao");
	
	User a = new User(1,"airton","password");
	//dao.save(a); 
	User u = dao.findByUsernamePassword("airton", "password");
}
