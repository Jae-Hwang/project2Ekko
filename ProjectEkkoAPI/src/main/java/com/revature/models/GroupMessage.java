package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "group_messages")
@Component
public class GroupMessage implements Serializable {

	private static final long serialVersionUID = 931894884181769934L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "group_message_seq_gen")
	@SequenceGenerator(name = "group_message_seq_gen", sequenceName = "GROUP_MESSAGE_SEQ")
	@Column(name = "g_id")
	private int id;

	@Column(name = "g_user_id")
	private int gUserId;

	@Column(name = "g_message")
	private String gMessage;
	
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "group_message_mgs",
				joinColumns = {@JoinColumn(name = "source_id", referencedColumnName = "g_id")},
				inverseJoinColumns = {@JoinColumn(name = "target_id", referencedColumnName = "u_id")})
	private List<GroupMessage> groupMessages;

	public GroupMessage() {
		super();
	}

	public GroupMessage(int id, int gUserId, String gMessage) {
		super();
		this.id = id;
		this.gUserId = gUserId;
		this.gMessage = gMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getgUserId() {
		return gUserId;
	}

	public void setgUserId(int gUserId) {
		this.gUserId = gUserId;
	}

	public String getgMessage() {
		return gMessage;
	}

	public void setgMessage(String gMessage) {
		this.gMessage = gMessage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gMessage, gUserId, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof GroupMessage)) {
			return false;
		}
		GroupMessage other = (GroupMessage) obj;
		return Objects.equals(gMessage, other.gMessage) && gUserId == other.gUserId && id == other.id;
	}

	@Override
	public String toString() {
		return "GroupMessage [id=" + id + ", gUserId=" + gUserId + ", gMessage=" + gMessage + "]";
	}
}
