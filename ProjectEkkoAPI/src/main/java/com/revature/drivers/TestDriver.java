package com.revature.drivers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.CommentDao;
import com.revature.daos.PostDao;
import com.revature.daos.ReactionDao;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.Reaction;
import com.revature.models.User;

public class TestDriver {

	public static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		PostDao postDao = (PostDao) ac.getBean("postDaoImpl");
		CommentDao commentDao = (CommentDao) ac.getBean("commentDaoImpl");
		ReactionDao reactionDao = (ReactionDao) ac.getBean("reactionDaoImpl");

//		for (int i = 0; i < 10; ++i) {
//			postDao.save(new Post(0, "airton Test Post" + i, new User(153, "", ""), new HashSet<Comment>(), new HashSet<Reaction>(), null));
//		}
//		
//		for (int i = 0; i < 10; ++i) {
//			postDao.save(new Post(0, "Test Post" + i, new User(152, "", ""), new HashSet<Comment>(), new HashSet<Reaction>(), null));
//		}

		List<Post> posts = postDao.findAll(1);
		for (Post post : posts) {
			log.info(post.toString());
		}

		posts = postDao.findByUserId(152, 1);
		for (Post post : posts) {
			log.info(post.toString());
		}

		// commentDao.save(new Comment(0, "Test Comment 3", new User(152, "", ""), new
		// Post(753), new HashSet<>(), null));

		List<Comment> comments = commentDao.getCommentsByPostId(753);
		for (Comment comment : comments) {
			log.info(comment);
		}

//		reactionDao.save(new Reaction(0, new User(152, "", ""), 1, new Post(753), null));
//		reactionDao.save(new Reaction(0, new User(152, "", ""), 2, new Post(753), null));
//		reactionDao.save(new Reaction(0, new User(152, "", ""), 3, new Post(753), null));
//		reactionDao.save(new Reaction(0, new User(153, "", ""), 1, null, new Comment(1)));
//		reactionDao.save(new Reaction(0, new User(153, "", ""), 2, null, new Comment(1)));
//		reactionDao.save(new Reaction(0, new User(153, "", ""), 3, null, new Comment(1)));
		
		reactionDao.delete(new Reaction(6));

		List<Reaction> reactions = reactionDao.getReactionsByPostId(753);
		for (Reaction reaction : reactions) {
			log.info(reaction);
		}

		reactions = reactionDao.getReactionsByCommentId(1);
		for (Reaction reaction : reactions) {
			log.info(reaction);
		}
		
		log.info("Page count for Reaction with pid 753: " + reactionDao.getMaxPagePostReaction(753));

	}
}
