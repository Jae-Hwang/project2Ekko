package com.revature.drivers;

import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.PostDao;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.Reaction;

public class TestDriver {
	
	public static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PostDao postDao = (PostDao) ac.getBean("postDaoImpl");
		
		postDao.save(new Post(0, "Test Post 1", null, new HashSet<Comment>(), new HashSet<Reaction>(), null));
		
		List<Post> posts = postDao.findAll(0);
		
		log.info(posts);
		
		for (Post post : posts) {
			log.info(post.toString());
		}
		
		
		
		
	}
}
