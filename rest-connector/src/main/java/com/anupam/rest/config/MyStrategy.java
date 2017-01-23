package com.anupam.rest.config;

import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;

@ConnectionManagement(friendlyName = "User Authentication")
public class MyStrategy {

	@Connect
	@TestConnectivity
	public void connect(@ConnectionKey String username, @Password String password) {

	}

	@Disconnect
	public void disconnect() {

	}

	@ValidateConnection
	public boolean isConnected() {
		return true;
	}

	@ConnectionIdentifier
	public String connectionId() {
		return "";
	}
}
