package com.anupam.rest.config;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.display.Summary;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	@Configurable
	@Summary(value="Please enter the blog url without the prefix http:// or https://")
    private String site;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	

}