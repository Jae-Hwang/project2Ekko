package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "messages")
@Component
public class Message implements Serializable{
	
	private static final long serialVersionUID = 3519192776120105137L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "message_seq_gen")
	@SequenceGenerator(name = "message_seq_gen", sequenceName = "MESSAGE_SEQ")
	@Column(name = "m_id")
	private int id;
	
	@Column(name = "user1_id") // add not null later
	private int user1Id;
	
	@Column(name = "user2_id")
	private int user2Id;
	
	@Column(name = "message")
	private String message;

	public Message() {
		super();
	}

	public Message(int id, int user1Id, int user2Id, String message) {
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
		if (!(obj instanceof Message)) {
			return false;
		}
		Message other = (Message) obj;
		return id == other.id && Objects.equals(message, other.message) && user1Id == other.user1Id
				&& user2Id == other.user2Id;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", user1Id=" + user1Id + ", user2Id=" + user2Id + ", message=" + message + "]";
	}

}
