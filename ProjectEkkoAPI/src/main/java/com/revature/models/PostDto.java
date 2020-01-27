package com.revature.models;

import java.util.Objects;

public class PostDto {

	private String content;
	private int uid;

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDto(String content, int uid) {
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
		if (!(obj instanceof PostDto)) {
			return false;
		}
		PostDto other = (PostDto) obj;
		return Objects.equals(content, other.content) && uid == other.uid;
	}

	@Override
	public String toString() {
		return "PostDto [content=" + content + ", uid=" + uid + "]";
	}

}
