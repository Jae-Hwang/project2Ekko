package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "direct_messages")
@Component
public class DirectMessage implements Serializable{
	
	private static final long serialVersionUID = 1288292659205422689L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dir_msg_seq_gen")
	@SequenceGenerator(name = "dir_msg_seq_gen", sequenceName = "DIRECT_MSG_SEQ")
	@Column(name = "dir_msg_id")
	private int id;
	
	@Column(name = "user1_id") // add not null later
	private int user1Id;
	
	@Column(name = "user2_id")
	private int user2Id;
	
	@Column(name = "message")
	private String message;

	public DirectMessage() {
		super();
	}
	
	public DirectMessage(int id) {
		super();
		this.id = id;
	}

	public DirectMessage(int user1Id, int user2Id, String message) {
		super();
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.message = message;
	}

	public DirectMessage(int id, int user1Id, int user2Id, String message) {
		super();
		this.id = id;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser1Id() {
		return user1Id;
	}

	public void setUser1Id(int user1Id) {
		this.user1Id = user1Id;
	}

	public int getUser2Id() {
		return user2Id;
	}

	public void setUser2Id(int user2Id) {
		this.user2Id = user2Id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message, user1Id, user2Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DirectMessage)) {
			return false;
		}
		DirectMessage other = (DirectMessage) obj;
		return id == other.id && Objects.equals(message, other.message) && user1Id == other.user1Id
				&& user2Id == other.user2Id;
	}

	@Override
	public String toString() {
		return "DirectMessage [id=" + id + ", user1Id=" + user1Id + ", user2Id=" + user2Id + ", message=" + message
				+ "]";
	}
	
}
