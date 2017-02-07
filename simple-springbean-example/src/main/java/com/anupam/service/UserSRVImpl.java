package com.anupam.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.anupam.bean.User;

//@Service(value="userService")
public class UserSRVImpl implements UserSRV {

//	@Inject
	private User user;
	
	@Override
	public String sayHello() {
		
		return "Hello from "+user.getFirstName();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
