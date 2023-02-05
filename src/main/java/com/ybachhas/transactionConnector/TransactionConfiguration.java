package com.ybachhas.transactionConnector;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;

@Operations(TransactionOperations.class)
public class TransactionConfiguration {
	@Parameter
	@DisplayName("Host")
	@Placement(order = 1)
	private String host;

	@Parameter
	@DisplayName("Username")
	@Placement(order = 2)
	private String username;

	@Parameter
	@DisplayName("Password")
	@Placement(order = 3)
	private String password;

	@Parameter
	@DisplayName("Port")
	@Placement(order = 4)
	private String port;

	@Parameter
	@DisplayName("Database")
	@Placement(order = 5)
	private String database;

	public String getHost() {
		return host;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPort() {
		return port;
	}

	public String getDatabase() {
		return database;
	}
}
