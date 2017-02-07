package com.anupam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.anupam.bean.User;

@Configuration
@ComponentScan(basePackages="com.anupam.service")
public class MySpringConfig {

	@Bean
	public User userBean() {
		User user = new User();
		user.setFirstName("Java Configuration");
		return user;
	}

}
