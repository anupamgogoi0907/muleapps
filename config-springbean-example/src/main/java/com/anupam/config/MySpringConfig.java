package com.anupam.config;

import org.springframework.context.annotation.Bean;

import com.anupam.bean.User;
import com.anupam.service.UserSRVImpl;

//@Configuration
public class MySpringConfig {

	@Bean(name = "userBean")
	public User userBean() {
		User user = new User();
		user.setFirstName("Java Configuration");
		return user;
	}

	@Bean(name = "userService")
	public UserSRVImpl userService() {
		UserSRVImpl userService = new UserSRVImpl();
		userService.setUser(userBean());
		return userService;
	}

}
