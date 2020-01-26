package com.revature.models;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class ReactionDto {

	int uid;
	private int type;

	public ReactionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReactionDto(int uid, int type) {
		super();
		this.uid = uid;
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ReactionDto)) {
			return false;
		}
		ReactionDto other = (ReactionDto) obj;
		return type == other.type && uid == other.uid;
	}

	@Override
	public String toString() {
		return "ReactionDto [uid=" + uid + ", type=" + type + "]";
	}

}
