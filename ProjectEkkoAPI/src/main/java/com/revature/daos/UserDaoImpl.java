package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public User findByUsernamePassword(String username, String password) {
		Session s = sf.getCurrentSession();
		User user = (User) s.createNativeQuery("SELECT * " +
					"FROM users " +
					"WHERE username = :name AND password = :pass" )
					.setParameter("name", username)
					.setParameter("pass", password);
		return user;
	}

	@Override
	@Transactional
	public void save(User u) {
		Session s = sf.getCurrentSession();
		s.save(u);
		
	}

}
