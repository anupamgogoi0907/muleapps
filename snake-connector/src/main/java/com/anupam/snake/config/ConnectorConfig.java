package com.anupam.snake.config;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.display.Summary;
import org.mule.api.annotations.param.Default;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	@Configurable
	@Default("Hello")
	@Summary(value = "The blog url.Please do not use the prefix http:// or https://. E.g gocodeblog.wordpress.com")
	private String blogURL;

	public String getBlogURL() {
		return blogURL;
	}

	public void setBlogURL(String blogURL) {
		this.blogURL = blogURL;
	}

}