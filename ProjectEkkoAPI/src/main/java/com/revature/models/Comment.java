package com.revature.models;

import java.util.List;

public class Comment {
	
	private int id;
	
	private String content;
	
	private User owner;
	
	private Post parent;
	
	private List<Reaction> reactions;
	
	

}
