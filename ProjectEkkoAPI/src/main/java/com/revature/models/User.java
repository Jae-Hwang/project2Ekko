package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "user_id")
	private int id;
	
	private String username;
	
	private String password;

	/*
	 * private List<User> friends;
	 * 
	 * private List<Post> posts;
	 * 
	 * private List<Comment> comments;
	 * 
	 * private List<Reaction> reactions;
	 * 
	 * private List<FriendRequest> friendRequests;
	 */
}
