package com.revature.daos;

import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.FriendList;
import com.revature.models.User;

public class FriendListDaoImpl implements FriendListDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<FriendList> findAll() {
		// TODO Auto-generated method stub
		return null;
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
	public void updateFriends(int owner, User friend) {
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<FriendList> cr = cb.createQuery(FriendList.class);
		Root<FriendList> root = cr.from(FriendList.class);
		Predicate userN = cb.equal(root.get("owner"), owner);
		cr.select(root).where(cb.and(userN));;
		
		Query<FriendList> query = s.createQuery(cr);
		List<FriendList> Friends = query.getResultList();
		Set<User> newFriends = Friends.get(0).getUsers();
		newFriends.add(friend);
		
		CriteriaUpdate<FriendList> update = cb.createCriteriaUpdate(FriendList.class);
		update.set("friends", newFriends);
		update.where(cb.equal(root.get("owner"), owner));
		s.createQuery(update).executeUpdate();
	}

	@Override
	public void saveFriends(int owner, User friend) {
		Session s = sf.getCurrentSession();
		List<User> friends = new ArrayList<User>();
		
	}
	
	

}
