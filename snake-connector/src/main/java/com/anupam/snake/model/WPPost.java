package com.anupam.snake.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WPPost {

	private String ID;
	private String site_ID;
	private String date;
	private String modified;
	private String title;
	private String URL;
	private String short_URL;

	private WPAuthor author;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSite_ID() {
		return site_ID;
	}

	public void setSite_ID(String site_ID) {
		this.site_ID = site_ID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getShort_URL() {
		return short_URL;
	}

	public void setShort_URL(String short_URL) {
		this.short_URL = short_URL;
	}

	public WPAuthor getAuthor() {
		return author;
	}

	public void setAuthor(WPAuthor author) {
		this.author = author;
	}

}
