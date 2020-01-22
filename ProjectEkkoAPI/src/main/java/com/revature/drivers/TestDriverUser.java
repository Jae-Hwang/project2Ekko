package com.revature.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class TestDriverUser {

	public static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserDao dao = (UserDao) ac.getBean("userDaoImpl");

//		User a = new User(5, "jae", "manager");
//		dao.save(a);
//		a = new User(5, "airton", "password");
//		dao.save(a);
		
		User u = dao.findByUsernamePassword("jae", "manager");
		System.out.println(u);
	}
}
