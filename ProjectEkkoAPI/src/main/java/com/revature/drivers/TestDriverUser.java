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

		UserDao dao = (UserDao) ac.getBean("userDaoImpl");
		FriendListDao fdao = (FriendListDao) ac.getBean("friendListDaoImpl");
		//User a = new User(5, "jae", "manager");
		//dao.save(a);
		User u = dao.findByUsernamePassword("jae", "manager");
		System.out.println(u);
		User v = dao.findByUsernamePassword("fermin", "password");
		System.out.println(v);
		//User u = dao.FindById(152);
		//System.out.println(u);
		//fdao.findAll();
		//fdao.saveFriends(1002, u);
		//fdao.saveFriends(1002, new User(1052,"",""));
		//User w = dao.findByUsername("fermin");
		//System.out.println(w);
		//fdao.updateFriends(1002, new User(1052,"",""));
		System.out.println(fdao.findAll(1002));

	}
}
