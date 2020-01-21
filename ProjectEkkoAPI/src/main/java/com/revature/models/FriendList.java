package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "friendlist")
@Component
public class FriendList {

	@Id
	@Column(name = "owner_id")
	private int id;
	
	@OneToMany(fetch = FetchType.EAGER)
    private List<User> users;
	
}
