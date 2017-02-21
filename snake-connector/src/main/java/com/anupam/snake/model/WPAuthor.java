package com.anupam.snake.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WPAuthor {

	private String ID;
	private String login;
	private String email;
	private String name;
	private String first_name;
	private String last_name;
	private String nice_name;
	private String URL;
	private String avatar_URL;
	private String profile_URL;
	private String site_ID;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getNice_name() {
		return nice_name;
	}
	public void setNice_name(String nice_name) {
		this.nice_name = nice_name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getAvatar_URL() {
		return avatar_URL;
	}
	public void setAvatar_URL(String avatar_URL) {
		this.avatar_URL = avatar_URL;
	}
	public String getProfile_URL() {
		return profile_URL;
	}
	public void setProfile_URL(String profile_URL) {
		this.profile_URL = profile_URL;
	}
	public String getSite_ID() {
		return site_ID;
	}
	public void setSite_ID(String site_ID) {
		this.site_ID = site_ID;
	}
	
	
}
