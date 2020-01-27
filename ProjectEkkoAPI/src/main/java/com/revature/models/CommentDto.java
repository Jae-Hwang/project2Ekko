package com.revature.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class CommentDto {

	private String content;
	private int uid;

	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDto(String content, int uid) {
		super();
		this.content = content;
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CommentDto)) {
			return false;
		}
		CommentDto other = (CommentDto) obj;
		return Objects.equals(content, other.content) && uid == other.uid;
	}

	@Override
	public String toString() {
		return "CommentDto [content=" + content + ", uid=" + uid + "]";
	}

}
