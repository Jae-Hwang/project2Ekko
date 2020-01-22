package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public List<Post> findAll(int page) {
		Session s = sf.getCurrentSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Post> cr = cb.createQuery(Post.class);
		Root<Post> root = cr.from(Post.class);
		cr.select(root);

		Query<Post> query = s.createQuery(cr);
		List<Post> posts = query.getResultList();
		return posts;
	}

	@Override
	@Transactional
	public List<Post> findByUserId(int uid, int page) {
		Session s = sf.getCurrentSession();
		return null;
	}

	@Override
	@Transactional
	public Post save(Post post) {
		Session s = sf.getCurrentSession();
		s.save(post);
		return null;
	}

}
