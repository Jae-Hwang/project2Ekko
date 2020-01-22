package com.revature.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Reaction;

@Repository
public class ReactionDaoImpl implements ReactionDao {

	@Autowired
	private SessionFactory sf;

	private static final int PAGE_COUNT = 10;

	@Override
	@Transactional
	public List<Reaction> getReactionsByPostId(int pid, int page) {

		if (page < 1) {
			page = 1;
		}

		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Reaction> cr = cb.createQuery(Reaction.class);
		Root<Reaction> root = cr.from(Reaction.class);

		// creates query
		CriteriaQuery<Reaction> selectedQuery = cr.select(root).where(cb.equal(root.get("parentPost").get("id"), pid));

		// creates paging
		TypedQuery<Reaction> typedQuery = s.createQuery(selectedQuery);
		typedQuery.setFirstResult((page - 1) * PAGE_COUNT);
		typedQuery.setMaxResults(PAGE_COUNT);

		// executes query
		List<Reaction> reactions = typedQuery.getResultList();
		return reactions;
	}

	@Override
	@Transactional
	public List<Reaction> getReactionsByCommentId(int cid, int page) {

		if (page < 1) {
			page = 1;
		}

		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Reaction> cr = cb.createQuery(Reaction.class);
		Root<Reaction> root = cr.from(Reaction.class);

		// creates query
		CriteriaQuery<Reaction> selectedQuery = cr.select(root).where(cb.equal(root.get("parentComment").get("id"), cid));

		// creates paging
		TypedQuery<Reaction> typedQuery = s.createQuery(selectedQuery);
		typedQuery.setFirstResult((page - 1) * PAGE_COUNT);
		typedQuery.setMaxResults(PAGE_COUNT);

		// executes query
		List<Reaction> reactions = typedQuery.getResultList();
		return reactions;
	}

	@Override
	@Transactional
	public void save(Reaction reaction) {
		Session s = sf.getCurrentSession();
		s.save(reaction);
	}

}
