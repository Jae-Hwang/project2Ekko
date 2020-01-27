package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.util.Log;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private Log log;

	private static final int PAGE_COUNT = 10;

	@Override
	@Transactional
	public List<Post> findAll(int page) {

		if (page < 1) {
			page = 1;
		}

		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Post> cr = cb.createQuery(Post.class);
		Root<Post> root = cr.from(Post.class);

		// creates query
		CriteriaQuery<Post> selectedQuery = cr.select(root);

		// creates paging
		TypedQuery<Post> typedQuery = s.createQuery(selectedQuery);
		typedQuery.setFirstResult((page - 1) * PAGE_COUNT);
		typedQuery.setMaxResults(PAGE_COUNT);

		// executes query
		List<Post> posts = typedQuery.getResultList();
		return posts;
	}

	@Override
	@Transactional
	public List<Post> findByUserId(int uid, int page) {

		if (page < 1) {
			page = 1;
		}

		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Post> cr = cb.createQuery(Post.class);
		Root<Post> root = cr.from(Post.class);
		cr.orderBy(cb.desc(root.get("upserted")));

		// creates query
		CriteriaQuery<Post> selectedQuery = cr.select(root).where(cb.equal(root.get("owner").get("id"), uid));

		// creates paging
		TypedQuery<Post> typedQuery = s.createQuery(selectedQuery);
		typedQuery.setFirstResult((page - 1) * PAGE_COUNT);
		typedQuery.setMaxResults(PAGE_COUNT);

		// executes query
		List<Post> posts = typedQuery.getResultList();
		return posts;
	}

	@Override
	@Transactional
	public void save(Post post) {
		Session s = sf.getCurrentSession();
		s.save(post);
	}

	@Override
	@Transactional
	public int getMaxPageUserId(int uid) {
		Session s = sf.getCurrentSession();

		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Post> root = cr.from(Post.class);
		cr.multiselect(cb.count(root));
		cr.where(cb.equal(root.get("owner").get("id"), uid));
		long result = s.createQuery(cr).getSingleResult();
		log.info("Count of result: " + result);
		int page = (int) Math.ceil(result / (double) PAGE_COUNT);
		log.info("Max Page: " + page);
		return page;
	}

	@Override
	@Transactional
	public List<Post> findByFriends(List<User> friends, int page) {

		if (page < 1) {
			page = 1;
		}

		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Post> cr = cb.createQuery(Post.class);
		Root<Post> root = cr.from(Post.class);
		cr.orderBy(cb.desc(root.get("upserted")));

		// creates query

		List<Predicate> ors = new ArrayList<>();
		for (User user : friends) {
			ors.add(cb.equal(root.get("owner").get("id"), user.getId()));
		}
		
		Predicate combined = ors.get(0);
		for (int i = 1; i < ors.size(); i++) {
			combined = cb.or(combined, ors.get(i));
		}

		CriteriaQuery<Post> selectedQuery = cr.select(root).where(combined);

		// creates paging
		TypedQuery<Post> typedQuery = s.createQuery(selectedQuery);
		typedQuery.setFirstResult((page - 1) * PAGE_COUNT);
		typedQuery.setMaxResults(PAGE_COUNT);

		// executes query
		List<Post> posts = typedQuery.getResultList();
		return posts;
	}

	@Override
	@Transactional
	public int getMaxPageFriends(List<User> friends) {
		Session s = sf.getCurrentSession();

		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Post> root = cr.from(Post.class);
		cr.multiselect(cb.count(root));
		
		List<Predicate> ors = new ArrayList<>();
		for (User user : friends) {
			ors.add(cb.equal(root.get("owner").get("id"), user.getId()));
		}
		
		Predicate combined = ors.get(0);
		for (int i = 1; i < ors.size(); i++) {
			combined = cb.or(combined, ors.get(i));
		}
		
		cr.where(combined);
		
		long result = s.createQuery(cr).getSingleResult();
		log.info("Count of result: " + result);
		int page = (int) Math.ceil(result / (double) PAGE_COUNT);
		log.info("Max Page: " + page);
		return page;
	}

}
