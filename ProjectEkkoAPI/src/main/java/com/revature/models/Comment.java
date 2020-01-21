package com.revature.models;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "comments")
@Component
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "comment_id_seq_gen")
	@SequenceGenerator(name = "comment_id_seq_gen", sequenceName = "COMMENT_ID_SEQ")
	@Column(name = "cid")
	private int id;

	@Column(name = "content")
	private String content;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner", referencedColumnName = "user_id")
	private User owner;

	@ManyToOne
	@JoinColumn(name = "parent")
	private Post parent;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Reaction> reactions;

	@Column(name = "upserted")
	private Date upserted;

	@PrePersist
	protected void onCreate() {
		upserted = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		upserted = new Date();
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String content, User owner, Post parent, Set<Reaction> reactions, Date upserted) {
		super();
		this.id = id;
		this.content = content;
		this.owner = owner;
		this.parent = parent;
		this.reactions = reactions;
		this.upserted = upserted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Post getParent() {
		return parent;
	}

	public void setParent(Post parent) {
		this.parent = parent;
	}

	public Set<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(Set<Reaction> reactions) {
		this.reactions = reactions;
	}

	public Date getUpserted() {
		return upserted;
	}

	public void setUpserted(Date upserted) {
		this.upserted = upserted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, owner, parent, reactions, upserted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Comment)) {
			return false;
		}
		Comment other = (Comment) obj;
		return Objects.equals(content, other.content) && id == other.id && Objects.equals(owner, other.owner)
				&& Objects.equals(parent, other.parent) && Objects.equals(reactions, other.reactions)
				&& Objects.equals(upserted, other.upserted);
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", owner=" + owner + ", parent=" + parent + ", reactions="
				+ reactions + ", upserted=" + upserted + "]";
	}

}
