package com.ybachhas.transactionConnector;

import static org.mule.runtime.extension.api.annotation.param.MediaType.TEXT_PLAIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Placement;

public class TransactionOperations {
	@Parameter
	@DisplayName("Transaction Properties")
	@Placement(order = 1)
	private String transactionProperties;

	@Parameter
	@DisplayName("Stage")
	@Placement(order = 2)
	private String stage;

	@Parameter
	@DisplayName("Status")
	@Placement(order = 3)
	private String status;

	@Parameter
	@DisplayName("JSON Record")
	@Placement(order = 4)
	private String jsonRecord;

	@Parameter
	@DisplayName("Detail Text")
	@Placement(order = 5)
	private String detailText;

	private static String URL = null;
	private static String USERNAME = null;
	private static String PASSWORD = null;
	private static String SELECT_QUERY = "select * from test";

	@DisplayName("Save Transaction")
	@MediaType(value = TEXT_PLAIN, strict = false)
	public String SaveTransaction(@Config TransactionConfiguration config) {
		System.out.println("*************************" + config.getHost() + "*************************");
		URL = config.getHost();
		USERNAME = config.getUsername();
		PASSWORD = config.getPassword();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println("resultSet");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "SaveTransaction() executed successfully";
	}
}
