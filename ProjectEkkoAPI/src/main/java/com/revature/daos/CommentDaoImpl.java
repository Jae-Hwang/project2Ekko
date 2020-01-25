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

import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.util.Log;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private SessionFactory sf;

	@Autowired
	private Log log;

	private static final int PAGE_COUNT = 10;

	@Override
	@Transactional
	public List<Comment> getCommentsByPostId(int pid, int page) {

		if (page < 1) {
			page = 1;
		}

		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Comment> cr = cb.createQuery(Comment.class);
		Root<Comment> root = cr.from(Comment.class);

		// creates query
		CriteriaQuery<Comment> selectedQuery = cr.select(root).where(cb.equal(root.get("parent").get("id"), pid));

		// creates paging
		TypedQuery<Comment> typedQuery = s.createQuery(selectedQuery);
		typedQuery.setFirstResult((page - 1) * PAGE_COUNT);
		typedQuery.setMaxResults(PAGE_COUNT);

		// executes query
		List<Comment> comments = typedQuery.getResultList();
		return comments;
	}

	@Override
	@Transactional
	public void save(Comment comment) {
		Session s = sf.getCurrentSession();
		s.save(comment);
	}

	@Override
	public int getMaxPageByPostId(int pid) {
		Session s = sf.getCurrentSession();

		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Comment> root = cr.from(Comment.class);
		cr.multiselect(cb.count(root));
		cr.where(cb.equal(root.get("parent").get("id"), pid));
		long result = s.createQuery(cr).getSingleResult();
		log.info("Count of result: " + result);
		int page = (int) Math.ceil(result / (double) PAGE_COUNT);
		return page;
	}

}
