package com.anupam.service;

import com.anupam.bean.User;

public class UserSRVImpl implements UserSRV {

	private User user;

	@Override
	public String sayHello() {

		return "Hello from " + user.getFirstName();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
