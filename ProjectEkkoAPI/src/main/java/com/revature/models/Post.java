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
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "posts")
@Component
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "post_id_seq_gen")
	@SequenceGenerator(name = "post_id_seq_gen", sequenceName = "POST_ID_SEQ")
	@Column(name = "pid")
	private int id;

	@Column(name = "content")
	private String content;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner", referencedColumnName = "user_id")
	private User owner;

	@JsonManagedReference
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<Comment> comments;

	@JsonManagedReference
	@OneToMany(mappedBy = "parentPost", fetch = FetchType.EAGER)
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

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int id, String content, User owner, Set<Comment> comments, Set<Reaction> reactions, Date upserted) {
		super();
		this.id = id;
		this.content = content;
		this.owner = owner;
		this.comments = comments;
		this.reactions = reactions;
		this.upserted = upserted;
	}

	public Post(int id) {
		super();
		this.id = id;
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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
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
		return Objects.hash(comments, content, id, owner, reactions, upserted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Post)) {
			return false;
		}
		Post other = (Post) obj;
		return Objects.equals(comments, other.comments) && Objects.equals(content, other.content) && id == other.id
				&& Objects.equals(owner, other.owner) && Objects.equals(reactions, other.reactions)
				&& Objects.equals(upserted, other.upserted);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", owner=" + owner + ", comments=" + comments
				+ ", reactions=" + reactions + ", upserted=" + upserted + "]";
	}

}
