package com.revature.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Reaction;
import com.revature.models.User;
import com.revature.util.Log;

@Repository
public class ReactionDaoImpl implements ReactionDao {

	@Autowired
	private SessionFactory sf;

	@Autowired
	private Log log;

	private static final int PAGE_COUNT = 10;

	@Override
	@Transactional
	public List<Reaction> getReactionsByPostId(int pid) {

		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Reaction> cr = cb.createQuery(Reaction.class);
		Root<Reaction> root = cr.from(Reaction.class);

		// creates query
		CriteriaQuery<Reaction> selectedQuery = cr.select(root).where(cb.equal(root.get("parentPost").get("id"), pid));

		Query<Reaction> query = s.createQuery(selectedQuery);

		// executes query
		List<Reaction> reactions = query.getResultList();
		return reactions;
	}

	@Override
	@Transactional
	public List<Reaction> getReactionsByCommentId(int cid) {


		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Reaction> cr = cb.createQuery(Reaction.class);
		Root<Reaction> root = cr.from(Reaction.class);

		// creates query
		CriteriaQuery<Reaction> selectedQuery = cr.select(root)
				.where(cb.equal(root.get("parentComment").get("id"), cid));

		Query<Reaction> query = s.createQuery(selectedQuery);

		// executes query
		List<Reaction> reactions = query.getResultList();
		return reactions;
	}

	@Override
	@Transactional
	public void save(Reaction reaction) {
		Session s = sf.getCurrentSession();
		s.save(reaction);
	}

	@Override
	@Transactional
	public int getMaxPagePostReaction(int pid) {
		Session s = sf.getCurrentSession();

		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Reaction> root = cr.from(Reaction.class);
		cr.multiselect(cb.count(root));
		cr.where(cb.equal(root.get("parentPost").get("id"), pid));
		long result = s.createQuery(cr).getSingleResult();
		log.info("Count of result: " + result);
		int page = (int) Math.ceil(result / (double) PAGE_COUNT);
		return page;
	}

	@Override
	@Transactional
	public int getMaxPageCommentReaction(int cid) {
		Session s = sf.getCurrentSession();

		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Reaction> root = cr.from(Reaction.class);
		cr.multiselect(cb.count(root));
		cr.where(cb.equal(root.get("parentComment").get("id"), cid));
		long result = s.createQuery(cr).getSingleResult();
		log.info("Count of result: " + result);
		int page = (int) Math.ceil(result / (double) PAGE_COUNT);
		return page;
	}

	@Override
	@Transactional
	public void delete(Reaction reaction) {
		Session s = sf.getCurrentSession();
		s.delete(reaction);
	}
}
