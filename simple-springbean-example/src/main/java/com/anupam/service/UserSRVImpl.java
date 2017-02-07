package com.anupam.service;

import javax.inject.Inject;

import com.anupam.bean.User;

public class UserSRVImpl implements UserSRV {

	@Inject
	private User user;
	
	@Override
	public String sayHello() {
		
		return "Hello from "+user.getFirstName();
	}

}
