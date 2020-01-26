package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDao;
import com.revature.models.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao; 
	
	public User findByUsernamePassword(String user, String pass) {
		return userDao.findByUsernamePassword(user, pass);
	}
	
	public void save(User u) {
		userDao.save(u);
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	};
}
