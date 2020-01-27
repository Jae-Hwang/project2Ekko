package com.revature.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.FriendList;
import com.revature.models.User;

@Repository
public class FriendListDaoImpl implements FriendListDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<User> findAll(int owner) {
		Session s = sf.getCurrentSession();
		List<User> user = new ArrayList<User>(s.get(FriendList.class,owner).getUsers());
		List <User> newuser = new ArrayList<User>();
		for(User u: user) {
			User m = new User();
			m.setId(u.getId());
			m.setUsername(u.getUsername());
			newuser.add(m);
		}
		return newuser;
	}

	@Override
	@Transactional
	public List<FriendList> findById(int id) {
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<FriendList> cr = cb.createQuery(FriendList.class);
		Root<FriendList> root = cr.from(FriendList.class);
		Predicate userN = cb.equal(root.get("owner"), id);
		cr.select(root).where(cb.and(userN));;
		
		Query<FriendList> query = s.createQuery(cr);
		List<FriendList> Friends = query.getResultList();
		return Friends;
	}

	@Override
	@Transactional
	public void updateFriends(int owner, User friend) {
		Session s = sf.getCurrentSession();
		FriendList friends = s.get(FriendList.class,owner);
		Set<User> users = friends.getUsers();
		users.add(friend);
		friends.setUsers(users);
		s.update(friends);
	}

	@Override
	@Transactional
	public void saveFriends(int owner, User friend) {
		Session s = sf.getCurrentSession();
		Set<User> friends = new HashSet<User>();
		friends.add(friend);
		FriendList fl = new FriendList(owner, friends);
		s.save(fl);
		
	}
	
	

}
