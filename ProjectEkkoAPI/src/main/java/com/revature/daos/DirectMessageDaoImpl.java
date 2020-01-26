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

import com.revature.models.DirectMessage;

// The implementation of the DAO receives the @Repo 
@Repository
public class DirectMessageDaoImpl implements DirectMessageDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public List<DirectMessage> findById(int id) {
		Session s = sf.getCurrentSession();
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
		
		CriteriaQuery<DirectMessage> cq = cb.createQuery(DirectMessage.class);
		
		Root<DirectMessage> m = cq.from(DirectMessage.class);
		
		Predicate u1 = cb.equal(m.get("user1Id"), id);
		Predicate u2 = cb.equal(m.get("user2Id"), id);

		cq.select(m).where(cb.or(u1, u2));
		
		Query<DirectMessage> query = s.createQuery(cq);
		
		List<DirectMessage> dirMsgs = query.getResultList();
		
		return dirMsgs;
	}

	@Override
	@Transactional
	public void save(DirectMessage m) {
		Session s = sf.getCurrentSession();
		s.save(m);
	}

}
