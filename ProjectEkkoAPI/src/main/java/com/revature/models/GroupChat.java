package com.revature.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "group_chat")
@Component
public class GroupChat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="group_chat_seq_gen")
	@SequenceGenerator(name="group_chat_seq_gen", sequenceName="GROUP_CHAT_SEQ")
	@Column(name = "group_chat_id")
	private int id;
	
	@Column(name = "group_chat_name")
	private String chatName;
	
	@Column // Testing
	@OneToMany(mappedBy = "groupChat", fetch = FetchType.EAGER) // Connects the one group chat to many messages
	private Set<GroupChatMessage> groupChatMessages;
	
	@Column // Testing
	@ManyToMany(mappedBy = "groupChatsIn")
	private Set<User> userList;

	public GroupChat() {
		super();
	}
	
	public GroupChat(int id) {
		super();
		this.id = id;
	}

	public GroupChat(String chatName) {
		super();
		this.chatName = chatName;
	}

	public GroupChat(int id, String chatName) {
		super();
		this.id = id;
		this.chatName = chatName;
	}

	public GroupChat(int id, String chatName, Set<GroupChatMessage> groupChatMessages) {
		super();
		this.id = id;
		this.chatName = chatName;
		this.groupChatMessages = groupChatMessages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public Set<GroupChatMessage> getGroupChatMessages() {
		return groupChatMessages;
	}

	public void setGroupChatMessages(Set<GroupChatMessage> groupChatMessages) {
		this.groupChatMessages = groupChatMessages;
	}

	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}
	
	// Adding message to group chat
	public void addMessage(GroupChatMessage gcm) {
		this.groupChatMessages.add(gcm);
	}

	@Override
	public int hashCode() {
		return Objects.hash(chatName, groupChatMessages, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof GroupChat)) {
			return false;
		}
		GroupChat other = (GroupChat) obj;
		return Objects.equals(chatName, other.chatName) && Objects.equals(groupChatMessages, other.groupChatMessages)
				&& id == other.id;
	}

	@Override
	public String toString() {
		return "GroupChat [id=" + id + ", chatName=" + chatName + ", groupChatMessages=" + groupChatMessages + "]";
	}
	
}
