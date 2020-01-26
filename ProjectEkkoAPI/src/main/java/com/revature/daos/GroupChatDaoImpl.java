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

import com.revature.models.GroupChat;
import com.revature.models.GroupChatMessage;

@Repository
public class GroupChatDaoImpl implements GroupChatDao{

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public void createGroupChat(GroupChat gc) {
		Session s = sf.getCurrentSession();
		s.save(gc);
	}

	@Override
	@Transactional
	public void creatGroupChatMessage(GroupChatMessage gcm) {
		Session s = sf.getCurrentSession();
		s.save(gcm);
	}

	@Override
	@Transactional
	public void update(GroupChat gc) {
		Session s = sf.getCurrentSession();
		System.out.println("updating");
		s.update(gc);
	}

	@Override
	@Transactional
	public GroupChat findChatById(int id) {
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<GroupChat> cq = cb.createQuery(GroupChat.class);
		Root<GroupChat> m = cq.from(GroupChat.class);
		Predicate cId = cb.equal(m.get("id"), id);
		cq.select(m).where(cId);
		Query<GroupChat> query = s.createQuery(cq);
		GroupChat groupChat = query.getResultList().get(0);
		return groupChat;
	}
	
	@Override
	@Transactional
	public List<GroupChat> findGroupChats() {
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<GroupChat> cq = cb.createQuery(GroupChat.class);
		Root<GroupChat> root = cq.from(GroupChat.class);
		cq.select(root);
		Query<GroupChat> query = s.createQuery(cq);
		List<GroupChat> allChats = query.getResultList();
		return allChats;
	}

	@Override
	@Transactional
	public List<GroupChatMessage> findMessages() {
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<GroupChatMessage> cq = cb.createQuery(GroupChatMessage.class);
		Root<GroupChatMessage> root = cq.from(GroupChatMessage.class);
		cq.select(root);
		Query<GroupChatMessage> query = s.createQuery(cq);
		List<GroupChatMessage> chatMsg = query.getResultList();
		return chatMsg;
	}

	@Override
	@Transactional
	public GroupChatMessage findMessageById(int id) {
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<GroupChatMessage> cq = cb.createQuery(GroupChatMessage.class);
		Root<GroupChatMessage> m = cq.from(GroupChatMessage.class);
		Predicate cId = cb.equal(m.get("id"), id);
		cq.select(m).where(cId);
		Query<GroupChatMessage> query = s.createQuery(cq);
		List<GroupChatMessage> groupChats = query.getResultList();
		GroupChatMessage converted = groupChats.get(0);
		return converted;
	}

}
