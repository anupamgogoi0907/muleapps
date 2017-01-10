package com.anupam.rest;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.display.Summary;
import org.springframework.web.client.RestTemplate;

import com.anupam.rest.config.ConnectorConfig;

@Connector(name = "rest", friendlyName = "WordPress")
public class RestConnector {

	@Config
	ConnectorConfig config;

	@Processor
	public String getPosts(
			@Summary(value = "Enter coma separated parameters.Acceptable parameters are: ID,title,URL") String field) {
		RestTemplate template = new RestTemplate();

		String url = "https://public-api.wordpress.com/rest/v1.1/sites/";
		url = url.concat(config.getSite()).concat("/posts?fields=").concat(field);
		String result = template.getForObject(url, String.class);
		return result;
	}

	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

}