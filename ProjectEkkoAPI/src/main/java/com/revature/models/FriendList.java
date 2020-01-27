package com.revature.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "friendlist")
@Component
public class FriendList {

	@Id
	@JoinColumn(name = "owner", referencedColumnName = "user_id")
	private int id;
	
	@Column(name = "friends")
	@ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

	public FriendList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendList(int id, Set<User> users) {
		super();
		this.id = id;
		this.users = users;
	}

	public FriendList(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendList other = (FriendList) obj;
		if (id != other.id)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FriendList [id=" + id + ", users=" + users + "]";
	}
	
	
}
