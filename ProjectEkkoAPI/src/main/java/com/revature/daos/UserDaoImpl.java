package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.UserDao;
import com.revature.models.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public User findByUsernamePassword(String user, String pass) {
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<User> cr = cb.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		Predicate userN = cb.equal(root.get("username"), user);
		Predicate passW = cb.equal(root.get("password"), pass);
		cr.select(root).where(cb.and(userN, passW));;
		
		Query<User> query = s.createQuery(cr);
		List<User> Finaluser = query.getResultList();
		return Finaluser.get(0);
	}

	@Override
	@Transactional
	public void save(User u) {
		Session s = sf.getCurrentSession();
		s.save(u);
		
	}

	@Override
	public User FindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
