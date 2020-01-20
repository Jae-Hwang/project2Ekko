package com.revature.models;

import java.util.List;

public class Post {
	
	private int id;
	
	private String content;
	
	private User owner;
	
	private List<Reaction> reactions;
	
	private List<Comment> comments;
}
