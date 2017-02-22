package com.anupam.snake.config;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.param.Default;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	@Configurable
	@Default("admin")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}