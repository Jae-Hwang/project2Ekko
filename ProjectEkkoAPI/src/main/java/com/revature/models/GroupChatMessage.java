package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "chat_messsage")
@Component
public class GroupChatMessage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="chat_message_seq_gen")
	@SequenceGenerator(name="chat_message_seq_gen", sequenceName="CHAT_MESSAGE_SEQ")
	@Column(name = "chat_message_id")
	private int id;
	
	@Column(name = "chat_message")
	private String chatMessage;
	
	@ManyToOne // Inversely connect the message to the chat
	@JoinColumn(name = "parent")
	private GroupChat groupChat;

	public GroupChatMessage() {
		super();
	}
	
	public GroupChatMessage(int id) {
		super();
		this.id = id;
	}

	public GroupChatMessage(String chatMessage) {
		super();
		this.chatMessage = chatMessage;
	}
	
	public GroupChatMessage(GroupChat groupChat) {
		super();
		this.groupChat = groupChat;
	}


	public GroupChatMessage(int id, String chatMessage) {
		super();
		this.id = id;
		this.chatMessage = chatMessage;
	}
	
	public GroupChatMessage(int id, String chatMessage, GroupChat groupChat) {
		super();
		this.id = id;
		this.chatMessage = chatMessage;
		this.groupChat = groupChat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChatMessage() {
		return chatMessage;
	}

	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}
	
	public GroupChat getGroupChat() {
		return groupChat;
	}

	public void setGroupChat(GroupChat groupChat) {
		this.groupChat = groupChat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chatMessage, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof GroupChatMessage)) {
			return false;
		}
		GroupChatMessage other = (GroupChatMessage) obj;
		return Objects.equals(chatMessage, other.chatMessage) && id == other.id;
	}

	@Override
	public String toString() {
		return "GroupChatMessage [id=" + id + ", chatMessage=" + chatMessage + "]";
	}
	
}
