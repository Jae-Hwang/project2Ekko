package com.revature.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.daos.IUserDao;
import com.revature.models.User;

public class UserDao implements IUserDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	public User findByUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
