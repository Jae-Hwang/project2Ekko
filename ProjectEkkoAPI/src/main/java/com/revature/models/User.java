package com.revature.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
	@Column
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;

	/*
	private List<User> friends;
	
	private List<Post> posts;
	
	private List<Comment> comments;
	
	private List<Reaction> reactions;
	
	private List<FriendRequest> friendRequests;
	*/
}
