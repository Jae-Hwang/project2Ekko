package com.revature.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.FriendListDao;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class TestDriverUser {

	public static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		//UserDao dao = (UserDao) ac.getBean("userDaoImpl");
		//FriendListDao fdao = (FriendListDao) ac.getBean("friendlistDaoImpl");

		//User a = new User(5, "jae", "manager");
		//dao.save(a);
		//User u = dao.findByUsernamePassword("jae", "manager");
		//System.out.println(u);
		//User u = dao.FindById(152);
		//System.out.println(u);
		//fdao.findAll();
	}
}
