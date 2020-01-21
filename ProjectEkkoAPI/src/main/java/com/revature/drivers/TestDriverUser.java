package com.revature.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.IUserDao;

public class TestDriverUser {

	ApplicationContext ac = new ClassPathXmlApplicationContext("../webapp/WEB-INF/applicationContext.xml");
	
	IUserDao dao = (IUserDao) ac.getBean("userDao");
}
