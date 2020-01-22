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
@Table(name = "reactions")
@Component
public class Reaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reaction_id_seq_gen")
	@SequenceGenerator(name = "reaction_id_seq_gen", sequenceName = "REACTION_ID_SEQ")
	@Column(name = "rid")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner", referencedColumnName = "user_id")
	private User owner;

	@Column(name = "type")
	private int type;

	public Reaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reaction(int id, User owner, int type) {
		super();
		this.id = id;
		this.owner = owner;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, owner, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reaction)) {
			return false;
		}
		Reaction other = (Reaction) obj;
		return id == other.id && Objects.equals(owner, other.owner) && type == other.type;
	}

	@Override
	public String toString() {
		return "Reaction [id=" + id + ", owner=" + owner + ", type=" + type + "]";
	}

}
