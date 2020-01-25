package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.FriendList;

@Service
public class FriendListService {

	@Autowired
	private FriendList friendList; 
	
	
}
