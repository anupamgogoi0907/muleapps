package com.anupam.snake.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Post {

	private List<WPPost> posts;

	public List<WPPost> getPosts() {
		return posts;
	}

	public void setPosts(List<WPPost> posts) {
		this.posts = posts;
	}
	
}
